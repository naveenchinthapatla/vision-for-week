package com.project.controller;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.model.User;
import com.project.service.SignUpService;

@Controller
public class SignUpController {
@Autowired
private SignUpService signUpService;

//Returning Sign Up Page
@GetMapping("/signup")
public String getSignUpPage(Model model) {
	return signUpService.getSignUpPage(model);
}

////Validating Your Input, Sending OTP and Redirecting to OTP Page
@PostMapping("/otp")
public String getOTPPage(@ModelAttribute("user")User user, Model model) {
	return signUpService.getOTPPage(user, model);
}

//Handling UnkownHostException
@ExceptionHandler(UnknownHostException.class)
public String handleUnknownHostException(Model model) {
	model.addAttribute("statusCode",HttpStatus.CONFLICT);
	model.addAttribute("errorMessage","Please check your Internet Connection.");
	return "error";
}
}
