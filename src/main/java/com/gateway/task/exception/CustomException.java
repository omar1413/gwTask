package com.gateway.task.exception;

public class CustomException extends RuntimeException{

	private String message;
	
	public static final String BAD_REQUEST_MSG = "BAD REQUEST";
	public final static String NOT_FOUND = "NOT FOUND";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CustomException(String msg){
		message = msg;
	}
	public String getMessage() {
		return message;
	}
	
	
	
	

}
