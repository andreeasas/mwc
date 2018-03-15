<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--   
  <c:forEach var="subcategory" items="${category.subcategories}">
      <c:out value="${param.category}"/>
      <form:input path="${subcategory.name}"/>
      
      <c:set var="category" value="${category}" scope="request"/>
      <jsp:include page="category.jsp"/>
  </c:forEach>
-->