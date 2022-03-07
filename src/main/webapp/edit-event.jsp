<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Event</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<form action = "editEventServlet" method="post">
Name: <input type = "text" name = "name" value="${eventToEdit.name}"><br />
Venue: <select name="venue">
		<c:forEach items="${allVenues}" var="venue">
			<option value="${venue.id}">${venue.name}</option>
		</c:forEach>
	</select><br />
Date: <input type = "date" name = "date" value="${eventToEdit.date}"><br />
<input type = "hidden" name = "id" value="${eventToEdit.id}">
<input type = "submit" value="Edit Event">
</form> <br />
<a href="index.html">Back to index</a>
</body>
</html>