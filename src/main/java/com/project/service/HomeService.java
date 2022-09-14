package com.project.service;

import org.springframework.stereotype.Service;

@Service
public class HomeService {
	
//Returning Homepage
public String getHomePage(String username) {
	 if(username.equals("unknown")) {
		 return "homepage";
	 }
	 else {
		 return "features";
	 }
}

//Returning Login Page
public String getLoginPage() {
	return "login";
}
}
