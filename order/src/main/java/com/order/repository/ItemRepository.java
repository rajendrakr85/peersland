package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
	Item findByItemName(String name);
	
}
