package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.project.model.Plan;
import com.project.repository.PlanRepository;
import com.project.repository.SignUpRepository;
import com.project.utility.CurrentUser;

@Service
public class OTPService {

@Autowired
private SignUpService signUpService;
@Autowired
private SignUpRepository signUpRepository;
@Autowired
private CurrentUser currentUser;

@Autowired
private PlanRepository planRepository;

@Autowired
private Plan plan;

@Autowired
private EmailService emailService;

//Validating OTP and Redirecting to Login Page,
public String GetLoginPage(Model model, String otp) {
	if(signUpService.otp.equals(otp)) {
		signUpRepository.save(signUpService.user);
		plan.setEmail(signUpService.user.getEmail());
		planRepository.save(plan);
		sendSuccessEmail(signUpService.user.getEmail());
		currentUser.setName(signUpService.user.getEmail());
		return "features";
	}
	else {
		model.addAttribute("error","Incorrect OTP");
		return "otp";
	}
}

//Re-send OTP
public String reSendOTP() {
	signUpService.sendOTP();
	return "otp";
}

//Sedning Sign Up Successful Email
public void sendSuccessEmail(String to) {
	String subject = "Successful Sign Up";
	String body = "Congratulations "+signUpService.user.getFirstName()+", you have signed up successfully. Thank you.";
	emailService.sendEmail(to, subject, body);
}
}
