<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>orderStatus</title>
</head>
<body>

<c:out value="${message}" ></c:out>

<br></br>
<% Date d=new Date();  %>
<%=d %>
</body>
</html>