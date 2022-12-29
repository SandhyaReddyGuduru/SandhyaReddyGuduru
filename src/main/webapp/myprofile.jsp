<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>profile</title>
</head>
<body>

  <c:out  value="${profile.username}"></c:out>&nbsp;
  <c:out  value="${profile.email}"></c:out>&nbsp;
  <c:out  value="${profile.mobile}"></c:out>&nbsp;

  
</body>
</html>