package com.ecommerce.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DeleteOrderDto {

	private Long id;
	private Long customerId;
	private BigDecimal totalPrice;
	private String status;
	private Date createdDate;
	private String createdUser;
	private Date updatedDate;
	private String updatedUser;
}