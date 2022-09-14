function makeSure(){
	
	if(confirm("Are you sure to remove all your plans?") == true){
		window.location.href="/delete";
	}
}