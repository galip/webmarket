package com.ecommerce.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Table(name = "ORDERS")
@Accessors(chain = true)
public class Order {
	
	@Id
	@GeneratedValue(generator = "order_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "order_seq_generator", sequenceName = "order_seq")
	private Long id;
	
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	private List<OrderDetail> orderDetails;
	
	@Column(name = "CUSTOMER_ID")
	private Long customerId;
	
	@Column(name = "STATUS")
	private String status;
	
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Column(name = "CREATED_USER")
	private String createdUser;
	
	@Temporal(TemporalType.DATE)
	private Date updatedDate;
	
	@Column(name = "UPDATED_USER")
	private String updatedUser;
	
	private BigDecimal totalPrice;
}