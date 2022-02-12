package com.ecommerce.response;

import com.ecommerce.dto.OrderDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author galip
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsByOrderResponse extends BaseResponse {
	private static final long serialVersionUID = 1L;

	private OrderDto order;

}