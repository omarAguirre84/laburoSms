$.widget( 'integracionsaludsoft.pageIndex', {
	options: {
		appCtx: ''
	},
	
	_create: function () {
		this._bindVars();
		this._bindEvents();
		this._initialize();
	},

	_bindVars: function() {
		this.dtServicios = null;
	},
	
	_bindEvents: function() {
		this.element.find('#btn-actualizar').click($.proxy(this._actualizar, this));
		this.element.find('#btn-nuevo').click($.proxy(this._nuevoItem, this));
		this.element.find('#btn-editar').click($.proxy(this._editarItem, this));
		this.element.find('#btn-consultar').click($.proxy(this._consultarItem, this));
		this.element.find('#btn-eliminar').click($.proxy(this._eliminarItem, this));
	},
	
	_initialize: function() {
		this.dtServicios = this._renderDataTable([]);
		this._renderServicios();
	},
	
	_renderDataTable: function(data) {
		return this.element.find('#tabla-servicios').dataTable({
			bPaginate : true,
			sPaginationType : 'full_numbers',
			iDisplayLength : 10,
		    bAutoWidth: false,
			bFilter : true,
			bProcessing : false,
			bLengthChange : false,
			sDom : '<"H"fr>t<"F"ip>',
			aaSorting : [ [ 1, "asc" ] ],
			oLanguage : 	{
				sInfo: 'Total de Registros: _TOTAL_',
				sLengthMenu: "Mostrar _MENU_ registros por p&aacute;gina",
				sZeroRecords: "No se encontraron resultados",
				sInfoEmpty: "",
				sInfoFiltered: "(filtrado desde un total de _MAX_ registros)",
				sSearch: "Buscar:",
				sProcessing: "Procesando...",
				sLoadingRecords: "Cargando...",
				oPaginate: {
					"sFirst": "&nbsp;&nbsp;&nbsp;",
					"sPrevious": "&nbsp;&nbsp;&nbsp;",
					"sNext": "&nbsp;&nbsp;&nbsp;",
					"sLast": "&nbsp;&nbsp;&nbsp;"
				}  
			},
			fnRowCallback: function(nRow, aData, iDisplayIndex) {
		    	$(nRow).css({"cursor" : "pointer"});
		    	return nRow;
	    	},
			fnDrawCallback : function(o) {
		    	if (Math.ceil((this.fnSettings().fnRecordsDisplay()) / this.fnSettings()._iDisplayLength) > 1)  {
		            $('#' + this.attr('id') + '_paginate.dataTables_paginate').css("display", "block"); 
		        } else {
		            $('#' + this.attr('id') + '_paginate.dataTables_paginate').css("display", "none");
		        }
		    },
			aoColumns : [
				{
					sWidth: "5px",
					bSearchable: false,
					bSortable: false,
					sClass: "primero",
					mDataProp: function() {
						return "";
					}
				},
				{
					sWidth : "80px",
					sTitle : "C&oacute;digo",
					bSearchable : true,
					bSortable : true,
					sDefaultContent: "-",
					mDataProp : 'codigo'
				},
				{
					sTitle : "Nombre",
					bSearchable : true,
					bSortable : true,
					sDefaultContent: "-",
					mDataProp : 'nombre'
				},
				{
					sWidth : "120px",
					sTitle : "Registra actividad",
					sClass : "center",
					bSearchable : false,
					bSortable : false,
					sDefaultContent: "-",
					mDataProp : 'registraActividad',
					mRender : $.proxy(this._renderRegistraActividadColumn, this)
				},
				{
					sWidth: "5px",
					bSearchable: false,
					bSortable: false,
					sClass: "ultimo",
					mDataProp: function() {
						return "";
					}
				}
			],
			aaData : data
		});
	},
	
	_renderRegistraActividadColumn: function(data, type, full) {
		return data ? '<img src="' + this.options.appCtx + 'images/usabilidad/iconos_on/OK.gif" style="height: 15px;">' : '';
	},
	
	_getSelectedItem: function() {
		var result = null;
		var self = this;
		var nRow = $.grep(self.dtServicios.fnGetNodes(), function(item, index) {
			return $(item).hasClass('row_selected');
		});
		if (nRow.length && $(nRow).is(':visible')) {
    		result = this.dtServicios.fnGetData(nRow[0]);
		}
 	    return result;
	},
	
	_renderServicios: function() {
		this.element.find('.dataTables_wrapper').block(blockDefaults);
		$.ajax({
			   method: 'GET',
			   url: this.options.appCtx + 'servicios/list.do',
			   dataType: 'json',
			   success: $.proxy(this._renderServiciosCallback, this),
			   error: function (jqXHR, textStatus, errorThrown) {
				    switch (jqXHR.status) {
				        case 409:
				        	showAlertMsg(jqXHR.responseText);
				            break;
				        default:
				        	showErrorMsg(jqXHR.responseText);
				    }
				    this.element.find('.dataTables_wrapper').unblock();
			   }
		});
	},

	_renderServiciosCallback: function(data, textStatus, jqXHR) {
		if( this.dtServicios ) {
			this.dtServicios.off('click', 'tbody > tr');
			this.dtServicios.fnDestroy();
			this.dtServicios = null;
		}
		this.dtServicios = this._renderDataTable(data);
		this.dtServicios.on('click', 'tbody > tr', $.proxy(this._onServicioRowClick, this));
		this.element.find('.dataTables_wrapper').unblock();		
	},
	
	_onServicioRowClick: function(e) {
		var $row = $(e.currentTarget);
		var selectedClass = 'row_selected';
		var hasClass = $row.hasClass(selectedClass);
		$(this.dtServicios.fnGetNodes()).removeClass(selectedClass);
		if (!hasClass) {
			$row.addClass(selectedClass);
		}
	},
	
	_actualizar: function() {
		this._renderServicios();
	},
	
	_nuevoItem: function() {
		this.element.find('.dataTables_wrapper').block(blockDefaults);
		window.location = this.options.appCtx + 'servicios/views/add.do';
	},
	
	_editarItem: function() {
		var item = this._getSelectedItem();
		if (!item) {
			showAlertMsg("Debe seleccionar un \u00EDtem");
			return;
		}
		this.element.find('.dataTables_wrapper').block(blockDefaults);
		window.location = this.options.appCtx + 'servicios/views/edit.do?id=' + item.id;
	},
	
	_consultarItem: function(){
		var item = this._getSelectedItem();
		if (!item) {
			showAlertMsg("Debe seleccionar un \u00EDtem");
			return;
		}
		window.location = this.options.appCtx + 'servicios/views/view.do?id=' + item.id;
	},

	_eliminarItem: function() {
		var item = this._getSelectedItem();
		if (!item) {
			showAlertMsg("Debe seleccionar un \u00EDtem");
			return;
		}
		showConfirmMsg("&iquest;Est&aacute; seguro que desea eliminar el servicio?", $.proxy(this._eliminarItemCallback, this, item));
	},

	_eliminarItemCallback: function(item) {
		this.element.find('.dataTables_wrapper').block(blockDefaults);
		$.ajax({
			   method: 'DELETE',
			   url: this.options.appCtx + 'servicios/delete.do?id=' + item.id,
			   dataType: 'json',
			   success: $.proxy(this._renderServicios, this),
			   error: function (jqXHR, textStatus, errorThrown) {
				    switch (jqXHR.status) {
				        case 409:
				        	showAlertMsg(jqXHR.responseText);
				            break;
				        default:
				        	showErrorMsg(jqXHR.responseText);
				    }
				    this.element.find('.dataTables_wrapper').unblock();
			   }
		});					
	},
	
	destroy: function() {
	}
});
