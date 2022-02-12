package com.ecommerce.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.ecommerce.dto.CreateOrderDto;
import com.ecommerce.dto.DeleteOrderDto;
import com.ecommerce.dto.OrderDetailDto;
import com.ecommerce.dto.OrderDto;
import com.ecommerce.model.Order;
import com.ecommerce.model.OrderDetail;

import lombok.Data;

@Data
public class OrderMapper {

	public static List<OrderDto> convertToDto(List<Order> orders) {
		if (orders.isEmpty()) {
			return null;
		}
		OrderDto orderDto = new OrderDto();
		return orders.stream().map(o -> orderDto.setId(o.getId()).setCustomerId(o.getCustomerId())
				.setStatus(o.getStatus()).setTotalPrice(o.getTotalPrice())).collect(Collectors.toList());
	}

	public static OrderDto convertToDto(Order order) {
		if (order == null) {
			return null;
		}
		OrderDto orderDto = new OrderDto();
		orderDto.setId(order.getId());
		orderDto.setCustomerId(order.getCustomerId());
		orderDto.setOrderDetails(order.getOrderDetails() != null ? convertToOrderDetailDto(order.getOrderDetails()) : null);
		orderDto.setStatus(order.getStatus());
		orderDto.setTotalPrice(order.getTotalPrice());
		orderDto.setCreatedUser(order.getCreatedUser());
		orderDto.setCreatedDate(order.getCreatedDate());
		orderDto.setUpdatedDate(order.getUpdatedDate());
		orderDto.setUpdatedUser(order.getUpdatedUser());
		return orderDto;

	}

	public static List<OrderDetailDto> convertToOrderDetailDto(List<OrderDetail> orderDetails) {
		if (orderDetails.isEmpty()) {
			return null;
		}
		return orderDetails.stream()
				.map(p -> new OrderDetailDto().setId(p.getId()).setName(p.getName()).setPrice(p.getPrice())
						.setQuantity(p.getQuantity()))
				.collect(Collectors.toList());
	}
	
	public static CreateOrderDto convertToCreateOrderDto(Order order) {
		if (order == null) {
			return null;
		}
		CreateOrderDto orderDto = new CreateOrderDto();
		orderDto.setId(order.getId());
		orderDto.setCustomerId(order.getCustomerId());
		orderDto.setStatus(order.getStatus());
		orderDto.setTotalPrice(order.getTotalPrice());
		orderDto.setCreatedUser(order.getCreatedUser());
		orderDto.setCreatedDate(order.getCreatedDate());
		return orderDto;
	}
	
	public static DeleteOrderDto convertToDeleteOrderDto(Order order) {
		if (order == null) {
			return null;
		}
		DeleteOrderDto deleteOrderDto = new DeleteOrderDto();
		deleteOrderDto.setId(order.getId());
		deleteOrderDto.setCustomerId(order.getCustomerId());
		deleteOrderDto.setStatus(order.getStatus());
		deleteOrderDto.setTotalPrice(order.getTotalPrice());
		deleteOrderDto.setCreatedUser(order.getCreatedUser());
		deleteOrderDto.setCreatedDate(order.getCreatedDate());
		deleteOrderDto.setUpdatedDate(order.getUpdatedDate());
		deleteOrderDto.setUpdatedUser(order.getUpdatedUser());
		return deleteOrderDto;
	}
}