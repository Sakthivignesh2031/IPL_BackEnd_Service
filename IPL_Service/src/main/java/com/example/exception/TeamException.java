package com.example.exception;

public class TeamException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
	
	public TeamException(String message) {
		super(message);
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TeamException() {
	}

}
