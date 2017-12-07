<%--
Fragmento <head> comun a todos los JSPs
 --%>
<%@ page 	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="taglibs.jsp" %>
<%@ page	import="ar.com.osde.framework.context.Context" %>
<%@ page	import="ar.com.osde.framework.context.ContextHolder"%>
<decorator:usePage id="thePage" />

<cw:set var="help" />
<fmt:setBundle basename="osde-framework"/>
<fmt:message var="applicationVersion" key="application.version"/>
<fmt:message var="resourcesPath" key="resources.path"/>

<cw:set var="appCtx"		value="${pageContext.request.contextPath}" scope="application" /><%-- Application Context --%>
<cw:set var="staticPath"	value="${resourcesPath}" scope="application" /><%-- Static resources Path --%>
<cw:set var="appVersion"	value="${applicationVersion}" scope="application" /><%-- POM Version --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>	
	<title><decorator:title default="Integraci&oacute;n Saludsoft" /></title>
	<meta http-equiv="Pragma" content="no-cache"/>
	
	<script type="text/javascript" src="${staticPath}lib/js/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="${staticPath}lib/js/jquery-ui-1.10.4.custom.js"></script>
	<script type="text/javascript" src="${staticPath}lib/js/jquery.i18n.js"></script>
	<script type="text/javascript" src="${staticPath}lib/js/jquery.i18n.es.js"></script>
	<script type="text/javascript" src="${staticPath}lib/js/ui/jquery.blockUI.js" ></script>
	<script type="text/javascript" src="${staticPath}lib/js/jquery.fileupload.js"></script>
	<script type="text/javascript" src="${staticPath}lib/js/jquery.iframe-transport.js"></script>
	<script type="text/javascript" src="${staticPath}lib/js/jquery.form.js"></script>
	<script type="text/javascript" src="${staticPath}lib/js/jquery-ui-form-1.0.js"></script>
	<script type="text/javascript" src="${staticPath}lib/js/jquery.validate.js"></script>
	<script type="text/javascript" src="${staticPath}lib/js/global.js"></script>
	<script type="text/javascript" src="${staticPath}lib/js/DataTables-1.9.4/media/js/jquery.dataTables.js"></script>

    <link type="text/css" href="${staticPath}lib/styles/jquery/ui.core.css" rel="Stylesheet" />    
    <link type="text/css" href="${staticPath}lib/styles/jquery/ui.tabs.css" rel="Stylesheet" />
    <link type="text/css" href="${staticPath}lib/styles/jquery/ui.dialog.css" rel="Stylesheet" />
    <link type="text/css" href="${staticPath}lib/styles/jquery/ui.theme.css" rel="Stylesheet" />
    <link type="text/css" href="${staticPath}lib/styles/jquery/ui.datepicker.css" rel="Stylesheet" />
	<link type="text/css" href="${staticPath}lib/styles/global.css" rel="stylesheet"  />
	<link type="text/css" href="${staticPath}lib/styles/jquery/jquery-ui-form-1.0.css" rel="stylesheet"  />
	<link type="text/css" href="${staticPath}lib/js/DataTables-1.9.4/media/css/demo_table_jui.css" rel="stylesheet"  />
	<link type="text/css" href="${staticPath}lib/styles/dataTables.css" rel="stylesheet"  />
	
	<script type="text/javascript">
		var datepickerDefaults;
		var dialogDefaults;
		var blockDefaultsl;
	
		$(document).ready(function () {
	
			// Configuracion de Datepicker
			datepickerDefaults = {
					showOn: 'button', 
					buttonImage: '${staticPath}lib/styles/img/calendario/calendario.gif', 
					buttonImageOnly: true,
					changeMonth: true,
					changeYear: true,
					dateFormat: 'dd/mm/yy',
					buttonText: 'Seleccione una fecha',
					dayNamesMin: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sa'],
					dayNames: ['Domingo', 'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sabado'],
					duration: 0,
					monthNames: ['Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
					monthNamesShort: ['Ene','Feb','Mar','Abr','May','Jun','Jul','Ago','Sep','Oct','Nov','Dic'],
					nextText: 'Siguiente',
					prevText: 'Anterior'
			};
	
			// Configuracion default de Dialogs
			dialogDefaults = {
				bgiframe: true,
				autoOpen: true,
				height: 150,
				width: 300,
				modal: true,
				draggable: true,
				resizable: false,
				stack: true,
				close: function(event, ui) {$(this).dialog('destroy'); }, 
				buttons: {
					CERRAR: function() {
						$(this).dialog('close');
					}
				}
			}
	
			
			// Configuracion  del comportamiento de bloqueo
			blockDefaults = { 
				message: $('#spinner'),      		 
		        css: { 
					border: '1px solid #aaaaaa',
				    padding: '15px', 
				    backgroundColor: '#fafafa', 
				    '-webkit-border-radius': '10px', 
				    '-moz-border-radius': '10px', 
				    top:  ($(window).height() - 30) /2 + 'px', 
		            left: ($(window).width() - 150) /2 + 'px', 
				    opacity: 1, 
				    color: '#fff',
				    height: '30px',
				    width: '150px',
				    zIndex: '5000'
				   },
				overlayCSS: {
					backgroundColor: '#AAAAAA',
					opacity: 0.3
				}
			}
	
			
			// Caching de imagenes ---
			$.preloadImages("${staticPath}images/menu/abrirOver.gif", 
							"${staticPath}images/menu/abrirOut.gif",
							"${staticPath}images/menu/cerrarOver.gif",
							"${staticPath}lib/styles/img/menu/menu_fondo.png",
							"${staticPath}lib/styles/img/menu/menu_primero.png",
							"${staticPath}lib/styles/img/menu/menu_top.png",
							"${staticPath}lib/styles/img/menu/menu_ultimo.png",
							"${staticPath}images/paginador/pag_anterior_over.gif",
							"${staticPath}images/paginador/pag_primero_over.gif",
							"${staticPath}images/paginador/pag_proximo_over.gif",
							"${staticPath}images/paginador/pag_ultimo_over.gif"
							);
		});
		
		// EFECTO ROLL-OVER SOBRE BOTONES -
		$(".btn_out").on("mouseover", function(evnt) {
		    $(this).removeClass("btn_out");
		    $(this).addClass("btn_over"); 
		    evnt.stopPropagation();
		});
		$(".btn_over").on("mouseout", function(evnt) {
		    $(this).removeClass("btn_over");
		    $(this).addClass("btn_out"); 
		    evnt.stopPropagation();
		});
		
		// Impide que se chacheen las peticiones ajax (IE).
		if( navigator.userAgent.search("MSIE") >= 0 ) {
			$.ajaxSetup({cache: false});
		}

	</script>