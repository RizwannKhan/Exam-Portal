package com.exam.helper;

public class UserNotFoundException extends Exception {
	
	public UserNotFoundException() {
		super("User with this username not found in DB !!");
	}

	public UserNotFoundException(String message) {
		super(message);
	}

}
