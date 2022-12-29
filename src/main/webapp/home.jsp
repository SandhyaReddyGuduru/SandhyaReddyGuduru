<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
  Sucessfull,Welcome to Homepage

<c:forEach var="pr" items="${cart}">
<c:out value="${pr.name} " ></c:out>&nbsp;&nbsp;
<c:out value="${pr.price}" ></c:out>&nbsp;&nbsp;

<c:set var="total" value="${total+pr.price}"></c:set>
<br></br>
</c:forEach>
<c:out value="${total}"></c:out>
<br></br>
<c:if test="${empty uid}"></c:if>
<a href="login">Signin</a>

<c:if test="${not empty uid}">

</c:if>
</body>
</html>

