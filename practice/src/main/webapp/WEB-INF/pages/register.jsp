<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
input[type=text], input[type=password], input[type=email]
	{
	width: 50%;
	padding: 15px;
	margin: 5px 0 10px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}
select[id=salutation]
	{
	width: 52%;
	padding: 15px;
	margin: 5px 0 10px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

.submitbtn, .resetbtn {
	background-color: #4CAF50;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 7%;
	opacity: 0.9;
}

.submitbtn:hover, .resetbtn:hover {
	opacity: 1;
}
</style>
<title>Practice - Register</title>
<script type="text/javascript">
	function focusOn() {
		document.getElementById("message").style.color = "blue";
		document.getElementById("message").innerHTML = "<strong><i>Password should contain 8 to 25 characters which contain at least one numeric digit and a special character</strong></i>";
	}
	function focusOff() {
		var password = document.getElementById("password").value;
		var pattern =  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,25}$/;
		if (password.match(pattern)) {
			document.getElementById("message").style.color = "green";
			document.getElementById("message").innerHTML = " <strong><i> Password Verified.</strong></i>";
			document.getElementById("submit").disabled = false;
		} else {
			document.getElementById("message").style.color = "red";
			document.getElementById("message").innerHTML = "<strong><i>Invalid Password ! Try another.</strong></i>";
			document.getElementById("submit").disabled = true;
		}
	}
	function passwordCheck(){
		document.getElementById("messages").style.color = "blue";
		document.getElementById("messages").innerHTML = "<strong><i>Password and Confirm Password should be same</strong></i>";
	}
	function passwordSame(){
		var password = document.getElementById("password").value;
		var confirmpassword = document.getElementById("cPassword").value;
		if(password != confirmpassword){
			document.getElementById("messages").style.color = "red";
			document.getElementById("messages").innerHTML = "<strong><i> Password and Confirm Password does not match.</strong></i>";
			document.getElementById("submit").disabled = true;		
		}
		else{
			document.getElementById("messages").style.color = "green";
			document.getElementById("messages").innerHTML = " <strong><i> Password and Confirm Password matched.</strong></i>";
			document.getElementById("submit").disabled = false;
		}
	}

	function validateMobile(){
		var mobile=document.getElementById("mobile").value;
		var pattern= /^\d{10}$/;
		if(!mobile.match(pattern)){
			document.getElementById("msg").innerHTML = "<Strong><i> Not a Valid Number !</strong></i>";
			document.getElementById("submit").disabled = true;
		}
		else{
			document.getElementById("msg").innerHTML = "";	
			document.getElementById("submit").disabled = false;
		}
	}

	function AllowOnlyNumbers(e) {

		e = (e) ? e : window.event;
		var clipboardData = e.clipboardData ? e.clipboardData : window.clipboardData;
		var key = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
		var str = (e.type && e.type == "paste") ? clipboardData.getData('Text') : String.fromCharCode(key);

		return (/^\d+$/.test(str));
	}
	

	
	function submitClick(){
		alert("Form Data will be submitted to Server.");	
	}
	
	function resetClick(){
		alert("Form Data will be Reset. You will loose the Data.");
	}
</script>
</head>
<body>


	<h1 style="text-align: center; color: aqua;">Register Here</h1>
	<form style="text-align: center;" method="post" onsubmit="submitClick()" onreset="resetClick()">
		<input type="text" name="userCode" id="userId"
			placeholder="Enter UserCode here" required><br /> 
			<input type="password" name="password" id="password"
			placeholder="Enter Password here"  maxlength="25" required onfocus = "focusOn()" onblur = "focusOff()">
			<span style="font-size: 20px; display: table; margin-left: auto; 
			margin-right: auto;" id="message"></span>
			<input type="password" name="cPassword"
			placeholder="Enter Confirm Password here" id="cPassword" maxlength="25" required onfocus="passwordCheck()" onblur="passwordSame()">
			<span style="font-size: 20px; display: table; margin-left: auto; 
			margin-right: auto;" id="messages"></span> 
			<select name="salutationId" id="salutation" style="color:#8e8e8e;" required>
				<option value="-1"> Select the Salutation </option>
				<option value="1">Mr.</option>
				<option value="2">Mrs.</option>
				<option value="3">Miss</option>
				<option value="4">Other</option>
			</select> 
			<input type="text" name="firstName"
			placeholder="Enter First Name here" id="fName" required> 
			<input type="text" name="middleName" placeholder="Enter Middle Name here"
			id="mName"> 
			<input type="text" name="lastName"
			placeholder="Enter Last Name here" id="lName" required> 
			<input type="email" name="email" placeholder="Enter Email here" id="email"
			required> 
			<input type="text" name="mobile"
			placeholder="Enter Mobile here" id="mobile" maxlength="10" onblur= "validateMobile()" onkeypress="return AllowOnlyNumbers(event)" required>
			<span style=" color:red; font-size: 20px; display: table; margin-left: auto; 
			margin-right: auto;" id="msg"></span> 
			<br />
		
		<input type="submit" name="Submit" id="submit" class="submitbtn">&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="reset" name="Reset" class="resetbtn">
	</form>
</body>
</html>