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
public class OrdersResponse extends BaseResponse {
	private static final long serialVersionUID = 1L;

	private List<OrderDto> orders;

}