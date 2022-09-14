package com.project.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.service.PlanService;
import com.project.utility.CurrentUser;

@Controller
public class PlanController {
@Autowired
private PlanService planService;
@Autowired
private CurrentUser currentUser;

//Returning Add Plans Page
@GetMapping("/getaddpage")
public String getAddPage(Model model) {
	return planService.getAddPage(model);
}


//Adding this week plans to the database
@PostMapping("/add")
public String addPlans(@RequestParam("sun")String sun,
		@RequestParam("mon")String mon,
		@RequestParam("tue")String tue,
		@RequestParam("wed")String wed,
		@RequestParam("thu")String thu,
		@RequestParam("fri")String fri,
		@RequestParam("sat")String sat, Model model) {
	return planService.addPlans(sun, mon, tue, wed, thu, fri, sat, model);
}

//Displaying all Plans
@GetMapping("/view")
public String viewPlans(Model model) {
	return planService.viewPlans(model);
}

//Removing all plans
@GetMapping("/delete")
public String deletePlans(Model model) {
	return planService.deletePlans(model);
}

//Logging out the user
@GetMapping("/logout")
public String logout(HttpServletResponse response) {
	Cookie cookie = new Cookie("username",null);
	response.addCookie(cookie);
	currentUser.setName(null);
	return "homepage";
}

//Handling Illigal Argument Exception
@ExceptionHandler(IllegalArgumentException.class)
public String handleIlligalArgumentException(Model model) {
	model.addAttribute("statusCode",HttpStatus.CONFLICT);
	model.addAttribute("errorMessage","Login Again.");
	return "error";
}
}
