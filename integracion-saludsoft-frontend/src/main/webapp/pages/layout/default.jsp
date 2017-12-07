<%@ include file="/pages/template/includes/common_head.jsp"%>

<decorator:head />
</head>
<body>
	<!-- Contenido -->
	<table id="estructura" style="height: 89%">
		<tr>
			<td valign="top" id="contenido"><decorator:body /></td>
		</tr>
	</table>

	<%@ include file="/pages/template/includes/procesando.jsp"%>
	<%@ include file="/pages/template/includes/dialogs.jsp"%>
</body>
</html>
