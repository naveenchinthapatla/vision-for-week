package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.service.OTPService;

@Controller
public class OTPController {
@Autowired
private OTPService otpService;

//Validating OTP and Redirecting to Login Page,
@PostMapping("/login")
public String getLoginPage(Model model, @RequestParam("otp") String otp) {
	return otpService.GetLoginPage(model, otp);
}

//Re-sending OTP
@GetMapping("re-send-otp")
public String reSendOTP() {
	return otpService.reSendOTP();
}
}
