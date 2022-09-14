package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.project.exceptions.ResourceNotFoundException;
import com.project.model.User;
import com.project.repository.SignUpRepository;
import com.project.utility.GenerateOTP;

@Service
public class ResetPasswordService {
@Autowired
private SignUpRepository signUpRepository;
@Autowired
private EmailService emailService;


//Returning Reset Password Page
public String getResetPasswordPage() {
	return "reset-password";
}

String otp = GenerateOTP.getOtp();
@Autowired
private User user;
//Verifying User and Sending OTP for Confirmation
public String verifyUser(String email) {
	boolean userExisted = false;
	List<User>allUsers = signUpRepository.findAll();
	for(User x : allUsers) {
		if(x.getEmail().equals(email)) {
			this.user = x;
			userExisted = true;
			break;
		}
	}
	
	if(userExisted) {
		sendOTP();
		return "reset-pwd-otp";
	}
	else {
		throw new ResourceNotFoundException("No Account is registed with the provided Email Address.");
	}
}

//Verify OTP
public String verifyOTP(String otp,Model model) {
	if(this.otp.equals(otp)) {
		return "set-new-password";
	}
	else {
		model.addAttribute("invalid","Incorrect OTP");
		return "reset-pwd-otp";
	}
}
private String email;
private String password;
private String conPassword;
//Checking passwords prerequisites and equality
public String updatePassword(String password, String conPassword, Model model) {
	boolean length = (password.length() > 7 && password.length() < 16)?true:false;
	boolean areEqual = (password.equals(conPassword))?true:false;
	
	if(length && areEqual) {
		this.password = password;
		this.conPassword = conPassword;
		changeInDb();
		return "login";
	}
	else {
		model.addAttribute("invalid","Both passwords must be 8-16 characters and same.");
		return "set-new-password";
	}
}

//Sending OTP to Reset the Password
public void sendOTP() {
	String to= user.getEmail();
	this.email = user.getEmail();
	String subject = "Reset Password";
	String body = "Your One Time Password(OTP) is "+otp;
	emailService.sendEmail(to, subject, body);
}

//Change password in database
public void changeInDb() {
	User user = signUpRepository.findById(email).get();
	user.setPassword(password);
	user.setConPassword(conPassword);
	signUpRepository.save(user);
	sendSuccessEmail();
}

//Being notified by email
public void sendSuccessEmail() {
	String to = user.getEmail();
	String subject = "Reset Password Successful";
	String body = "Your password has been changed successfully. Thank you.";
	emailService.sendEmail(to, subject, body);
}
}
