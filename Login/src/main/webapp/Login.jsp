<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Info</title>
</head>
<body>
<form action = LoginServlet method = post>
<table>
	<tr><td>Enter UserName :</td><td> <input type = "text" name = "t1"></td></tr>
	<tr><td>Enter Password :</td><td>  <input type = "password" name = "t2"></td></tr>
	<tr><td><input type = submit value = Login> <input type = reset></td></tr>
</table>

</form>
</body>
</html>