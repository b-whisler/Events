<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "addEventServlet" method="post">
Name: <input type = "text" name = "name"><br />
Venue: <select name="venue">
		<c:forEach items="${allVenues}" var="venue">
			<option value="${venue.id}">${venue.name}</option>
		</c:forEach>
	</select><br />
Date: <input type = "date" name = "date"><br />
<input type = "submit" value="Add Event">
</form> <br />
<a href="index.html">Back to index</a>
</body>
</html>