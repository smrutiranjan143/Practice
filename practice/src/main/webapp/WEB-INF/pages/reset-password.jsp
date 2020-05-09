<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
	<html>
	<head>
	<meta charset="ISO-8859-1">
	<link rel = "stylesheet" type="text/css" href ="../style/styles.css" />
	<script src ="../js/password.js"></script>
	<title>Reset Password</title>
	</head>
	<body>
		<div class="container">
			<form style="text-align:center" action="${pageContext.request.contextPath}/user/reset-password" method="post">
				<div class="row">
					<h2 style="text-align: center;color:blue">Reset Password</h2>
					<div class="col">
						<input type="password" name="password" placeholder="Enter Current Pasword" required>
					 	<input type="password" name="new_password" placeholder="Enter New Pasword" required maxlength="25" id="password" onfocus ="focusOn()" onblur = "focusOff()">
					 	<span id="msg"></span>
					 	<input type="password" name="rpassword" placeholder="Re-type Pasword" required maxlength="25" id="rpassword" onfocus ="focusOn2()" onblur = "focusOff2()">
					 	<span id="message"></span>
						<input type="submit" value="Change Password" id="submit">
					</div>
				</div>
			</form>
		</div>
	</body>
	</html>