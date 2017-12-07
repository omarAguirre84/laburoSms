<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
	<title></title>
</head>

<body>

	<div class="bloque">
		<h3><span>Caracter�sticas de la aplicaci�n template</span></h3>
		<div class="cuerpo">
			<p>
			El objetivo de esta aplicaci�n es proveer un ejemplo de los distintos componentes visuales a re-utilizar 
			en la construcci�n de nuevas aplicaciones desarrolladas con el Framework&nbsp;2.0.<br/><br/>
			
			Cada desarrollo tomar� como base este template y se deber�n crear y/o renombrar las carpetas y/o packages para adecuarse al nombre de la nueva aplicaci�n.<br/><br/>
			
			La aplicaci�n presentar� su n�mero de versi�n en el sector superior-derecho del encabezado. Este es generado autom�ticamente cada vez que se crea el war con maven  ( mvn clean package )<br/><br/> 
			
			
			Cada p�gina dentro de la aplicaci�n deber� ser desarrollada de manera independiente del layout actual del sitio. Es decir, no se incluyen elementos tales como men� principal, men� tipo "breadcrumb" , encabezados, footer, etc...
			siendo esto tarea del "decorator", el cual consiste en un jsp encargado de renderizar los fragmentos de html comunes a todas las p�ginas.<br/>
			A su vez, el decorator puede variar su presentaci�n dependiendo de metadata provista dentro del c�digo html de la p�gina actual ( ver ejemplo en p�gina "ayuda" )<br/><br/>
			
			El uso de decorators favorece la velocidad de construcci�n ya que el programador solo necesita focalizar en el sector central de contenido y reduce el esfuerzo en caso de requerirse cambios al layout actual ya que
			modificando un solo jsp puede alterarse el aspecto y navegaci�n general de la aplicaci�n. O incluso es posible disponer de un 2do. layout alternativo, dentro del mismo sitio.<br />
			( Ver ejemplo accediendo a la opci�n "Layout" en el men� )<br/><br/>
			
			 
			Ver mas info en <a href="http://www.opensymphony.com/sitemesh/" target="_blank">http://www.opensymphony.com/sitemesh/</a>
			
			
			
			<br/><br/><br/><br/>
			</p>
		</div>
		<div class="pie"><div></div></div>
	</div>
</body>
</html>