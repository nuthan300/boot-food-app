package com.ty.bootfoodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.bootfoodapp.dto.Item;
import com.ty.bootfoodapp.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService service;

	@PostMapping("/items")
	public Item saveItem(@RequestBody Item item) {
		return service.saveItem(item);
	}

	@GetMapping("/items/{id}")
	public Item getUserById(@PathVariable int id) {
		return service.getItemById(id);
	}

	@DeleteMapping("/items/{id}")
	public String deleteItem(@PathVariable int id) {
		return service.deleteItem(id);
	}

	@GetMapping("/items")
	public List<Item> getAllItem() {
		return service.getAllItem();
	}
}
