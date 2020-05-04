/**
 * Developed By Dillip
 */
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
		
	
		
		function submitClk(){
			alert("Form Data will be submitted to Server.");	
		}
		
		function resetClick(){
			alert("Form Data will be Reset. You will loose the Data.");
		}