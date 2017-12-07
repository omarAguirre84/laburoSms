<%@ include file="includes/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
	<meta name="pageCode" content="6"/>
	<title>Error</title>
	<script>
	$(document).ready(function () {
		
		$('#btnErrorFmwk').click(function() {
			location.href ='<s:url action="dialogAction"/>'
		});
	
	
		$('#btnErrorPage').click(function() {
			location.href ='<s:url action="dialogAction!page"/>'
		});

		$('#btnError404').click(function() {
			location.href ='${appCtx}/im_not_here';
		});


		$('#btnError500').click(function() {
			location.href ='${appCtx}/pages/template/crash.jsp';
		});

		
	});	
	
	</script>
</head>

<body>
	
	<div class="bloque">
		<h3><span>Ejemplos de p�ginas de error</span></h3>
		<div class="cuerpo">
			<p>
			La aplicaci�n puede capturar condiciones de error y presentar al usuario el correspondiente mensaje mediante una p�gina predeterminada.
			<br/>
			Esta p�gina puede presentarse de diferentes maneras dependiendo del tratamiento que se haga del error producido.<br/><br/> 
			Por ejemplo, desde un Action se puede producir una Exception , no realizar ninguna acci�n al respecto y lanzar la exception para 
			que sea capturada por Struts (global-exception)<br/>
			En esto caso el error es presentado en una pantalla exclusiva sin incluir men�es ni links que permitan navegar la aplicaci�n.<br/>
			Estos son erorres severos y pueden incluir informaci�n t�cnica adicional. 
			<br/>Ejemplo:<br/>
			<s:submit type="button" id="btnErrorFmwk" value="Error capturado por Struts"/>
			<br/><br/><br/>
			</p>
			<p>
			En otro caso, la aplicaci�n puede capturar un error en el Action y realizar una redirecci�n la p�gina de error manteniendo la navegaci�n dentro del sitio.
			<br/>
			Estos son erorres menos severos y permiten que el usuario pueda seguir utilizando la aplicaci�n. 
			<br/>Ejemplo:<br/> 	
			<s:submit type="button" id="btnErrorPage" value="Error capturado en el Action"/>
			</p>
			<br/><br/><br/>
			<p>
			Adicionalmente, tambi�n podr�n presentarse mensajes correspondientes a errores HTTP que se produzcan dentro del contexto de la aplicaci�n.
			<br/>Ejemplo:<br/> 	
			<s:submit type="button" id="btnError404" value="Generar error 404"/>&nbsp;&nbsp;<s:submit type="button" id="btnError500" value="Generar error 500"/>
			</p>
			<br/><br/><br/>
		</div>
		<div class="pie"><div></div></div>
	</div>

	
</body>            
</html>