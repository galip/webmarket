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

import com.ecommerce.constants.ErrorCode;
import com.ecommerce.core.ErrorCodes;
import com.ecommerce.exception.OrderNotFoundException;
import com.ecommerce.exception.WebMarketBusinessException;
import com.ecommerce.exception.WebMarketRequestException;
import com.ecommerce.mappers.OrderMapper;
import com.ecommerce.model.Order;
import com.ecommerce.request.CreateOrderRequest;
import com.ecommerce.request.DeleteByOrderIdRequest;
import com.ecommerce.response.BaseResponse;
import com.ecommerce.response.CreateOrderResponse;
import com.ecommerce.response.DeleteOrderResponse;
import com.ecommerce.response.OrderDetailsByOrderResponse;
import com.ecommerce.response.OrdersResponse;
import com.ecommerce.service.OrderService;
import com.ecommerce.validator.OrderValidator;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

	@Autowired
	OrderService orderService;

	@GetMapping("/list")
	@ResponseBody
	public ResponseEntity<OrdersResponse> findAll() throws WebMarketBusinessException {
		List<Order> orders = orderService.findAll();
		if (orders.size() == 0)
			throw new WebMarketBusinessException(ErrorCode.ORDER_NOT_FOUND);
		OrdersResponse response = new OrdersResponse();
		response.setOrders(OrderMapper.convertToDto(orders));
		response.setResult(ErrorCodes.success());
		return ResponseEntity.ok(response);
	}

	/**
	 * @param orderId
	 * @return active(status = 'ACTIVE') order and order details by orderId. 
	 * @throws WebMarketRequestException
	 */
	@GetMapping("/detailsByOrderId/{id}")
	@ResponseBody
	public ResponseEntity<OrderDetailsByOrderResponse> getOrderDetailsById(@PathVariable Long id) throws WebMarketRequestException {
		OrderValidator.validateId(id);
		
		Optional<Order> order = orderService.getOrderDetailsByOrderId(id);
		OrderDetailsByOrderResponse response = new OrderDetailsByOrderResponse();
		response.setOrder(OrderMapper.convertToDto(order.isPresent() ? order.get() : null));
		response.setResult(ErrorCodes.success());
		return ResponseEntity.ok(response);
	}

	/**
	 * @param request
	 * @return creates order and order details transactionally.
	 * @throws WebMarketRequestException
	 * @throws WebMarketBusinessException 
	 */
	@PostMapping("/create")
	@ResponseBody
	public ResponseEntity<CreateOrderResponse> create(@RequestBody CreateOrderRequest request) throws WebMarketBusinessException {
		OrderValidator.validateCreateOrderRequest(request);
		
		Order order = orderService.create(request);
		CreateOrderResponse response = new CreateOrderResponse();
		response.setCreateOrderDto(OrderMapper.convertToCreateOrderDto(order));
		response.setResult(ErrorCodes.success());
		return ResponseEntity.ok(response);
	}
	
	/**
	 * @param request
	 * @return updates status as PASSIVE in order by id.
	 * @throws WebMarketRequestException
	 * @throws WebMarketBusinessException 
	 */
	@PostMapping("/delete")
	@ResponseBody
	public ResponseEntity<BaseResponse> delete(@RequestBody DeleteByOrderIdRequest request) throws WebMarketBusinessException {
		OrderValidator.validateDeleteByOrderIdRequest(request);
		
		Order order = orderService.delete(request);
		DeleteOrderResponse response = new DeleteOrderResponse();
		response.setDeleteOrderDto(OrderMapper.convertToDeleteOrderDto(order));
		response.setResult(ErrorCodes.success());
		return ResponseEntity.ok(response);
	}
}
