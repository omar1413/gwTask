package com.gateway.task.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.gateway.task.exception.CustomException;

public class BaseController {
	
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler()
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
	
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler()
	public Map<String, String> handleValidationExceptions(
			CustomException ex) {
	    Map<String, String> errors = new HashMap<>();
	        errors.put("error", ex.getMessage());
	  
	    return errors;
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler()
	public Map<String, String> handleValidationExceptions(
			Exception ex) {
	    Map<String, String> errors = new HashMap<>();
	        errors.put("error", "Bad Request");
	  
	    return errors;
	}

}
