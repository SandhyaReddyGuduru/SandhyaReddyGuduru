<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Items</title>
</head>
<body>
<c:forEach var="pr" items="${prs}"><br><br>
<c:out value ="${pr.id}"> </c:out> 
<c:out value ="${pr.name}"> </c:out> 
<c:out value ="${pr.price}"> </c:out>
<a href="addimage?id=${pr.id}" target="_blank"> AddImage </a>
<a href="removeimage?id=${pr.id}" target="_blank"> Remove </a>
</c:forEach>
</body>
</html>