<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>additem</title>
</head>
<body>

<form action ="uploadfolder" method="post" enctype="multipart/form-data">
<input type="text" placeholder="itemid" name="id"><br></br>
<input type="text" placeholder="itemname" name="name"><br></br>
<input type="text" placeholder="itemprice" name="price"><br></br>
<input type="file" placeholder="itemimage" name="image"><br></br>
<input type="submit" value="submit"></center><br>
</form>
</body>
</html>