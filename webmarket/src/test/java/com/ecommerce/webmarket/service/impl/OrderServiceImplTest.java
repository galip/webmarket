package com.ecommerce.webmarket.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.dto.OrderDetailDto;
import com.ecommerce.enums.StatusEnum;
import com.ecommerce.exception.WebMarketException;
import com.ecommerce.model.Order;
import com.ecommerce.repository.OrderDetailRepository;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.request.CreateOrderRequest;
import com.ecommerce.request.DeleteByOrderIdRequest;
import com.ecommerce.service.OrderService;

@SpringBootTest
class OrderServiceImplTest {

	@Autowired
	OrderService orderService;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderDetailRepository orderDetailRepository;

	Order order = new Order();

	@BeforeEach
	void beforeEach() {
		order.setCustomerId(1L);
		order.setCreatedUser("createSessionTestUser");
		order.setCreatedDate(new Date());
		order.setStatus(StatusEnum.ACTIVE.name());
		order.setTotalPrice(BigDecimal.TEN);
		order = orderRepository.save(order);
	}

	@AfterEach
	void afterEach() {
		orderRepository.deleteAll();
		orderDetailRepository.deleteAll();
	}

	@Test
	void shouldReturnActiveOrder_whenGetOrderDetailsByOrderId_withValidId() throws WebMarketException {
		Optional<Order> optionalOrder = orderService.getOrderDetailsByOrderId(order.getId());

		assertEquals(order.getCustomerId(), optionalOrder.get().getCustomerId());
		assertEquals(order.getCreatedUser(), optionalOrder.get().getCreatedUser());
		assertTrue(order.getTotalPrice().compareTo(optionalOrder.get().getTotalPrice()) == 0);
		assertEquals(order.getStatus(), optionalOrder.get().getStatus());

	}

	@Test
	void shouldReturnCreatedOrder_whenCreate_withValidRequest() throws WebMarketException {
		orderRepository.deleteAll();
		orderDetailRepository.deleteAll();

		CreateOrderRequest request = new CreateOrderRequest();
		request.setCustomerId(12345L);

		List<OrderDetailDto> orderDetails = new ArrayList<>();
		OrderDetailDto firstOrderDetail = new OrderDetailDto();
		firstOrderDetail.setName("Pencil");
		firstOrderDetail.setQuantity(2);
		firstOrderDetail.setPrice(BigDecimal.TEN);
		orderDetails.add(firstOrderDetail);

		OrderDetailDto secondOrderDetail = new OrderDetailDto();
		secondOrderDetail.setName("Book");
		secondOrderDetail.setQuantity(4);
		secondOrderDetail.setPrice(BigDecimal.valueOf(30));
		orderDetails.add(secondOrderDetail);

		request.setOrderDetails(orderDetails);
		Order order = orderService.create(request);
		assertNotNull(order.getId());
		assertEquals(request.getCustomerId(), order.getCustomerId());
		assertEquals(BigDecimal.valueOf(140), order.getTotalPrice());
	}

	@Test
	void shouldMakeOrderPassive_whenDelete_withValidIdRequest() throws WebMarketException {
		DeleteByOrderIdRequest request = new DeleteByOrderIdRequest();
		request.setId(order.getId());

		Order deletedOrder = orderService.delete(request);

		assertEquals(order.getCustomerId(), deletedOrder.getCustomerId());
		assertEquals("deleteSessionUser", deletedOrder.getUpdatedUser());
		assertEquals(StatusEnum.PASSIVE.name(), deletedOrder.getStatus());
	}
}
