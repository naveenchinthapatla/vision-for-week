function displayFields(){
	var today = new Date();
	
	//Monday
	if(today.getDay() == 1){
		document.getElementById("sun").style.visibility="hidden"
		document.getElementById("mon").style.visibility="hidden";
	}
	//Tuesday
	if(today.getDay() == 2){
		document.getElementById("sun").style.visibility="hidden";
		document.getElementById("mon").style.visibility="hidden"
		document.getElementById("tue").style.visibility="hidden"
	}
	//Wednesday
	if(today.getDay() == 3){
		document.getElementById("sun").style.visibility="hidden"
		document.getElementById("mon").style.visibility="hidden"
		document.getElementById("tue").style.visibility="hidden"
		document.getElementById("wed").style.visibility="hidden"
	}
	//Thursday
	if(today.getDay() == 4){
		document.getElementById("sun").style.visibility="hidden"
		document.getElementById("mon").style.visibility="hidden"
		document.getElementById("tue").style.visibility="hidden"
		document.getElementById("wed").style.visibility="hidden"
		document.getElementById("thu").style.visibility="hidden"
	}
	//Friday
	if(today.getDay() == 5){
		document.getElementById("sun").style.visibility="hidden"
		document.getElementById("mon").style.visibility="hidden"
		document.getElementById("tue").style.visibility="hidden"
		document.getElementById("wed").style.visibility="hidden"
		document.getElementById("thu").style.visibility="hidden"
		document.getElementById("fri").style.visibility="hidden"
	}
	//Saturday
	if(today.getDay() == 6){
		
	}
	//Sunday
	if(today.getDay() == 0){
		document.getElementById("sun").style.visibility="hidden"
	}
	
}