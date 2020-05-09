
/**
 * Developed By Dillip
 */

/* For Login and Reset Password */
/* Start*/
	/*For Only Login */
	/*Start*/
	function focusOn(){
		document.getElementById("msg").innerHTML = "";
		var password = document.getElementById("password").value;
		var pattern =  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,25}$/;
		if (!password.match(pattern)) {
			document.getElementById("submit").disabled = false;
		}
		else{
			document.getElementById("submit").disabled = true;
		}
	}

	function focusOff() {
				var password = document.getElementById("password").value;
				var pattern =  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,25}$/;
				if (!password.match(pattern)) {
					document.getElementById("msg").style.color = "red";
					document.getElementById("msg").innerHTML = "<strong><i>Invalid Password !  Please Try again.</strong></i>";
					document.getElementById("submit").disabled = true;
				} else {
					document.getElementById("msg").innerHTML = "";
					document.getElementById("submit").disabled = false;  
				}
			}
	/*For Only Login */
	/*End*/
	
	function focusOn2(){
		document.getElementById("message").innerHTML = "";
		var password = document.getElementById("password").value;
		var confirmpassword = document.getElementById("rpassword").value;
		if(password != confirmpassword){
			document.getElementById("submit").disabled = false;
		}
		else{
			document.getElementById("submit").disabled = true;
		}
	}
	
			function focusOff2(){
				var password = document.getElementById("password").value;
				var confirmpassword = document.getElementById("rpassword").value;
				if(password != confirmpassword){
					document.getElementById("message").style.color = "red";
					document.getElementById("message").innerHTML = "<strong><i> Password does not match.</strong></i>";
					document.getElementById("submit").disabled = true;		
				}
				else{
					document.getElementById("submit").disabled = false;
				}
			}
			

			/* For Login and Reset Password */
			/* End*/