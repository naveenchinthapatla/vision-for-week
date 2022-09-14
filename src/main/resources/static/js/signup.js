/**
 * 
 */
 
	
 //Show/Hide Password
 function showPassword(){
	var password = document.getElementById("password");
	var conPassword = document.getElementById("conPassword");
	
	if(password.type === "password" && conPassword.type === "password"){
		password.type = "text";
		conPassword.type = "text";
	}
	else{
		password.type = "password";
		conPassword.type = "password";
	}
}


