package com.ecommerce.request;

import java.io.Serializable;
import java.util.List;

import com.ecommerce.dto.OrderDetailDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author galip
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateOrderRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long customerId;
	private String status;
	List<OrderDetailDto> orderDetails;
}