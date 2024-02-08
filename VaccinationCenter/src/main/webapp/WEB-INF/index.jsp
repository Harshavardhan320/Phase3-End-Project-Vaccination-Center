<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div style="text-align:center;border:1px solid black">
		<center><h2>Login Page</h2></center>
		<form action="adminlogin" method="get">
			<div id="lable">
				<label for="username">Username :</label>
				<input type="text" name="username" placeholder="Username" autofocus="autofocus" value="harsha">
			</div><br><br>
			<div id="lable">
				<label for="Password">Password :</label>
				<input type="password" name="password" placeholder="Password" value="vardhan">
			</div><br><br>
			<div id="lable">
				<button>Login</button>
			</div><br>
			<a href="register">Register</a><br><br>
		</form>
		<p style="color:green">${message}</p>
	</div>
</body>
</html>