package com.order.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.dto.OrderDTO;
import com.order.exception.ResourceNotFoundException;
import com.order.model.Order;
import com.order.model.OrderItem;
import com.order.repository.OrderRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<OrderDTO> findOrderByStatus(String status) {
		List<OrderDTO> listOrder=this.toDTO(orderRepository.findByOrderStatus(status));
		return listOrder;
	}
	
	public Optional<Order> paidPayment(Integer orderid, Double amount) {
		Optional<Order>paymentOrder= orderRepository.findByOrderId(orderid);
		if(paymentOrder.isPresent()) {
			Double currentAmount=paymentOrder.get().getAmountPaid()+amount;
			paymentOrder.get().setAmountPaid(currentAmount);
		}
		this.saveOrder(paymentOrder.get());
		return paymentOrder;
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
        Double total=0.0;
        for (OrderItem item : order.getItems()) {
            item.setOrder(order); // 👈 Set the back-reference
            total=total+item.getItem().getPrice();
        }
        order.setTotal(total);
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
	
	private List<OrderDTO> toDTO(List<Order> orders ){
		return orders.stream().map(order->{
			return new OrderDTO(order.getOrderId(),order.getItems(),order.getOrderStatus(),order.getAmountPaid(),
					order.getTotal(),order.getPaymentMode(),order.getCreatedTime(),order.getModifiedTime());
		}).collect(Collectors.toList());
	}
}
