package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.exception.WebMarketException;
import com.ecommerce.model.Order;
import com.ecommerce.request.CreateOrderRequest;

public interface OrderService {

	List<Order> findAll();
	
	Optional<Order> getOrderDetailsByOrderId(Long id) throws WebMarketException;

	Order createOrder(CreateOrderRequest request) throws WebMarketException;
}
