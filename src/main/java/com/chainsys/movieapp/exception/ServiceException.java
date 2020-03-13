package com.chainsys.movieapp.exception;

public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public ServiceException(Throwable e) {
		super(e);
	}
	public ServiceException(String msg, Throwable e) {
		super(msg, e);
	}
	public ServiceException(String message, Exception e) {
		super(message, e);
	}
	
	
}
