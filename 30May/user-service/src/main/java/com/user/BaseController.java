package com.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleException(MethodArgumentNotValidException exp){
		
		Map<String, String> errorMessages = new HashMap<>();
		exp.getAllErrors().forEach(error -> {
				String fieldname = ((FieldError)error).getField();
				String message = ((FieldError)error).getDefaultMessage();
				errorMessages.put(fieldname, message);
			}
		);
		return errorMessages;
				
	}

}
