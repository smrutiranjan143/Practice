<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
.href{
	padding: 12px;
	margin: 5px 0;
	display: inline-block;
	font-size: 19px;
	line-height: 2px;
	text-decoration: none;	
}
</style>
<title>Logged In User</title>
</head>
<body>
	<div style="text-align:center; color:green">
		<h2>Dear ${usercode}, You are logged In....</h2>
		 <div>
			<a href="${pageContext.request.contextPath}/user/reset-password" class="href">Rest Password</a>
		</div>
		<div>
		<a href="${pageContext.request.contextPath}/user/logout" class="href">Logout</a>
		</div>
	</div>
</body>
</html>