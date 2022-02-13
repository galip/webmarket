package com.ecommerce.validator;

import com.ecommerce.constants.ErrorCode;
import com.ecommerce.exception.WebMarketException;
import com.ecommerce.request.CreateOrderRequest;
import com.ecommerce.request.DeleteByOrderIdRequest;


public class OrderValidator {

	public static void validateCreateOrderRequest(CreateOrderRequest request) throws WebMarketException {
		if(request == null) {
			throw new WebMarketException(ErrorCode.REQUEST_NULL);
		}
		if(request.getCustomerId() == 0L) {
			throw new WebMarketException(ErrorCode.CUSTOMER_ID_NULL);
		}
		if(request.getOrderDetails().isEmpty()) {
			throw new WebMarketException(ErrorCode.ORDER_DETAILS_EMPTY);
		}
	}

	public static void validateDeleteByOrderIdRequest(DeleteByOrderIdRequest request) throws WebMarketException {
		if(request == null) {
			throw new WebMarketException(ErrorCode.REQUEST_NULL);
		}
		if(request.getId() == 0L) {
			throw new WebMarketException(ErrorCode.ID_NULL);
		}
	}
	
	public static void validateId(Long id) throws WebMarketException {
		if(id == null || id == 0L) {
			throw new WebMarketException(ErrorCode.ID_NULL);
		}
	}
}