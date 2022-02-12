package com.ecommerce.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
public class OrderDetail {
	
	@Id
	@GeneratedValue(generator = "order_detail_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "order_detail_seq_generator", sequenceName = "order_detail_seq")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "QUANTITY")
	private Integer quantity;
	
	@Column(name = "PRICE")
	private BigDecimal price;
}