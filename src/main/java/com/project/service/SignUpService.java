package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.project.exceptions.UserAlreadyExistedException;
import com.project.model.User;
import com.project.repository.PlanRepository;
import com.project.repository.SignUpRepository;
import com.project.utility.GenerateOTP;

@Service
public class SignUpService {

@Autowired
private SignUpRepository signUpRepository;

@Autowired
private EmailService emailService;
	
//Returning User Object along with Sign Up Page
public String getSignUpPage(Model model) {
	User user = new User();
	model.addAttribute("user",user);
	return "signup";
}

@Autowired
User user;
//Validating Your Input, Sending OTP and Redirecting to OTP Page,
//in case of new user or else throwing UserAlreadyExistedException.
public String getOTPPage(User user, Model model) {
	this.user = user;
	boolean userExisted = false;
	List<User>allUsers = signUpRepository.findAll();
	for(User currentUser : allUsers) {
		if(user.getEmail().equals(currentUser.getEmail())) {
			userExisted = true;
			break;
		}
	}
	
	boolean password = (user.getPassword().length() > 7 && user.getPassword().length() < 16)?true:false;
	boolean areEqual = (user.getPassword().equals(user.getConPassword()))?true:false;
	
	if(userExisted) {
		throw new UserAlreadyExistedException("'"+user.getEmail()+"' has ALREADY used to SIGN UP. Try to Login now.");
	}
	else {
		if(password && areEqual) {
			sendOTP();
			model.addAttribute("email",user.getEmail());
			return "otp";
		}
		else {
			model.addAttribute("error","Both passwords must be 8-16 characters and same.");
			return "signup";
		}
	}
}

//Writing Email to Send OTP
String otp = GenerateOTP.getOtp();
public void sendOTP() {
	String to = user.getEmail();
	String sub = "Verification";
	String body = "Your One Time Password(OTP) is "+otp;
	emailService.sendEmail(to, sub, body);
}
}
