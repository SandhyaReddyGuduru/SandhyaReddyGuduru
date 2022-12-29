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
Welcome to Ecart <a href="viewCart"><c:out value="${cart.size()}"></c:out>  Item(s)</a>
<a href="login?c=index">signout</a>
<br></br>
<c:set var="total"  value="${0}"></c:set>
<c:forEach var="pr" items="${cart}">
<c:out value="${pr.name}" ></c:out>&nbsp;&nbsp;
<c:out value="${pr.price}" ></c:out>&nbsp;&nbsp;
<c:out value="${pr.quantity}" ></c:out>&nbsp;&nbsp;
<c:out value="${pr.price*pr.quantity}" ></c:out>&nbsp;&nbsp;
<c:set var="total" value="${totalamount+pr.price*pr.quantity}"></c:set>
<br></br>
</c:forEach>
Total Amount <c:out value="${total}"></c:out>
<br></br>
<c:if test="${empty uid}">
<a href="myorders">placeorder</a>

</c:if>
<c:if test="${not empty uid}">


<a href="myorders">placeorder</a>



</c:if>
</body>
</html>