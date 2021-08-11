package com.exam.helper;

public class UserFoundException extends Exception {

	public UserFoundException() {
		super("User with this username already there in DB !! try with another username");
	}

	public UserFoundException(String message) {
		super(message);
	}
}
