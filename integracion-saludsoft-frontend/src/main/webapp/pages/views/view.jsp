<%@ include file="/pages/template/includes/taglibs.jsp"%>

<script type="text/javascript" src="${staticPath}lib/js/pages/jquery.pages.view.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$('#item-container').pageView({appCtx: '${staticPath}'});
		var largoMaxURL = 58;
		if ($("#srvUrl").text().length > largoMaxURL || 
				$("#srvUrlGi").text().length > largoMaxURL ||
				$("#srvUrlIA").text().length > largoMaxURL) {
			$(".cuerpo").addClass("scrollDatos");
			$("#srvUrl").addClass("tooLargeUrl");
			$("#srvUrlGi").addClass("tooLargeUrl");
			$("#srvUrlIA").addClass("tooLargeUrl");
		}
	});
</script>

<style type="text/css">
	.datos {
		float: left;
		width: 49%;
	}
	
	.parametros {
		float: right;
		width: 49%;
	}
	
	.lengthUrl{
		width: 150px;
  		word-break: break-all;
    	white-space: normal;
    	
	}
	
	.tooLargeUrl{
		padding-bottom: 10px !important;
	}
	
	.scrollDatos{
		overflow-y: scroll;
	}
</style>


<div id="item-container" class="bloque">
	<h3>
		<span>Integraci&oacute;n de servicios - Consulta</span>
	</h3>
	<form id="frm-servicio">
		<div id="bloque-contenido" class="cuerpo" style="height: 252px; padding-top: 10px !important;">
			<div class="datos bloque">
				<h3>
					<span>Datos</span>
				</h3>
				<div class="cuerpo" style="height: 182px;">
					<table class="formulario" style="table-layout: fixed; width: 610px;">
						<tr>
							<td class="label">C&oacute;digo:</td>
							<td>${servicio.codigo}</td>
						</tr>
						<tr>
							<td class="label">Nombre:</td>
							<td>${servicio.nombre}</td>
						</tr>
						<tr>
							<td class="label">Url del servicio:</td>
							<td class="lengthUrl" id="srvUrl">${servicio.urlServicio}</td>
						</tr>
						<tr>
							<td class="label">Url de gesti&oacute;n interna:</td>
							<td class="lengthUrl" id="srvUrlGi">${servicio.urlGestionInterna != '' ? servicio.urlGestionInterna : '-'}</td>
						</tr>
						<tr>
							<td class="label">Url de informaci&oacute;n adicional:</td>
							<td class="lengthUrl" id="srvUrlIA">${servicio.urlInfoAdicional != '' ? servicio.urlInfoAdicional : '-'}</td>
						</tr>
						<tr>
							<td class="label">Tipo de Invocaci&oacute;n:</td>
							<td>${servicio.tipoInvocacion}</td>
						</tr>
						<tr>
							<td class="label">Registra actividad:</td>
							<td><s:checkbox cssClass="ui-form-exclude" name="servicio.registraActividad" disabled="true"/></td>
						</tr>
					</table>
				</div>
				<div class="pie"><div></div></div>
			</div>
			<div class="parametros bloque">
				<h3>
					<span>Par&aacute;metros</span>
				</h3>
				<div class="cuerpo" style="height: 182px; overflow-y: scroll;">
					<s:if test="servicio.id != null" >
						<s:hidden id="servicio-id" name="servicio.id" theme="simple" />
					</s:if>
					<ul>
						<s:iterator var="it" value="parametros">
							<li>
							<cw:if test="${it.registraActividad}">
							<strong>${it.descripcion}</strong>
							</cw:if>
							<cw:if test="${!it.registraActividad}">
							${it.descripcion}
							</cw:if>
							</li>
						</s:iterator>
					</ul>
				</div>
				<div class="pie"><div></div></div>
			</div>
			<div style="float: right; width: 100%;">
				<button id="btn-volver" type="button">Volver</button>
			</div>
		</div>
		<div class="pie"><div></div></div>
	</form>
</div>
