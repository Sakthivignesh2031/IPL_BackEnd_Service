package com.example.exception;

public class NotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NotFoundException(int id) {
		super("cound not found this id : " + id + " ...!");
	}

}
