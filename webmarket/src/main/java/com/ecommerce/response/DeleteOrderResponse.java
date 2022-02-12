package com.ecommerce.response;

import com.ecommerce.dto.DeleteOrderDto;

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
public class DeleteOrderResponse extends BaseResponse {
	private static final long serialVersionUID = 1L;

	private DeleteOrderDto deleteOrderDto;
}