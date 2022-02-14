package com.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WebMarketExceptionHandler {

	@ExceptionHandler(WebMarketRequestException.class)
	public ResponseEntity<?> handleRequestException(WebMarketRequestException e) {

		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
		ApiException apiException = new ApiException(e.getMessage(), httpStatus);
		return new ResponseEntity<>(apiException, httpStatus);
	}
	
	@ExceptionHandler(WebMarketBusinessException.class)
	public ResponseEntity<?> handleBusinessException(WebMarketBusinessException e) {

		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		ApiException apiException = new ApiException(e.getMessage(), httpStatus);
		return new ResponseEntity<>(apiException, httpStatus);
	}
}
