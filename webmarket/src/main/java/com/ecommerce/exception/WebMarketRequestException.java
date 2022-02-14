package com.ecommerce.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WebMarketRequestException extends RuntimeException {

	public WebMarketRequestException(String message) {
		super(message);
	}

	public WebMarketRequestException(String message, Throwable cause) {
		super(message, cause);
	}
}