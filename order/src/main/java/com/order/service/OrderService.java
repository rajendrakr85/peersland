package com.order.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.exception.ResourceNotFoundException;
import com.order.model.Order;
import com.order.model.OrderItem;
import com.order.repository.OrderRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findOrderByStatus(String status) {
		return orderRepository.findByOrderStatus(status);
	}
	
	public Optional<Order> getOrder(Integer orderid) {
		return orderRepository.findByOrderId(orderid);
	}
	
	public Order saveOrder(Order order) {
		if(order==null) {
			throw new ResourceNotFoundException("Order request have some problem.");
		}
		order.setCreatedTime(LocalDateTime.now()); // set current time
        order.setOrderStatus("PENDING");         // set initial status
        
        for (OrderItem item : order.getItems()) {
            item.setOrder(order); // 👈 Set the back-reference
        }
        
        return orderRepository.save(order);
	}
	
	public Boolean updateOrderAndStatus(Integer orderId, String status) {
	    Optional<Order> optionalOrder = orderRepository.findById(orderId);
	    if (optionalOrder.isPresent()) {
	        Order order = optionalOrder.get();
	        order.setOrderStatus(status);
	        orderRepository.save(order); 
	        return true;
	    } else {
	        throw new EntityNotFoundException("Order not found with ID: " + orderId);
	    }
	}
	
	public boolean cancelOrder(Integer orderId) {
		Optional<Order> order = orderRepository.findByOrderId(orderId);
		if(!order.isEmpty() && order.get().getOrderStatus().equals("PENDING")) {
			orderRepository.delete(order.get());
			return true;
		}else {
			return false;
		}
	}
	
}
