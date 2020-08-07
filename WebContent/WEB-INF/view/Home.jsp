<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Home Page</title>
		
		<!-- Reference CSS files -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/Home.css"/>
	
	</head>
	<body>
		<header id="main-header">
	      <div class="container">
	        <h1>Home Page</h1>
	      </div>
	    </header>
	    
		<hr>
		<p>
			User : <sec:authentication property="principal.username"/>
			<br>
			<br>
			Role : <sec:authentication property="principal.authorities"/>
		</p>
		<hr> 
		
		<sec:authorize access="hasAnyRole('MANAGER', 'EMPLOYEE')" >
			<a href="${pageContext.request.contextPath}/Leaders">Managers leading (Only for Managers)</a>
		</sec:authorize>
		
		<br>
		
		<sec:authorize access="hasAnyRole('ADMIN', 'EMPLOYEE')">
			<a href="${pageContext.request.contextPath}/Systems">Admin Systems (Only for Managers)</a>
		</sec:authorize>
		
		
		<br>
		<hr>
		<form:form action="${pageContext.request.contextPath}/logout" 
					method="POST">
			<br>
			<input type="submit" value="Logout">
					
		</form:form>
		
	</body>
</html>