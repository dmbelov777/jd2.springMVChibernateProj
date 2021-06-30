<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration page</title>
</head>
<body>

	<c:out value="${message}"></c:out>
	
	<form:form action="saveNewUser" method="post" modelAttribute="user">
			
		First name: <form:input path="firstName" placeholder="Enter first name"/><br/>
		Last name: <form:input path="lastName" placeholder="Enter last name"/><br/>
		Year of birth: <form:input path="year" placeholder="Enter year of birth"/><br/>
		Phone number: <form:input path="phone" placeholder="Enter your phone number"/><br/>
		Login: <form:input path="login" placeholder="Enter login"/><br/>
		Password: <form:input path="password" placeholder="Enter password"/><br/>
	
		<input type="submit" value="Submit" />
		
	</form:form>	
	
	<form:form action="mainPage" method="post">
	
		<input type="submit" value="Back">
	
	</form:form>
	
</body>
</html>