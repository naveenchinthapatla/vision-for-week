package com.project.controller;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.service.ResetPasswordService;
@Controller
public class ResetPasswordController {
@Autowired
private ResetPasswordService resetPasswordService;

//Returning Reset Password Page
@GetMapping("/reset-password")
public String getResetPasswordPage() {
	return resetPasswordService.getResetPasswordPage();
}

//Verifying User and sending OTP for Confirmation
@PostMapping("/verify-user")
public String verifyUser(@RequestParam("email")String email) {
	return resetPasswordService.verifyUser(email);
}

//Verify OTP
@PostMapping("/verify-otp")
public String verifyOTP(@RequestParam("otp")String otp,Model model) {
	return resetPasswordService.verifyOTP(otp,model);
}

//Checking passwords prerequisites and equality, updating in the database
@PostMapping("/update-password")
public String updatePassword(@RequestParam("password")String password,
		@RequestParam("conPassword")String conPassword, Model model) {
	return resetPasswordService.updatePassword(password, conPassword, model);
}

//Handling UnkownHostException
@ExceptionHandler(UnknownHostException.class)
public String handleUnknownHostException(Model model) {
	model.addAttribute("statusCode",HttpStatus.CONFLICT);
	model.addAttribute("errorMessage","Please check your Internet Connection.");
	return "error";
}
}

