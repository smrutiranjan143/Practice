/**
 * Developed By Dillip
 */
$('document').ready(function(){
	
	function checkPassword(){
		
	var password=document.getElementById("password");
	if(password.value == ""){
		document.getElementById("message").innerHTML="Please fill the Password";
		return false;
	}
}
	
	
});


<select name="salutationId" id="salutation" >
<option value="-1">Select the Salutation</option>
<option value="1"> Mr. </option>
<option value="2"> Mrs. </option>
<option value="3"> Miss </option>
<option value="4"> Others</option>
</select>
