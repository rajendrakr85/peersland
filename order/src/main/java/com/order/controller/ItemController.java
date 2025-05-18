package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.model.Item;
import com.order.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
		
	@GetMapping("/")
	public ResponseEntity<List<Item>> getItems(){
		return new ResponseEntity<List<Item>>(itemService.findAll(),HttpStatus.OK);
	}
	@GetMapping("/{itemid}")
	public ResponseEntity<Item> getItems(@PathVariable Integer itemid){
		Item item=itemService.findById(itemid).get();
		return new ResponseEntity<Item>(item,HttpStatus.OK);
	}
}
