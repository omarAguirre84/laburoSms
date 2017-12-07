<%@ include file="/pages/template/includes/taglibs.jsp"%>

<script type="text/javascript" src="${staticPath}lib/js/pages/jquery.pages.index.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#index-container').pageIndex({appCtx: '${staticPath}'});
	});
</script>

<style>
<!--
.button-tools {
	border: 1px #DDD solid;
	cursor: pointer;
	margin-right: 4px;
	padding: 2px 8px;
	border-radius: 4px;
	background-color: white;
}

.row_selected {
	background-color: #B0BED9 !important;
}

table.dataTable tr.row_selected td.sorting_1 {
	background-color: #B0BED9 !important;
}

table.dataTable tr.row_selected td.sorting_2 {
	background-color: #B0BED9 !important;
}

table.dataTable tr.row_selected td.sorting_3 {
	background-color: #B0BED9 !important;
}
-->
</style>

<div id="index-container" class="bloque">
	<h3>
		<span>Integraci&oacute;n de servicios - Inicio</span>
	</h3>
	<div class="cuerpo" style="height: 345px;">
		<div>
			<sec:authorize ifAnyGranted="OSSERVIPG-VIS"> <!-- Permiso de view. -->
			<img id="btn-actualizar" class="button-tools" title="Actualizar" src="${staticPath}images/usabilidad/iconos_on/actualizar.gif">
			</sec:authorize>
			<sec:authorize ifAnyGranted="OSSERVIPG-ABM"> <!-- Permiso de abm. -->
			<img id="btn-nuevo" class="button-tools" title="Nuevo" src="${staticPath}images/usabilidad/iconos_on/agregar-on.gif">
			</sec:authorize>
			<sec:authorize ifAnyGranted="OSSERVIPG-VIS"> <!-- Permiso de view. -->
			<img id="btn-consultar" class="button-tools" title="Consultar" src="${staticPath}images/usabilidad/iconos_on/detalle-on.gif">
			</sec:authorize>
			<sec:authorize ifAnyGranted="OSSERVIPG-ABM"> <!-- Permiso de abm. -->
			<img id="btn-editar" class="button-tools" title="Editar" src="${staticPath}images/usabilidad/iconos_on/editar-on.gif">
			<img id="btn-eliminar" class="button-tools" title="Eliminar" src="${staticPath}images/usabilidad/iconos_on/eliminar-on.gif">
			</sec:authorize>
		</div>
		<table id="tabla-servicios" class="datos"></table>
	</div>
	<div class="pie">
		<div></div>
	</div>
</div>
