package com.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.model.Item;
import com.order.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<Item> findAll(){
		return itemRepository.findAll();
	}
	
	public Optional<Item> findById(Integer itemid){
		return itemRepository.findById(itemid);
	}
	
	public Item findByItemName(String name) {
		return itemRepository.findByItemName(name);
	}
	
}
