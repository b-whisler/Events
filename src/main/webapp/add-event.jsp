<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Event</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div>
<h1>Add Event</h1>
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
</div>
</body>
</html>