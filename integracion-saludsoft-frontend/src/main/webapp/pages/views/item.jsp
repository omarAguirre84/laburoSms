<%@ include file="/pages/template/includes/taglibs.jsp"%>

<script type="text/javascript" src="${staticPath}lib/js/pages/jquery.pages.item.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$('#item-container').pageItem({appCtx: '${staticPath}'});
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
</style>


<div id="item-container" class="bloque">
	<h3>
		<span>Integraci&oacute;n de servicios - ${servicio.id == null ? "Alta" : "Edici&oacute;n"}</span>
	</h3>
	<form id="frm-servicio">
		<div id="bloque-contenido" class="cuerpo" style="height: 252px; padding-top: 10px !important;">
			<div class="datos bloque">
				<h3>
					<span>Datos</span>
				</h3>
				<div class="cuerpo" style="height: 182px;">
					<table class="formulario">
						<tr>
							<td class="label">* C&oacute;digo:</td>
							<td><s:textfield theme="simple" id="codigo" name="servicio.codigo" tabindex="1" cssStyle="width: 35px;"></s:textfield></td>
						</tr>
						<tr>
							<td class="label">* Nombre:</td>
							<td><s:textfield theme="simple" id="nombre" name="servicio.nombre" tabindex="2"></s:textfield></td>
						</tr>
						<tr>
							<td class="label">* Url del servicio:</td>
							<td><s:textfield theme="simple" id="url-servicio" name="servicio.urlServicio" tabindex="3"></s:textfield></td>
						</tr>
						<tr>
							<td class="label">Url de gesti&oacute;n interna:</td>
							<td><s:textfield theme="simple" id="url-gestion-interna" name="servicio.urlGestionInterna" tabindex="4"></s:textfield></td>
						</tr>
						<tr>
							<td class="label">Url de informaci&oacute;n adicional:</td>
							<td><s:textfield theme="simple" id="url-info-adicional" name="servicio.urlInfoAdicional" tabindex="5"></s:textfield></td>
						</tr>
						<tr>
							<td class="label">Tipo de Invocaci&oacute;n:</td>
							<td>
								<s:select id="tipo-invocacion" name="servicio.tipoInvocacion" theme="simple" cssClass="ui-form-exclude"
										  list="tiposInvocacion" headerKey="" value="%{servicio.id != null ? servicio.tipoInvocacion : ''}" tabindex="6"/>
							</td>
						</tr>
						
						<tr>
							<td class="label">Registra actividad:</td>
							<td><s:checkbox id="registra-actividad" cssClass="ui-form-exclude" name="servicio.registraActividad" tabindex="7"/></td>
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
					<table class="formulario">
						<s:iterator var="it" value="parametros">
							<tr>
								<td style="text-align: left;">
									<input type="checkbox" 
										class="ui-form-exclude ${registraActividad ? 'regactividad' : ''}" 
										id="${it}" name="servicio.parametros" value="${it}"
										<s:iterator var="its" value="servicio.parametros">
											<cw:if test="${it eq its}">
											checked="checked"
											</cw:if>
										</s:iterator>
										${servicio.registraActividad == true && it.registraActividad == true ? 'disabled="disabled"' : ''}>
									<label for="${it}" style="font-weight: normal; text-align: left !important;">${it.descripcion}</label>
								</td>
							</tr>
						</s:iterator>
					</table>
				</div>
				<div class="pie"><div></div></div>
			</div>
			<div style="float: right; width: 100%;">
				<button id="btn-volver" type="button" style="margin-left: 5px;">Volver</button>
				<button id="btn-limpiar" type="button" style="margin-left: 5px;">Limpiar</button>
				<button id="btn-guardar" type="submit">Guardar</button>
			</div>
		</div>
		<div class="pie"><div></div></div>
	</form>
</div>
