<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Venue Management</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div>
<h1>Venue Management</h1>
<form method = "post" action = "venueSelectionServlet">
<table>
<tr>
<th>Select</th>
<th>Venue</th>
<th>Address</th>
<th>Owner</th>
</tr>
<c:forEach items="${requestScope.venues}" var="venue">
<tr>
 <td><input type="radio" name="id" value="${venue.id}"></td>
 <td>${venue.name}</td>
 <td>${venue.address}</td>
 <td>${venue.ownerName}</td>
 </tr>
</c:forEach>
</table>
<input type = "submit" value = "Add" name = "userSelection">
<input type = "submit" value = "Edit" name = "userSelection">
<input type = "submit" value = "Delete" name = "userSelection">
</form>
<a href="index.html">Back to home</a>
</div>
</body>
</html>