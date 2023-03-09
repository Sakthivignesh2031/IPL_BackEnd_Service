package com.example.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionAdvice {
	
	@ResponseBody
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String, String> exceptionHandler(NotFoundException exception){
		
		Map<String, String> errorMap=new HashMap<>();
		errorMap.put("errorMessage", exception.getMessage());
		
		return errorMap;
	}
	
	
	@ExceptionHandler(TeamException.class)
	public ResponseEntity<String> teamExceptionHandler(TeamException exception){
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	

}
