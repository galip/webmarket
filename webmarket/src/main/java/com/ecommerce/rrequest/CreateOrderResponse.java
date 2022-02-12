package com.ecommerce.rrequest;

import java.util.List;

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
public class CreateOrderResponse extends BaseResponse {
	private static final long serialVersionUID = 1L;

	private OrderDto order;
	private List<OrderDto> orders;

}