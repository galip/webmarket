package com.ecommerce.validator;

import com.ecommerce.constants.ErrorCode;
import com.ecommerce.exception.WebMarketRequestException;
import com.ecommerce.request.CreateOrderRequest;
import com.ecommerce.request.DeleteByOrderIdRequest;

public class OrderValidator {

	public static void validateCreateOrderRequest(CreateOrderRequest request) {
		if (request == null) {
			throw new WebMarketRequestException(ErrorCode.REQUEST_NULL);
		}
		if (request.getCustomerId() == null || request.getCustomerId() == 0L) {
			throw new WebMarketRequestException(ErrorCode.CUSTOMER_ID_NULL_OR_ZERO);
		}
		if (request.getOrderDetails().isEmpty()) {
			throw new WebMarketRequestException(ErrorCode.ORDER_DETAILS_EMPTY);
		}
	}

	public static void validateDeleteByOrderIdRequest(DeleteByOrderIdRequest request) throws WebMarketRequestException {
		if (request == null) {
			throw new WebMarketRequestException(ErrorCode.REQUEST_NULL);
		}
		if (request.getId() == null || request.getId() == 0L) {
			throw new WebMarketRequestException(ErrorCode.ID_NULL_OR_ZERO);
		}
	}

	public static void validateId(Long id) throws WebMarketRequestException {
		if (id == null || id == 0L) {
			throw new WebMarketRequestException(ErrorCode.ID_NULL_OR_ZERO);
		}
	}
}