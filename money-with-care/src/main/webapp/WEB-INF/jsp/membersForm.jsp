<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <div align="center">
    <h1><spring:message code="membersForm.membersList"/></h1>
    <h3>
      <!-- 
      <form:form action="newMember.html" method="post" modelAttribute="user">
            <spring:message code="membersForm.newMember" var="i18newMember"/> 
            <td colspan="2" align="center"><input type="submit" value="${i18newMember}"></td>
      </form:form>
      
      newMember.html?userId=${user.id}
      -->
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
              <a href="editMember.html?id=${member.id}">Edit</a>
              <a href="deleteMember.html?id=${member.id}">Delete</a>
            </td>
            
          </tr>
        </c:forEach>
        
      </table>
   
  </div>
</body>
</html>