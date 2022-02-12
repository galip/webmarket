package com.ecommerce.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OrderDetailDto {

	private Long id;
	private String name;
	private Integer quantity;
	private BigDecimal price;
}