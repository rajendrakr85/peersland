package com.order.dto;

import com.order.model.Item;
import com.order.model.Order;

public record OrderItemDTO(Integer id,Order order,Item item,Integer quantity) {

}
