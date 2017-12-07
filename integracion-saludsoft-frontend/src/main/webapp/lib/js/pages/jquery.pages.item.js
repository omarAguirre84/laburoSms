$.widget( 'integracionsaludsoft.pageItem', {
	options: {
		appCtx: ''
	},
	
	_create: function () {
		this._bindVars();
		this._bindEvents();
		this._initialize();
	},
	
	_bindVars: function() {
		this.$form = this.element.find("#frm-servicio");
		this.idServicio = this.element.find("#servicio-id").val();
	},
	
	_bindEvents: function() {
		this.element.find('#registra-actividad').click($.proxy(this._updateParametros, this));
		this.element.find('#btn-limpiar').click($.proxy(this._resetForm, this));
		this.element.find('#btn-volver').click($.proxy(this._backToIndex, this));
	},
	
	_initialize: function() {
		this.$form.form({
			validate: {
				rules: {
					'servicio.codigo': {
						required: true,
						minlength: 3,
						maxlength: 3
					},
					'servicio.nombre': {
						required: true,
						maxlength: 100
					},
					'servicio.urlServicio': {
						maxlength: 255,
						required: true,
						url: true
					},
					'servicio.urlGestionInterna': {
						maxlength: 255,
						url: true
					},
					'servicio.urlInfoAdicional': {
						maxlength: 255,
						url: true
					},
					'servicio.tipoInvocacion': {
						required: true
					}
				}
			},
			submit: $.proxy(this._saveOrUpdate, this)
		});
	},
	
	_saveOrUpdate: function(e) {
		if(this.$form.valid()){
			if(this.element.find("input:checked[type=checkbox][name='servicio.parametros']").length){
				showConfirmMsg("&iquest;Desea guardar el servicio?", $.proxy(this._saveOrUpdateCallback, this));
			}else{
				showAlertMsg("Debe seleccionar al menos un par\u00E1metro");
			}
		}
		e.preventDefault();
	},
	
	_saveOrUpdateCallback: function () {
		this.element.find(".regactividad").prop('disabled', false);
		this.element.find('#bloque-contenido').block(blockDefaults);
		$.ajax({
			   method: 'POST',
			   data: this.$form.serialize(),
			   url: this.options.appCtx + 'servicios/' + (this.idServicio ? 'update' : 'save') + '.do',
			   dataType: 'json',
			   success: $.proxy(this._saveOrUpdateCallbackSuccess, this),
			   error: $.proxy(this._saveOrUpdateCallbackError, this)
		});
	},
	
	_saveOrUpdateCallbackSuccess: function (data, textStatus, jqXHR) {
		this.element.find('#bloque-contenido').unblock();
	   	window.location = this.options.appCtx + 'servicios/views/index.do';
	},
		
	_saveOrUpdateCallbackError: function (jqXHR, textStatus, errorThrown) {
	    switch (jqXHR.status) {
	        case 409:
	        	showAlertMsg(jqXHR.responseText);
	            break;
	        default:
	        	showErrorMsg(jqXHR.responseText);
	    }
	    this.element.find('#bloque-contenido').unblock();
	    if (this.element.find("#registra-actividad").is(':checked')) {
	    	this.element.find(".regactividad").prop('disabled', true);
	    }
	},
		
	_updateParametros: function(){
		var value = this.element.find("#registra-actividad").is(':checked');
		this.element.find("#registra-actividad").val(value);
		this.element.find(".regactividad").prop('checked', value).prop('disabled', value);
	},
	
	_resetForm: function(){
		this.$form.resetForm();
		this._updateParametros();
	},
	
	_backToIndex: function(){
		showConfirmMsg("&iquest;Est&aacute; seguro que desea descartar los datos sin guardar?", $.proxy(this._backToIndexCallback, this));
	},
	
	_backToIndexCallback: function(){
		window.location = this.options.appCtx + 'servicios/views/index.do';
	},
	
	destroy: function() {
	}
});
