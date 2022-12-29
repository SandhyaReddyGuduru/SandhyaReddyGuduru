<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
welcome to admin page
<c:out value="${uid}"/><br><br>
<a href="allorders">all orders</a><br></br>
<a href="allusers">allusers</a><br></br>
<a href="additem">AddItem</a><br></br>
<a href="addImage?id=${pr.id}"target="_blank">AddImage</a><br></br>
<a href="viewItems?id=${pr.id}"target="_blank">ViewItems</a><br></br>
</body>
</html>
