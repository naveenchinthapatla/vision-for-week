/**
 * 
 */
 
 //Show/Hide Password
 function showPassword(){
	var checkbox = document.getElementById("password");
	if(checkbox.type === "password"){
		checkbox.type = "text";
	}
	else{
		checkbox.type = "password";
	}
}

