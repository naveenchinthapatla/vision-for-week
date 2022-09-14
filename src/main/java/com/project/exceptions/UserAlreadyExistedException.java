package com.project.exceptions;

public class UserAlreadyExistedException extends RuntimeException{

	/**
	 * 
	 */
	String message;
	private static final long serialVersionUID = 1L;
	public UserAlreadyExistedException(String message) {
		super(message);
		this.message = message;
	}
}
