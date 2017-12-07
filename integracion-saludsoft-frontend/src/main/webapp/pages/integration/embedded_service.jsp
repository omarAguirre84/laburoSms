
<script type="text/javascript">
	$(document).ready(function () {
		document.domain = 'intranet.osde';
		var parentDocument=window.parent.document;
		var parentBody = window.parent.document.body;
		$(parentDocument).ready(function(){
			$("#iframesuaServicioGestionInternaWidget", parentBody).ready(function(){
				var parentContainer=$("#iframesuaServicioGestionInternaWidget", parentBody);
			    parentContainer.attr("src", "${targetUrl}");				
			});		
		});
		
	});
</script>

