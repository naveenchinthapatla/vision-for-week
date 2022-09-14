package com.project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

//UserAlreadyExistedException Handler
@ExceptionHandler
public String handleUserAlreadyExistedException(UserAlreadyExistedException ex, Model model) {
	model.addAttribute("errorMessage",ex.message);
	model.addAttribute("statusCode",HttpStatus.CONFLICT);
	return "error";
}

//ResourceNotFoundException Handler
@ExceptionHandler
public String handleResourceNotFoundException(ResourceNotFoundException ex, Model model) {
	model.addAttribute("errorMessage",ex.message);
	model.addAttribute("statusCode",HttpStatus.NOT_FOUND);
	return "error";
}
}
