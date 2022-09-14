package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.model.Plan;
import com.project.model.User;
import com.project.repository.PlanRepository;
import com.project.repository.SignUpRepository;
import com.project.service.HomeService;

@Controller
public class HomeController {
@Autowired
private HomeService homeService;

//Returning Homepage
@GetMapping("/")
public String getHomepage(@CookieValue(value = "username", defaultValue = "unknown")String username) {
	return homeService.getHomePage(username);
}

//Returning Login Page
@GetMapping("login-directly")
public String getLoginPage() {
	return homeService.getLoginPage();
}

}
