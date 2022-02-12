package com.ecommerce.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OrderDto {
	
	private Long id;
	private Long customerId;
	private String status;
	private Date createdDate;
	private String createdUser;
	private Date updatedDate;
	private String updatedUser;
	private BigDecimal totalPrice;
	
	private List<OrderDetailDto> orderDetails;
}