package com.ecommerce.response;

import com.ecommerce.dto.CreateOrderDto;

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
public class CreateOrderResponse extends BaseResponse {
	private static final long serialVersionUID = 1L;

	private CreateOrderDto createOrderDto;
}