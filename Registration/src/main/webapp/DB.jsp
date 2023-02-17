<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Registration Page</h1>
	<div align="center">
		<form action="Register" method=post>
			<table>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>User Email</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><input type="text" name="phone"></td>
				</tr>
				<tr>
				<td></td>
				<td><input type = "submit" name = "register">
			</table>

		</form>

	</div>
</body>
</html>