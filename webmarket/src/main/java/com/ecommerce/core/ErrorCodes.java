package com.ecommerce.core;

import java.io.Serializable;

import com.ecommerce.response.Result;

import lombok.experimental.UtilityClass;
/**
 * @author galip
 * 
 */
@UtilityClass
public class ErrorCodes implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final Result success() {
		Result result = new Result();
		result.setCode("0");
		result.setMessage("Success");
		return result;
	}
	
}