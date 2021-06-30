<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>News-page</title>
</head>
<body>

	<c:out value="${message}"></c:out>

	<table>
	
		<c:forEach var="tempNews" items="${news}">
			<tr>
				<td>
					<c:choose>
						<c:when test="${tempNews.status eq 'deleted'}">News was deleted</c:when>
						<c:otherwise>
							${tempNews.title} 
							<form:form action="gotocontentpage">
								<input type="hidden" value="${tempNews.idnews}" name="currentId">
								<input type="submit" value="see more...">
							</form:form>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	
	</table>
	
	<form:form action="logout" >
	
		<input type="submit" value="Logout">
			
	</form:form>	

</body>
</html>