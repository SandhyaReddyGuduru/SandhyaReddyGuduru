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
<form action ="addimage" method="post" enctype="multipart/form-data">
<center><input type="hidden" name="${param.id}" ></center><br>
<input type="file" placeholder="itemimage" name="image"><br></br>
<input type="submit" value="submit"></center><br>
</body>
</html>