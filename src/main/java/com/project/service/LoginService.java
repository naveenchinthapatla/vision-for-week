package com.project.service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.project.exceptions.ResourceNotFoundException;
import com.project.model.User;
import com.project.repository.SignUpRepository;
import com.project.utility.CurrentUser;

@Service
public class LoginService {

@Autowired
private SignUpRepository signUpRepository;
@Autowired
private User user;
@Autowired
private CurrentUser currentUser;

//Validating User Credentials and Letting him login
public String loginNow(Model model, String email, String password, HttpServletResponse response) {
	
	boolean userExisted = false;
	List<User>allUsers = signUpRepository.findAll();
	for(User x : allUsers) {
		if(x.getEmail().equals(email)) {
			this.user = x;
			userExisted = true;
			break;
		}
	}
	
	if(!userExisted) {
		throw new ResourceNotFoundException("You have not SIGNED UP yet. Try to SIGN UP now.");
	}
	else {
		if(user.getPassword().equals(password)) {
			currentUser.setName(email);
			setCookie(response,email);
			return "features";
		}
		else {
			model.addAttribute("email",email);
			model.addAttribute("invalid","Incorrect Password");
			return "login";
		}
	}
}

public void setCookie(HttpServletResponse response, String email) {
	Cookie cookie = new Cookie("username",currentUser.getName());
	cookie.setMaxAge(15*24*60*60);
	response.addCookie(cookie);
}

}

