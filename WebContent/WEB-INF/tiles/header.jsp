<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<a class="title" href="<c:url value='/'/>">Offers</a>

<sec:authorize access="isAuthenticated()">

	<c:url value="/logout" var="logoutUrl" />

	<form method="post" action="${logoutUrl}">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> <input type="submit" value="Logout" class="login">
	</form>
</sec:authorize>

<sec:authorize access="!isAuthenticated()">

	<c:url value="/login" var="loginUrl" />

	<form action="${loginUrl}">
		<input type="submit" value="Login" class="login">
	</form>
	
</sec:authorize>