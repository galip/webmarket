package com.ecommerce.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dto.OrderDetailDto;
import com.ecommerce.enums.StatusEnum;
import com.ecommerce.exception.WebMarketException;
import com.ecommerce.model.Order;
import com.ecommerce.model.OrderDetail;
import com.ecommerce.repository.OrderDetailRepository;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.request.CreateOrderRequest;
import com.ecommerce.request.DeleteByOrderIdRequest;
import com.ecommerce.service.OrderService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderDetailRepository orderDetailRepository;

	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	@Transactional
	public Order create(CreateOrderRequest request) throws WebMarketException {
		Order order = new Order();
		order.setCustomerId(request.getCustomerId());
		order.setCreatedUser("createSessionUser");
		order.setCreatedDate(new Date());
		order.setStatus(StatusEnum.ACTIVE.name());
		order.setTotalPrice(calculateTotalOrderFee(request.getOrderDetails()));
		order = orderRepository.save(order);

		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

		List<OrderDetailDto> orderDetailsDto = new ArrayList<OrderDetailDto>();
		orderDetailsDto = request.getOrderDetails();

		for (OrderDetailDto o : orderDetailsDto) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrder(order);
			orderDetail.setName(o.getName()); // should be unique product id, name is just for demo.
			orderDetail.setPrice(o.getPrice()); // fetch from product service;
			orderDetail.setQuantity(o.getQuantity());

			orderDetails.add(orderDetail);
		}
		orderDetails = orderDetailRepository.saveAll(orderDetails);

		return order;
	}

	@Override
	public Optional<Order> getOrderDetailsByOrderId(Long id) throws WebMarketException {

		return orderRepository.findByIdAndStatus(id, StatusEnum.ACTIVE.name());
	}

	private BigDecimal calculateTotalOrderFee(List<OrderDetailDto> orderDetails) throws WebMarketException {
		return orderDetails.stream().map(o -> o.getPrice().multiply(BigDecimal.valueOf(o.getQuantity())))
				.reduce(BigDecimal::add).get();
	}

	public Order delete(DeleteByOrderIdRequest request) throws WebMarketException {
		Optional<Order> o = orderRepository.findByIdAndStatus(request.getId(), StatusEnum.ACTIVE.name());
		Order order = o.isPresent() ? o.get() : null;
		if (order == null)
			throw new WebMarketException("ORDER_NOT_FOUND");
		order.setUpdatedDate(new Date());
		order.setUpdatedUser("deleteSessionUser");
		order.setStatus(StatusEnum.PASSIVE.name());
		return orderRepository.save(order);
	}
}