<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
	<html>
	<head>
	<meta charset="ISO-8859-1">
	<link rel = "stylesheet" type="text/css" href ="../style/styles.css" />
	<title>Forgot Password</title>
	</head>
	<body>
		<div class="container">
		<form style="text-align:center" action="${pageContext.request.contextPath}/user/forgot-password" method="post" name="forgot-password">
		<div class="row">
					<h2 style="text-align: center;color:blue">Forgot Password</h2>
					<div class="col">
			<input type="email" name="email" placeholder="Enter Email" required><br/><br/>
			<input type="submit" value="Submit">
			</div>
			</div>
		</form>
		</div>
	</body>
	</html>