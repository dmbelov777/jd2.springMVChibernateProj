<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Welcome page</title>
</head>
<body>

	<c:out value="${message}" />
	
	<form:form action="logination" modelAttribute="user" method="POST">
	
		Login:<br/>
		<form:input path="login"/><br/>
		Password:<br/>
		<form:password path="password"/>
	
		<input type="submit" value="Submit">
		
	</form:form>
	
	<a href="registration">Registration</a>	
	
</body>
</html>