package com.chainsys.movieapp.exception;

public class BadCredentialsException extends Exception {

	
	public BadCredentialsException(String message, Exception e) {
		super(message,e);
	}
	
	public BadCredentialsException(String message) {
		super(message);
	}
	
}
