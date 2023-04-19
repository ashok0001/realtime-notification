package com.zosh.exception;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobleException {
	
	
	public ResponseEntity<ErrorDetails> UserExceptionHandler(UserException ue, WebRequest web){
		
		ErrorDetails error = new ErrorDetails(ue.getMessage() ,web.getDescription(false),LocalDateTime.now());
		
		
		return null;
		
	}

}
