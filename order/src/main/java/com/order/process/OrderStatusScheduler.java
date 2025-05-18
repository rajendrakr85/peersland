package com.order.process;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.order.model.Order;
import com.order.repository.OrderRepository;


@EnableScheduling
@Component
public class OrderStatusScheduler {

    @Autowired
    private OrderRepository orderRepo;

    @Scheduled(fixedRate = 100000) // every 5 minutes
    public void updatePendingOrders() {
        List<Order> pendingOrders = orderRepo.findByOrderStatus("PENDING");
        for (Order order : pendingOrders) {
            order.setOrderStatus("PROCESSING");
            order.setModifiedTime(LocalDateTime.now());
        }
        orderRepo.saveAll(pendingOrders);
    }
}