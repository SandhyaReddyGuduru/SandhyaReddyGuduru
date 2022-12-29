<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="admin" method="post">
<br><center><b>Login page</b></br>


please login!!!<br>

<input type="text" placeholder="username" name="admin"><br>
<input type="hidden" name="c" valu"${param.c}" ><br>
<input type="password" placeholder="password" name="admin"><br>
<input type="submit" value="login"></center></br>


</form>
</body>
</html>