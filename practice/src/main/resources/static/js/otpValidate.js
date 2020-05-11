
/**
 * Developed By Dillip
 */


function validateOtp(){
				var otp = document.getElementById("otp").value;
				var pattern = /^\d{6}$/;
				if(!otp.match(pattern)){
					document.getElementById("msg").style.color = "red";
					document.getElementById("msg").innerHTML = "<Strong><i> Not a Valid OTP !</strong></i>";
					document.getElementById("submit").disabled = true;
				}
				else{
					document.getElementById("msg").innerHTML = "";	
					document.getElementById("submit").disabled = false;
				}
			}
	function otpValidate(){
		document.getElementById("msg").innerHTML = "";	
		var mobile=document.getElementById("otp").value;
		var pattern= /^\d{6}$/;
		if(!mobile.match(pattern)){
			document.getElementById("submit").disabled = false;
		}
		else{
			document.getElementById("msg").innerHTML = "";	
			document.getElementById("submit").disabled = true;
		}
	}

	function AllowOnlyNumbers(e) {
		
		e = (e) ? e : window.event;
		var clipboardData = e.clipboardData ? e.clipboardData : window.clipboardData;
		var key = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
		var str = (e.type && e.type == "paste") ? clipboardData.getData('Text') : String.fromCharCode(key);

		return (/^\d+$/.test(str));
	}
