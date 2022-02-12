package com.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	public Optional<Order> findByIdAndStatus(Long id, String status);
}