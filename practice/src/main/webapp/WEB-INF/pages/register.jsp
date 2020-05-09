<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.7/angular.min.js"></script>
		<script src = "../js/scripts.js"></script>
		<script src="../js/RegisterController.js"></script>
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />
		<link rel = "stylesheet" type="text/css" href ="../style/inputFields.css" /> 
		<title>Practice - Register</title>
		
	</head>
	<body>
		<div class="container" ng-app="app">
			<h1 style="text-align: center; color: blue;">Register Here</h1><hr/>
			<div ng-controller ="registerController">
				<form style="text-align: center;" action="${pageContext.request.contextPath}/user/register" name="registerForm" method="post" ng-submit="submitClick()" onsubmit="submitClk()" onreset="resetClick()">
					<input type="text" name="userCode" ng-model="userDto.userCode" id="userId" placeholder="Enter UserCode here" required>
					<input type="password" name="password" id="password" placeholder="Enter Password here" ng-model="userDto.password" maxlength="25" required onfocus = "focusOn()" onblur = "focusOff()">
					<span style="font-size: 20px; display: table; margin-left: auto; margin-right: auto;" id="message"></span>
					<input type="password" name="cPassword" placeholder="Enter Confirm Password here" ng-model="userDto.cPassword" id="cPassword" maxlength="25" required onfocus="passwordCheck()" onblur="passwordSame()">
					<span style="font-size: 20px; display: table; margin-left: auto; margin-right: auto;" id="messages"></span> 
					<select name="salutationId" ng-model="userDto.salutationId" id="salutation" style="color:#8e8e8e;" required>
						<option style="color:black" value="-1"> Select the Salutation </option>
						<option style="color:black" value="1">Mr.</option>
						<option style="color:black" value="2">Mrs.</option>
						<option style="color:black" value="3">Miss</option>
						<option style="color:black" value="4">Other</option>
					</select> 
					<input type="text" name="firstName" placeholder="Enter First Name here" ng-model="userDto.firstName"id="fName" required> 
					<input type="text" name="middleName" ng-model="userDto.middleName" placeholder="Enter Middle Name here" id="mName"> 
					<input type="text" name="lastName" ng-model="userDto.lastName" placeholder="Enter Last Name here" id="lName" required> 
					<input type="email" name="email" ng-model="userDto.email" placeholder="Enter Email here" id="email" required> 
					<input type="text" name="mobile" placeholder="Enter Mobile here" ng-model="userDto.mobile" required id="mobile" maxlength="10" onfocus="mobileValidate()" onblur= "validateMobile()" onkeypress="return AllowOnlyNumbers(event)" ng-required="true">
					<span style=" color:red; font-size: 20px; display: table; margin-left: auto; margin-right: auto;" id="msg"></span> <br />
					
					<input type="submit" name="Submit" id="submit" ng-if($scope.userCode==0) class="submitbtn">&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" name="Reset" class="resetbtn">
				</form>
			</div>
		</div>
	</body>
</html> 