<script type="text/javascript">
	$.post('${targetUrl}', '${stringifiedParams}', function(data) {
		$('#content-post').html(data);
	},"text");
</script>

<div id="content-post"></div>
