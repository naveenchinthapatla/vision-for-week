package com.project.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.service.LoginService;
@Controller
public class LoginController {
@Autowired
private LoginService loginService;

//Returing to Features Page if user is valid, or else, 
//throwing EntityNotFoundException
@PostMapping("/login-now")
public String loginNow(@RequestParam("email")String email,
		@RequestParam("password")String password, Model model, HttpServletResponse response) {
	return loginService.loginNow(model, email, password, response);
}

}

