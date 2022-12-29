<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
This is orders view page for users....

<c:forEach var="ord" items="${orders}">
<c:out value="${ord.orderid}"/>&nbsp;&nbsp;<br></br>
<c:out value="${ord.totalamount}"/>&nbsp;&nbsp;<br></br>
<c:out value="${ord.userId}"/>&nbsp;&nbsp;<br></br>
<a href=changeStatus?orderId=${ord.orderid}&status=accept>accept</a>&nbsp;<br></br>
<a href=changeStatus?orderId=${ord.orderid}&status=reject>reject</a>&nbsp;<br></br>

</c:forEach>


</body>
</html>