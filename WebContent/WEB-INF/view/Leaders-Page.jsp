<!-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Leaders</title>
		
		<!-- Reference CSS files -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/Leaders-Page.css"/>
		
	</head>
	<body>
		<h2>Leaders Home Page</h2>
		<hr>
		<p> Manage the company well !! </p>
		
		<a href="${pageContext.request.contextPath}/"> Back Home</a>
		
	</body>
</html>