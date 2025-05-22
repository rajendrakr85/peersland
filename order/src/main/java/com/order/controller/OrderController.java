package com.order.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.order.model.Order;
import com.order.service.OrderService;


@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@GetMapping("/")
	public ResponseEntity<List<Order>> getAllOrders(@RequestParam(defaultValue = "PENDING") String orderStatus) {
		List<Order>orders=orderService.findOrderByStatus(orderStatus);
		if(orders.size()>0) {
			return new ResponseEntity<List<Order>>(orders,HttpStatus.OK);
		}{
			return new ResponseEntity<List<Order>>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/{orderId}")
	public ResponseEntity<Order> getOrders(@PathVariable Integer orderId) {
		Optional<Order> order=orderService.getOrder(orderId);
		if(!order.isEmpty()) {
			return new ResponseEntity<Order>(order.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PatchMapping("/{orderId}/{amount}")
	public ResponseEntity<Order> getPartialPayment(@PathVariable Integer orderId,@PathVariable Double amount) {
		Optional<Order> order=orderService.paidPayment(orderId, amount);
		if(!order.isEmpty()) {
			return new ResponseEntity<Order>(order.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/")
	public ResponseEntity<Order> createOrders(@RequestBody Order order) {
		Order savedOrder=orderService.saveOrder(order);
		if(!Optional.of(savedOrder.getOrderId()).isEmpty()) {
			return new ResponseEntity<Order>(savedOrder,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
		Order savedOrder=orderService.saveOrder(order);
		if(!Optional.of(savedOrder.getOrderId()).isEmpty()) {
			return new ResponseEntity<Order>(savedOrder,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/cancel/{orderId}")
	public Boolean cancleOrder(@RequestParam Integer orderId) {
		return orderService.cancelOrder(orderId) ;
		
	}
	
	
	
	
}
