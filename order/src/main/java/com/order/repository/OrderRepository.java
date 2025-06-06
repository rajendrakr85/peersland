package com.order.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	Optional<Order> findByOrderId(Integer orderId);
	List<Order> findByOrderStatus(String pending);
	
	
	
	
}
