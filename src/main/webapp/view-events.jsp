<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Event Management</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div>
<h1>Event Management</h1>
   <form method = "post" action = "eventSelectionServlet">
<table>
<tr>
<th>Select</th>
<th>Event</th>
<th>Venue Name</th>
<th>Venue Address</th>
<th>Date</th>
</tr>
<c:forEach items="${requestScope.events}" var="event">
<tr>
 <td><input type="radio" name="id" value="${event.id}"></td>
 <td>${event.name}</td>
 <td>${event.venue.name}</td>
 <td>${event.venue.address}</td>
 <td>${event.date}</td>
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