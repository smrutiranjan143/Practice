<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel = "stylesheet" type="text/css" href ="../style/styles.css" />
		<script src="../js/password.js"></script>
		<title>Login</title>
	</head>
	<body>
		<div class="container">
			<form  method="post" action = "${pageContext.request.contextPath}/user/login" name="login">
			<div class="row">
				<h2 style="text-align: center;color:blue">Login Here</h2>
				<div class="col">
					<input type="text" name="userCode" placeholder="Username" required>
					<input type="password" name="password" placeholder="Password" required maxlength="25" id="password" onfocus ="focusOn()" onblur = "focusOff()">
					<span id="msg"></span>
					<input type="submit" value="Login" id="submit">
				</div>
			</div>
		</form>
	</div>

	<div style="text-align: center; background-color: #f2f2f2;">

		<a href="${pageContext.request.contextPath}/user/register" style="color: blue" class="btn2">Sign up</a> 
		<a href="${pageContext.request.contextPath}/user/forgot-password" style="color: blue" class="btn2">Forgot Password?</a>
	</div>
	
</body>
</html>
