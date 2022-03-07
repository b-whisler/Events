<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Venue</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<form action = "editVenueServlet" method="post">
Name: <input type = "text" name = "name" value="${venueToEdit.name}"><br />
Address: <input type = "text" name = "address" value="${venueToEdit.address}"><br />
Owner's name: <input type = "text" name = "owner" value="${venueToEdit.ownerName}"><br />
<input type = "hidden" name = "id" value="${venueToEdit.id}">
<input type = "submit" value="Edit Venue">
</form> <br />
<a href="index.html">Back to index</a>
</body>
</html>