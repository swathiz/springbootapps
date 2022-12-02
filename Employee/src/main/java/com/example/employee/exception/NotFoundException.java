package com.example.employee.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class NotFoundException extends RuntimeException {
	public NotFoundException(String msg) {
	    super(msg);
	  }
}	
