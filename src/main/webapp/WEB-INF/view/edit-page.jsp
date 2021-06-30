<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit news page</title>
</head>
<body>
	<form:form action="saveeditnews" modelAttribute="news">
		
		<form:hidden path="idnews" value="${news.idnews}"/>
		<form:input path="title" value="${news.title}"/><br>
		<form:input path="brief" value="${news.brief}"/><br>
		<form:input path="content" value="${news.content}"/><br>
		
		<input type="submit" value="Submit">
	
	</form:form>
	
	<form:form action="gotocontentpage">
		 
			<input type="hidden" value="${news.idnews}" name="currentId"> 
		 	<input type="submit" value="Cancel">
		 	
	</form:form>
	
</body>
</html>