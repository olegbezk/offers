<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>

	<p>
		<a href="${pageContext.request.contextPath}/offers">Show current
			offers.</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/createoffer">Add a new
			offer.</a>
	</p>

	<p>
	<c:url value="/logout" var="logoutUrl" />
		<form method="post" action="${logoutUrl}">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input type="submit" value="Logout">
		</form>
	</p>

</body>
</html>