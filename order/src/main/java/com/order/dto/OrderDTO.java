package com.order.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.order.model.OrderItem;

public record OrderDTO(Integer orderId,List<OrderItem> items,String orderStatus,Double amountPaid,Double total,
		String paymentMode,LocalDateTime createdTime,LocalDateTime modifiedTim) {

}
