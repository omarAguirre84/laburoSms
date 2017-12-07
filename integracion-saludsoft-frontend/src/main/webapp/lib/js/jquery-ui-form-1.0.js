(function($) {  

	$.widget("ui.form",{
		
		options: {
			submit: null,
			enableFileTransfer:false,
			excludeClass: 'ui-form-exclude',
			datePicker: {
				selectorClass: "date",
				config: { 
					//buttonImage: "./../static/portal/jquery-portal-1.0/css/widgets/img/calendario/calendario.gif",
					showOn: "button",
					buttonImageOnly: true }
			},
			simpleSelect:{
				selectorClass: "simpleSelect"
			},
			multiselect: {
				selectorClass: "multiselect"
			},
			multiselectGroup: {
				selectorClass: "multiselectGroup"
			},
			multiselectFilter: {
				selectorClass: "multiselectFilter"
			},
			autocomplete: {
				selectorClass: "automcomplete"
			},
			validate: {
				errorPlacement: function(error, element) {
					element.after(error);
					error.css({position:"absolute",visibility:"hidden"});
					element.parent().css({position:"relative",display:"block"});					
				
					var errorIcon = $("<span class='error-icon'></span>"); 
					element.after(errorIcon);

					var showErrorMessage = function(){
						setTimeout(function(){
							if(element.hasClass("error")){
								error.fadeIn(100);
							}
						},100);
					};

					var hideErrorMessage = function(){
						setTimeout(function(){
							error.fadeOut(100);
						},100);
					};

					element.on("focusin",showErrorMessage);
					element.on("focusout",hideErrorMessage);
					errorIcon.on("mouseover",showErrorMessage);
					errorIcon.on("mouseout",hideErrorMessage);
				},
				highlight: function(element,errorClass){
					var element = $(element);
					element.addClass(errorClass);

					element.next(".error-icon").show();
					
					setTimeout(function(){
						var error = element.nextAll(".error");
						var parentFormPosition = element.parents("form").offset();
						var elementPosition = element.offset();

						var elementHeight = element.height();
						var elementWidth = element.width();

						if(error.css("visibility") == "hidden"){
							error.hide();
						}										

						error.css({left:parseInt(elementWidth*0.6)+"px", visibility:"visible"});

						var errorHeight = -error.outerHeight()+6;
					
						var totalHeight;
						if(elementPosition.top + errorHeight < parentFormPosition.top){
							totalHeight = elementHeight;
						} else {
							totalHeight = errorHeight;					
						}

						error.animate({top:totalHeight+"px"},100);

					},50);
					
				},
				unhighlight: function(element,errorClass){
					var element = $(element);
					element.removeClass(errorClass);
					element.next(".error-icon").hide();
				}
			}
		},

	_init: function() {
		var object = this;
		var form = this.element;
		var inputs = form.find("input , select ,textarea, label, button");
		 
		 
		form.find("legend").addClass("ui-widget-header ui-corner-all");
		form.addClass("ui-widget ui-form");

		$.each(inputs, function(i, element) {
			
			var exclude = false;
			
			// detect if the element must be exclude from decoration
			$.each($(this).parents(), function (i, parent) {
				if($(parent).hasClass(object.options.excludeClass)) {
					exclude = true;
				}
			});
			if($(element).hasClass(object.options.excludeClass)){
				exclude = true;
			}
			
			// decorate element
			if(!exclude) {
				
				if($(this).is(":reset ,:submit, :button"))
					object.buttons(this, object);
				else if($(this).is(":checkbox"))
					object.checkboxes(this);
				else if($(this).is("input[type='text']")||$(this).is("textarea")||$(this).is("input[type='password']"))
					object.textelements(this);
				else if($(this).is(":radio"))
					object.radio(this);
				else if($(this).is("label"))
					object.labels(this);
				else if($(this).is("button"))
					object.buttons(this);
				else if($(this).is("select")){
					
					if ( $(this).hasClass(object.options.simpleSelect.selectorClass) )
						object.simpleSelect(this, object);
					else if( $(this).hasClass(object.options.multiselect.selectorClass) )
						object.multiselect(this, object);
					else if( $(this).hasClass(object.options.multiselectGroup.selectorClass) )
						object.multiselectGroup(this, object);
					else if( $(this).hasClass(object.options.multiselectFilter.selectorClass) )
						object.multiselectFilter(this, object);
					else
						object.selector(this, object);

				}

				if($(this).hasClass(object.options.datePicker.selectorClass)) {
					object.dates(this, object);
				}

				if($(this).hasClass(object.options.autocomplete.selectorClass)) {
					object.autocomplete(this, object);
				}

			}
			
		});

		//prevent default submit
		form.on("submit",function(e){
			e.preventDefault();
		});
		
		//add validation to form
		form.validate(object.options.validate);
		if($.i18n.es.messages){
			$.each($.i18n.es.messages,function(i,message){
				message = $.validator.format(message);
			});
			$.extend($.validator.messages, $.i18n.es.messages);	
		}

		//add required fields mark
		if(object.options.validate && object.options.validate.rules){
			$.each(object.options.validate.rules,function(ruleName,value){
				var rule = object.options.validate.rules[ruleName];
				if(rule.required && rule.required != false){
					form.find("[name='"+ruleName+"']").attr("required","required");
				}
			});
			form.find("[required]").parents(".ui-form-field-container").prev().prepend("<span class='required-field'>*</span>");
		}

		//File upload
		//var filesList = [];
 		fileupload = form.find('input[type=file]').fileupload({
 			url: form.attr("action"),
			autoUpload:false,
			dataType: 'json',
			formData: form
 		});

		fileupload.on('fileuploadadd', function (e, data) {
			$file = form.find('input[name="'+data.fileInput.context.name+'"]');
			var files = [];
			var paramNames = [];
			var formData = form.data("fileData");
			
			if(formData){
				files = formData.files;
				paramNames = formData.paramName;
			} 
			
			paramNames.push(e.delegatedEvent.target.name);
			
			$.each(data.files, function (index, file) {
				files.push(file);
				var $node = $('<div class="file"><span class="file-name">'+file.name+'</span><span class="file-close"></span></div>');
				
				//hide file input
				$file.hide();
				
				//show file input on 
				$node.find(".file-close").on("click",function(){
					form.removeData("fileData");
					$(this).parents(".file").prev().show();
					$(this).parents(".file").remove();
				})
				$file.after($node);
			});
			data.files = files;
			data.paramName = paramNames;
			form.data("fileData",data);
		});

		form.find('input[type=file]').on("click submit change keydown",function(e){
			e.stopPropagation();
		});
		
		
		//Hover classes		
		$(".hover").hover(function() {
			$(this).addClass("ui-state-hover"); 
			},
			function() { 
				$(this).removeClass("ui-state-hover");  
		});
	
	},
	
	_submitFileForm: function(){
		var form = this.element;
		
		if(form.valid()){
			var o = {};
			var a = form.serializeArray();
			$.each(a, function() {
			    if (o[this.name]) {
			        if (!o[this.name].push) {
			            o[this.name] = [o[this.name]];
			        }
			        o[this.name].push(this.value || '');
			    } else {
			        o[this.name] = this.value || '';
			    }
			})
			
			var data = form.data("fileData");
			if(data != undefined){
				data.formData = o;
				data.submit();
			} else {
				$.post(form.attr("action"), o);
			}
		}
		
		
	},
	
	addMethod: function(options){
		var form = this.element;
		if(options.name && options.method && options.message){
			$.validator.addMethod(options.name,options.method,options.message);			
		} else {
			$.validator.addMethod(options.name,options.method);
		}
	},
	
	addRule: function(options){
		var form = this.element;
		var item;
		if(options.name){
			item = form.find("[name="+options.name+"]");
		} else if(options.selector){
			item = form.find(options.selector);
		} 
		
		if(item){
			if(options.rule){
				$(item).rules("add",options.rule)	
			} 
		} else {
			console.warn("No se encontrÃ³ elemento para agregar la regla seleccionada")
		}
		
	},
	
	removeRule: function(options){
		var form = this.element;
		var item;
		if(options.name){
			item = form.find("[name="+options.name+"]");
		} else if(options.selector){
			item = form.find(options.selector);
		} 
		
		if(item){
			if(options.ruleName){
				$(item).rules("remove",options.ruleName)	
			} 
		} else {
			console.warn("No se encontrÃ³ elemento para eliminar la regla seleccionada")
		}
		
	},
	
	setMessages: function(messages){
		$.validator.messages = $.extend($.validator.messages, messages);
	},
	
	dates: function(element, object) {
		
		$(element).addClass("ui-form-date");
		
		if(object.options.datePicker.config != undefined) {
			$(element).datepicker(object.options.datePicker.config);
		} else {
			$(element).datepicker();
		}
	},
	
	textelements: function(element) {
		
		$(element).addClass("ui-form-text");
		
		if($(element).is("textarea") ) {
			$(element).addClass("ui-form-textarea");
		}
		
		$(element).addClass('ui-state-default ui-corner-all');
		$(element).wrap("<label />");
		
		$(element).bind({		
			focusin: function() {
		   		$(this).toggleClass('ui-state-focus');
			},
			focusout: function() {
				$(this).toggleClass('ui-state-focus');
			}	 
		});
		
	},
	
	labels: function(element) {
		
		$(element).addClass("ui-form-label");
		$(element).parent().addClass("ui-form-label-container");
		$(element).parent().next().addClass("ui-form-field-container");
		
	},
	 
	buttons: function(element, object) {
		
		$(element).button();
		$(element).addClass("ui-form-button");
		
		if($(element).is(":submit")) {
			$(element).click(function (event){
				if(object.options.enableFileTransfer && object.options.enableFileTransfer == true){
					object._submitFileForm();
				} else {
					object.options.submit(event);					
				}
			});
		}
	},
	 
	checkboxes: function(element) {
		
		$(element).addClass('ui-state-default ui-corner-all');
		$(element).wrap("<label />");
		
		$(element).parent("label").after("<span />");
		var parent =  $(element).parent("label").next();
		$(element).addClass("ui-helper-hidden");
		parent.css({width:16,height:16,display:"block"});
		 
		parent.wrap("<span class='ui-state-default ui-corner-all ui-form-checkbox' />");
		 
		parent.parent().addClass('hover');
	  
		parent.parent("span").click(function(event) {
			$(this).toggleClass("ui-state-active");
			parent.toggleClass("ui-icon ui-icon-check");
			$(element).click();
				
		});
		 
	},
	 
	radio: function(element) {
		
		$(element).addClass('ui-state-default ui-corner-all');
		$(element).wrap("<label />");
   
		$(element).parent("label").after("<span />");
		var parent =  $(element).parent("label").next();
		$(element).addClass("ui-helper-hidden");
		parent.addClass("ui-icon ui-icon-radio-off");
		parent.wrap("<span class='ui-state-default ui-corner-all ui-form-radio'/>");
		 
		parent.parent().addClass('hover');
	  
		parent.parent("span").click(function(event) {
			//reset radios
			parent.parents("td").find(".ui-form-radio")
				.removeClass("ui-state-active")
				.find(".ui-icon").attr("class","ui-icon ui-icon-radio-off");
			//select radio
			$(this).toggleClass("ui-state-active");
			parent.toggleClass("ui-icon-radio-off ui-icon-bullet");
			$(element).click();
		});
	},
		 
	selector: function(element, object) {
		
		$(element).addClass('ui-state-default ui-corner-all');
		$(element).wrap("<button />");
			 
		var parent = $(element).parent();
		parent.addClass("ui-state-default ui-corner-all ui-form-selector");
		$(element).addClass("ui-helper-hidden");
		parent.append("<span id='labeltext' class='ui-form-selector-label'></span><span class='ui-icon ui-icon-triangle-2-n-s ui-form-selector-icon ui-corner-all' ></span>");
		$ul = $("<ul class=' ui-helper-reset ui-widget-content ui-helper-hidden ui-corner-all ui-form-selector-list' ></ul>");		
		$ul.css("position","absolute").css("z-index","10000");

		var $widgetId = $(parent).parents(".portalWidget").attr("id");
		var listId = object.generateId($widgetId+"_select");
		$ul.attr("id", listId);
		$(parent).attr("listId", listId);

		//$("body").append($ul);	
		$(parent).parents(".portalWidget").append($ul);
		
		$ul.outerWidth($(parent).outerWidth());

		$.each($(element).find("option"),function(){
			$ul.append("<li class='hover' optionValue='"+$(this).attr("value")+"'>"+$(this).html()+"</li>"); 
												   
		});
			 
		$ul.find("li").click(function(){
			$(element).parents(".ui-form-selector").find("#labeltext").html($(this).html());
			$(element).val($(this).attr("optionValue")).trigger('change');
			$(this).parents(".ui-form-selector-list").slideToggle('fast');
		});
		
		//set selected
		$(element).parents(".ui-form-selector").find("#labeltext").html($(element).find("option:selected").html());
		
		$(parent).click(function(event) { 
			var $ul = $("ul#"+$(parent).attr("listId"));
			$ul.css("top", ( $(parent).offset().top + $(parent).outerHeight() ) + "px");
			$ul.css("left", ( $(parent).offset().left ) + "px");
			$ul.slideToggle('fast');
		 	event.preventDefault();						
		});	                
	},
	
	simpleSelect: function(element, object) {
		
		var $element = $(element);
	  
		if(object.options.simpleSelect.config != undefined) {
			$element.multiselect($.extend(object.options.simpleSelect.config, { "appendDataTo" : $element.parents(".portalWidget") }));
		} else {
			$element.multiselect({ "appendDataTo" : $element.parents(".portalWidget") });
		}
	},
	
	multiselect: function(element, object) {
		
		var $element = $(element);
	  
		if(object.options.multiselect.config != undefined) {
			$element.multiselect($.extend(object.options.multiselect.config, { "appendDataTo" : $element.parents(".portalWidget") }));
		} else {
			$element.multiselect({ "appendDataTo" : $element.parents(".portalWidget") });
		}
	},

	multiselectGroup: function(element, object) {
		
		var $element = $(element);
	  
		if(object.options.multiselectGroup.config != undefined) {
			$element.multiselect($.extend(object.options.multiselectGroup.config, { "appendDataTo" : $element.parents(".portalWidget") }));
		} else {
			$element.multiselect({ "appendDataTo" : $element.parents(".portalWidget") });
		}
	},
	
	multiselectFilter: function(element, object) {
		
		var $element = $(element);
		
		if(object.options.multiselect.config != undefined && object.options.multiselectFilter.config != undefined) {
			$element.multiselect($.extend(object.options.multiselect.config, { "appendDataTo" : $element.parents(".portalWidget") })).multiselectfilter(object.options.multiselectFilter.config);
		} else {
			$element.multiselect({ "appendDataTo" : $element.parents(".portalWidget") }).multiselectfilter();
		}
	},

	autocomplete: function(element, object) {
		
		var $element = $(element);
	  
		if(object.options.autocomplete.config != undefined && object.options.autocomplete.config.source != undefined) {
			$element.autocomplete($.extend(object.options.autocomplete.config, { "appendTo" : $element.parents(".portalWidget") }));
		} else {
			$element.autocomplete({ "appendTo" : $element.parents(".portalWidget") });
		}
	},

	generateId: function(selector){
		if ( $("#"+selector).exists() ){
			var num = $("#"+selector).length;
			var generatedId = selector+"_"+num;
			var i = 1;
			while ( $("#"+generatedId).exists() ){  generatedId = selector+"_"+(num+i); i++; }
			return generatedId;
		}else{
			return selector;
		}
	},

	destroy: function() {			
		/* Implement this*/
	},
		
	_setOption: function(option, value) {
		$.Widget.prototype._setOption.apply( this, arguments );
		
		var el = this.element,
			cap = el.next(),
			capHeight = cap.outerHeight() - parseInt(cap.css("paddingTop")) + parseInt(cap.css("paddingBottom"));
		
		switch (option) {
			case "location":
				(value === "top") ? cap.css("top", el.offset().top) : cap.css("top", el.offset().top + el.height() - capHeight);
				break;
			case "color":
				el.next().css("color", value);
				break;
			case "backgroundColor":
				el.next().css("backgroundColor", value);
				break;
		}
	}
});

})(jQuery); 