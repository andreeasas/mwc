<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>

<body>
<h1><spring:message code="login.login"/></h1>

<!-- language = p:paramName for interceptor [servlet-config.xml] -->
<spring:message code="login.language"/> <a href="?language=en">English</a> | <a href="?language=ge">Deutsch</a>

<form:form commandName="userModelAttr">
	<table>
		<tr>
			<td><spring:message code="login.username"/></td>
			<td><form:input path="username"/></td>
		</tr>
		<tr>
			<td><spring:message code="login.password"/></td>
			<td><form:input path="password"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<spring:message code="login.login" var="i18nLogin"/> 
				<input type="submit" value="${i18nLogin}">
			</td>
		</tr>
	</table>
	
	<h3>
         <a href="newUser.html"><spring:message code="login.newUser"/></a>
  </h3>
</form:form>
</body>
</html>