<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Content page</title>
</head>
<body>
	
	<h2><c:out value="${news.title}"></c:out></h2><br>
	<p><c:out value="${news.brief}"></c:out></p><br>
	<c:out value="${news.content}"></c:out><br>
	<c:out value="${news.date}"></c:out><br>
	
	<form:form action="gotonewspage">
		<input type="submit" value="Back">
	</form:form>
	
	<c:if test="${user.role eq 'admin'}">
		
		<form:form action="editnews" modelAttribute="news">
			<form:hidden path="idnews" value="${news.idnews}" />
			<form:hidden path="title" value="${news.title}" />
			<form:hidden path="brief" value="${news.brief}" />
			<form:hidden path="content" value="${news.content}" />
			<input type="submit" value="Edit">		
		</form:form>
		
		<form:form action="deletenews" modelAttribute="news">
			<form:hidden path="idnews" value="${news.idnews}"/>
			<input type="submit" value="Delete">
		</form:form>
		
	</c:if>
	
</body>
</html>