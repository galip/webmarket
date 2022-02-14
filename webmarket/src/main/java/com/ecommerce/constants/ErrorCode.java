package com.ecommerce.constants;

import java.io.Serializable;

/**
 * @author galip
 * 
 */
public class ErrorCode implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String REQUEST_NULL = "REQUEST_NULL";
	public static final String ID_NULL_OR_ZERO = "ID_NULL_OR_ZERO";
	public static final String CUSTOMER_ID_NULL_OR_ZERO = "CUSTOMER_ID_NULL_OR_ZERO";
	public static final String ORDER_DETAILS_EMPTY = "ORDER_DETAILS_EMPTY";
	public static final String QUANTITY_NOT_MORE_THAN_ZERO = "QUANTITY_NOT_MORE_THAN_ZERO";
	public static final String ORDER_NOT_FOUND = "ORDER_NOT_FOUND";
}