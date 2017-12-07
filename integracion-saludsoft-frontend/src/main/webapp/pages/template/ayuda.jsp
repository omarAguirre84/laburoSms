<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
	<meta name="pageCode" content="1"/>
	<meta name="helpInfo" content="help_page.jsp"/>
	<title>Ayuda</title>
</head>

<body>

	<div class="bloque">
		<h3><span>Ayuda</span></h3>
		<div class="cuerpo">
			<p>
			Cada p�gina dentro la aplicaci�n puede (o no) requerir de la presentaci�n de ayuda. Este bot�n se visualizar� en el mismo sector de la pantalla
			para todas las p�ginas que as� lo requieran. El mismo es renderizado por el jsp que define el layout actual del sitio ( conocido como "decorator").<br/><br/>
			
			El decorator determina cuando mostrar el bot�n dependiendo de la existencia de metadata espec�fica dentro del c�digo html de la p�gina actual y puede 
			implementar una determinada funcionalidad bas�ndose en el valor especificado en la misma.<br/><br/>
			
			Por ejemplo, en el c�digo html de una p�gina podria definirse lo siguiente:<br/>
			</p>
			<div class="codeSample"">
			&lt;head&gt;	<br/>
			&nbsp;&nbsp;&nbsp;&nbsp; &lt;meta name="<b>helpInfo</b>" content="<b>help_page.jsp</b>"/&gt;	<br/>
			</div>
			<br/>
			<p>
			Y en el jsp del decorator consultar la existencia de esta informaci�n de la siguiente manera para saber cuando presentar el bot�n:<br/>
			</p>
			<div class="codeSample"">
			&lt;decorator:usePage id="thePage" /&gt;	<br/>
			&lt;%<br/>
			String helpInfo 		= thePage.getProperty("<b>meta.helpInfo</b>");<br/>
			
			if(null != helpInfo){  <span class="codeComment">// Si existe helpInfo muestro el boton...</span><br/>
			%&gt;<br/>
			
			&nbsp;&nbsp; &lt;s:submit type="button" id="btnAyuda" value="ayuda" /&gt;<br/>
			&lt;%<br/>
			}<br/>
			%&gt;<br/>
			</div>
			<br/>
			<p>
			De esta manera, cada p�gina indica cuando dispone o no de ayuda y en consecuencia el decorator presenta o no un bot�n. <br/><br/>
			<b>La funcionalidad asignada al bot�n, ser� determinada por cada aplicaci�n.</b> ( ejemplos: un popup con un una p�gina de ayuda, un link hacia un sitio externo, la inclusi�n de un determinado script en la p�gina actual, etc... )<br/><br/><br/> 
			</p>
		</div>
		<div class="pie"><div></div></div>
	</div>

</body>            
</html>