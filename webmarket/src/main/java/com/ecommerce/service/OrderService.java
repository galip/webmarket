package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.exception.WebMarketException;
import com.ecommerce.model.Order;
import com.ecommerce.request.CreateOrderRequest;
import com.ecommerce.request.DeleteByOrderIdRequest;

public interface OrderService {

	List<Order> findAll();
	
	Optional<Order> getOrderDetailsByOrderId(Long id) throws WebMarketException;

	Order create(CreateOrderRequest request) throws WebMarketException;
	
	Order delete(DeleteByOrderIdRequest request) throws WebMarketException;
}
