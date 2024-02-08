<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
</head>
<body>
	<div style="text-align:center;border:1px solid black">
		<center><h2>Register Page</h2></center>
		<form action="adminregister" method="post">
			<div id="lable">
				<label for="username">Username :</label>
				<input type="text" name="username" placeholder="Username" autofocus="autofocus">
			</div><br><br>
			<div id="lable">
				<label for="Email">Email :</label>
				<input type="email" name="Email" placeholder="Email">
			</div><br><br>
			<div id="lable">
				<label for="Password">Password :</label>
				<input type="password" name="password" placeholder="Password">
			</div><br>
			<div id="lable">
				<button>Register</button>
			</div><br>
		</form>
		<a href="login">Login Page</a>
	</div>
</body>
</html>