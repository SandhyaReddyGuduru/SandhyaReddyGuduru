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
<c:forEach var="user" items="${users}">
<c:out value="${user.username} " ></c:out>&nbsp;&nbsp;
<c:out value="${user.password} " ></c:out>&nbsp;&nbsp;
<c:out value="${user.fullname} " ></c:out>&nbsp;&nbsp;
<c:out value="${user.email} " ></c:out>&nbsp;&nbsp;
<c:out value="${user.mobile} " ></c:out>&nbsp;&nbsp;</c:forEach>

</body>
</html>