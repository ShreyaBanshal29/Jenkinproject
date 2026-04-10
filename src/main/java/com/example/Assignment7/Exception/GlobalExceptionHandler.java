package com.example.Assignment7.Exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//    ResponseEntity<String> handlerForWrongArgumentException(MethodArgumentNotValidException ee)  {
//    	return new ResponseEntity<>(ee.getMessage(),HttpStatus.BAD_REQUEST);
//    }

	 @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<Map<String,String>> handlerForWrongArgumentException(MethodArgumentNotValidException ee)  {
    	List<FieldError> FieldErrors = ee.getFieldErrors();
    	Map<String,String> maps = new HashMap<>();
    	for(FieldError ff:FieldErrors) {
    		String name = ff.getField();
    		String message = ff.getDefaultMessage();
    		maps.put(name, message);
    	}
		 return new ResponseEntity<>(maps,HttpStatus.BAD_REQUEST);
    }

}
