<%@ include file="/pages/template/includes/taglibs.jsp"%>

<h2 style="color:red">JSON Parameters in POST request</h2>
<cw:forEach var="entry" items="${parametrosOut}">
	<h4>${entry.key} = ${entry.value}</h4>
</cw:forEach>
<%-- <h3>${parametrosOut}</h3> --%>
