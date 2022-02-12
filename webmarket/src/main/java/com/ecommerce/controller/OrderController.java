package com.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.constants.ErrorCodes;
import com.ecommerce.exception.WebMarketException;
import com.ecommerce.mappers.OrderMapper;
import com.ecommerce.model.Order;
import com.ecommerce.request.CreateOrderRequest;
import com.ecommerce.response.CreateOrderResponse;
import com.ecommerce.response.OrderDetailsByOrderResponse;
import com.ecommerce.response.OrdersResponse;
import com.ecommerce.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

	@Autowired
	OrderService orderService;

	@GetMapping("/list")
	@ResponseBody
	public ResponseEntity<OrdersResponse> findAll() throws WebMarketException {
		List<Order> orders = orderService.findAll();
		if (orders.size() == 0)
			throw new WebMarketException("ORDER_NOT_FOUND");
		OrdersResponse response = new OrdersResponse();
		response.setOrders(OrderMapper.convertToDto(orders));
		response.setResult(ErrorCodes.success());
		return ResponseEntity.ok(response);
	}

	@GetMapping("/detailsByOrderId/{id}")
	@ResponseBody
	public ResponseEntity<OrderDetailsByOrderResponse> getOrderDetailsById(@PathVariable Long id) throws WebMarketException {
		if (id == null || id == 0L)
			throw new WebMarketException("ORDER_NOT_FOUND");
		Optional<Order> order = orderService.getOrderDetailsByOrderId(id);
		OrderDetailsByOrderResponse response = new OrderDetailsByOrderResponse();
		response.setOrder(OrderMapper.convertToDto(order.isPresent() ? order.get() : null));
		response.setResult(ErrorCodes.success());
		return ResponseEntity.ok(response);
	}

	@PostMapping("/create")
	@ResponseBody
	public ResponseEntity<CreateOrderResponse> create(@RequestBody CreateOrderRequest request) throws WebMarketException {
		CreateOrderResponse response = new CreateOrderResponse();
		
		Order order = orderService.createOrder(request);
		response.setCreateOrderDto(OrderMapper.convertToCreateOrderDto(order));
		response.setResult(ErrorCodes.success());
		return ResponseEntity.ok(response);
	}
}
