<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Practice Application</title>
</head>
<body>
	<form method="get">
	<header>
		<nav>
			<menu style="background-color:aqua;color:white;text-align:center">
			<font face="arial" size="5">
				<a style="text-decoration: none" href="${pageContext.request.contextPath}/user/home" target="framebody"><em>Home</em></a>
				<span> | </span>
				<a style="text-decoration: none" href="${pageContext.request.contextPath}/about" target="framebody"><em>About Us</em></a>
				<span>|</span>
				<a style="text-decoration: none" href="${pageContext.request.contextPath}/contact" target="framebody"><em>Contact Us</em></a>
				<span> | </span>
				<a style="text-decoration: none" href="${pageContext.request.contextPath}/user/login" target="framebody"><em>Sign In</em></a>
				<span> | </span>
				<a style="text-decoration: none" href="${pageContext.request.contextPath}/user/register" target="framebody"><em>Sign Up</em></a>
				</font>
			</menu>
		</nav>	
	</header>
	<section>
		<iframe name="framebody" src="${pageContext.request.contextPath}/user/home" width="1350" height="500"></iframe>
	</section>
	<footer style="background-color:blue;color:white;text-align:center">
		<pre style="text-align:center;color:orange;font-size:16px"> &copy; Developed By Smruti & Dillip</pre>
		<pre><a style="text-decoration: none;color:white" href="${pageContext.request.contextPath}/user/login" target="framebody">Login</a> /<a style="text-decoration: none;color:white" href="${pageContext.request.contextPath}/user/register" target="framebody"> Register</a> /<a style="text-decoration: none;color:white" href="${pageContext.request.contextPath}/user/home" target="framebody"> Practice</a></pre>
	</footer>
	</form>
</body>
</html>