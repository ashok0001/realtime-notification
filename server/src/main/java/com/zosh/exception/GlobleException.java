package com.zosh.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobleException {
	
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetails> UserExceptionHandler(UserException ue, WebRequest web){
		
		ErrorDetails error = new ErrorDetails(ue.getMessage() ,web.getDescription(false),LocalDateTime.now());
		
		
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.BAD_REQUEST);
		
	}

}
