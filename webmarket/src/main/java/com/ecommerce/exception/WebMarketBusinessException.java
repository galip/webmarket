package com.ecommerce.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WebMarketBusinessException extends Exception {

	public WebMarketBusinessException(String message) {
		super(message);
	}
}