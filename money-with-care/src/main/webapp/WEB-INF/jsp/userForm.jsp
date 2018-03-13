<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Page</title>
</head>
<body>
	<div align="center">
		<h1><spring:message code="userForm.title"/></h1>
		<form:form action="saveUser.html" method="post" modelAttribute="user">
		<table>
			<form:hidden path="id"/>
			<tr>
				<td><spring:message code="userForm.username"/></td>
				<td><form:input path="username"/></td>
			</tr>
			<tr>
				<td><spring:message code="userForm.password"/></td>
				<td><form:input path="password"/></td>
			</tr>
			<tr>
				<td><spring:message code="userForm.lastName"/></td>
				<td><form:input path="lastName"/></td>
			</tr>
			<tr>
        <spring:message code="general.save" var="i18nSave"/> 
				<td colspan="2" align="center"><input type="submit" value="${i18nSave}"></td>
			</tr>
		</table>
    
    <h3>
         <a href="listMembers.html"><spring:message code="userForm.listMembers"/></a>
    </h3>
		</form:form>
	</div>
</body>
</html>