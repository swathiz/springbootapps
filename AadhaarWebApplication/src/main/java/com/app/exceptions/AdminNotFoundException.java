package com.app.exceptions;

public class AdminNotFoundException extends RuntimeException {
	public AdminNotFoundException() {
		super("Invalid admin name or password");
	}
}