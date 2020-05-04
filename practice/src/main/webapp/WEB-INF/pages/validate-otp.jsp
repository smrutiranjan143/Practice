<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Otp Verification</title>
</head>
<body>
	<form style="text-align: center;" method="post" action = "${pageContext.request.contextPath}/user/validate-otp" name ="generateOtp">
		<input type="hidden" name="email" value=${email}><br/>
		<input type ="text" name= "otp" placeholder="Enter One Time Password" required><br/><br/>
		<input type="submit" value="Verify">
	
	</form>
</body>
</html>