<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Address</title>
        <!-- <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script> -->
        <script src="../js/jQuery.min.js"></script>
 		<link rel = "stylesheet" type="text/css" href ="../style/inputFields.css" />
        <script type="text/javascript" src="../js/address.js"></script> 
        <script src="../js/otpValidate.js"></script>
    </head>
		<body>
		<h1 style="text-align: center; color: blue;">Fill Your Full Address</h1><hr/>
		<form style="text-align: center" action="${pageContext.request.contextPath }/user/address" method="post">
		<input type="hidden" name="userId" value=${userId}> <br />
		<input type="text" name="addressLine1" placeholder=" Enter Addressline1" required>
		<input type="text" name="addressLine2" placeholder=" Enter Addressline2" required>
		
		<select id="country" name="countryId" required>
			<option value="-1">----Select Country----</option>
	                        <c:forEach items="${countries}" var="country">
	                            <option value="${country.countryId}">${country.countryName}</option>
	                        </c:forEach>
	                    </select>
		<select id="state" name="stateId"required>
			<option value="-1">----Select State----</option>
		 </select>
		<select id="city" name="cityId"required>
			<option value="-1">----Select City----</option>
		</select>
		<input type="text" name="zip" placeholder="Enter Zip" maxlength="6" required onkeypress="return AllowOnlyNumbers(event)"><br/><br/>
		<input type="submit" value="Submit" class="submitbtn">&nbsp;&nbsp;&nbsp;
		<input type="reset" value="Reset" class="resetbtn">
		</form>
	</body>
</html>