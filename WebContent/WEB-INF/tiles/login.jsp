<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body onload='document.f.username.focus();'>
	<h3>Login with Username and Password</h3>

	<c:if test="${param.error != null}">

		<p class="error">Login failed. Check your username and password.</p>

	</c:if>

	<form name='f' action='${pageContext.request.contextPath}/login'
		method='POST'>
		<table class="formtable">
			<tr>
				<td>Username:</td>
				<td><input class="control" type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input class="control" type='password' name='password' /></td>
			</tr>
			<tr>
				<td>Remember me:</td>
				<td><input class="control" type="checkbox" name='remember-me' checked="checked" /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
			</tr>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</table>
	</form>
	<p>
		<a href="${pageContext.request.contextPath}/newaccount">Create New
			Account</a>
	</p>
</body>