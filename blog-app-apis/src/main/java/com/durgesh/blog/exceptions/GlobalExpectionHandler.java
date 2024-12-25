package com.durgesh.blog.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.durgesh.blog.payloads.ApiResponse;
import com.durgesh.blog.utils.ApiConstants;

@RestControllerAdvice
public class GlobalExpectionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleResourceNotFoundExpection(ResourceNotFoundException ex){
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
			}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		
		Map<String, String> response = new HashMap<String, String>();
		
		ex.getBindingResult().getAllErrors().forEach((error)->{
		String fieldName=((FieldError)error).getField();
		String defaultMessage = error.getDefaultMessage();
		response.put(fieldName, defaultMessage);
		});	
		return new ResponseEntity<Map<String,String>>(response,HttpStatus.BAD_REQUEST);
		
	}

	
}
