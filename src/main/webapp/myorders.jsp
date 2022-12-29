<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Orders</title>
</head>
<body>
<c:forEach var="orders" items="${ord}">
<c:out value="${orders.orderid} " ></c:out>&nbsp;&nbsp;
<c:out value="${orders.totalamount} " ></c:out>&nbsp;&nbsp;
<c:out value="${orders.userId}" ></c:out>&nbsp;&nbsp;
<br><br>

<br><br>
</c:forEach>
</body>
</html>