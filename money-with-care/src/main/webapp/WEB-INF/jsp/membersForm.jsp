<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Members Form</title>
</head>
<body>
  <div align="center">
    <h1><spring:message code="membersForm.membersList"/></h1>
    <h3>
      <a href="newMember.html"><spring:message code="membersForm.newMember"/></a>
    </h3>
    
      <table border="1">
      
        <tr>
          <td><spring:message code="login.username"/></td>
          <td><form:input path="user.username"/></td>
        </tr>
      
        <tr>
          <th>Name</th>
        </tr>
        
        <c:forEach var="member" items="${listMembers}">
          <tr>
            
            <td>${member.name}</td>
            <td>
              <a href="editMember.html?id=${member.id}"><spring:message code="general.edit"/></a>
              <a href="deleteMember.html?id=${member.id}"><spring:message code="general.delete"/></a>
            </td>
            
          </tr>
        </c:forEach>
        
      </table>
   
  </div>
  
   <div align="center">
    <h1><spring:message code="categoriesForm.categoriesList"/></h1>
    
    <table border="1">
      <tr>
        <th><spring:message code="categoriesForm.categoryName"/></th>
      </tr>
      
      <c:forEach var="category" items="${categories}">
        <tr>
          <td>${category.name}</td>
          <td>${category.subcategories}</td>
          <td><a href="addSubcategories?id=${category.id}"><spring:message code="categoriesForm.addSubcategory"/></a>
            <a href="removeCategory?id=${category.id}"><spring:message code="categoriesForm.removeCategory"/></a>
          </td>
        </tr>
        
        <!--
        <jsp:include page="category.jsp">
          <jsp:param value="${category}" name="category"/>
        </jsp:include>
        -->
        
      </c:forEach>
    </table>
   
  </div>
  
</body>
</html>