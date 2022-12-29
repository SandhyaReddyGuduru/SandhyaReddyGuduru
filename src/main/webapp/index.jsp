<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="myorders">MyOrders</a><br></br>

<a href="myprofile">MyProfile</a><br></br>

<b>Welcome to Ecart<a href="viewcart"> <c:out value="${cart.size()}"></c:out></a> Item(s)</b>
<a href="login?c=index">signin</a>
<a href="logout?c=index">signout</a>
<c:if test="${empty uid}">

</c:if>
<c:if test="${not empty uid}">
Welcome<c:out value="${uid}"></c:out>

</c:if>
<br><br>
<c:forEach var="pr" items="${prs}">&nbsp;&nbsp;
<c:out value="${pr.name}"></c:out>&nbsp;&nbsp; 
<c:out value="${pr.price}"></c:out>&nbsp;&nbsp;
<img src="${pr.base64Image}" width="340" height="300"/> 
<!--  <img src="data:image/jpg;base64,${pr.base64Image}"/>-->
<a href="addCart?id=${pr.id}">Add to Cart</a>
</c:forEach>
</body>
</html>