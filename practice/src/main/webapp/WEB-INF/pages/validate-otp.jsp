<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../style/styles.css" />
<script src="../js/otpValidate.js"></script>
<title>Otp Verification</title>
</head>
<body>
	<div class="container">
		<form style="text-align: center;" method="post"
			action="${pageContext.request.contextPath}/user/validate-otp"
			name="generateOtp">
			<div class="row">
				<h2 style="text-align: center; color: blue">Login Here</h2>
				<div class="col">
					<input type="hidden" name="email" value=${email}> <br /> <input
						type="text" name="otp" placeholder="Enter One Time Password"
						required maxlength="6" id="otp" onfocus="otpValidate()"
						onblur="validateOtp()" onkeypress="return AllowOnlyNumbers(event)">
					<span id="msg"></span> <input type="submit" value="Verify"
						id="submit">
				</div>
			</div>
		</form>
	</div>
</body>
</html>