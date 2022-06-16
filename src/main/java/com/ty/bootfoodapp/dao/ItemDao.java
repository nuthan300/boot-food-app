package com.ty.bootfoodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.bootfoodapp.repository.ItemRepository;
import com.ty.bootfoodapp.dto.Item;

@Repository
public class ItemDao {

	@Autowired
	private ItemRepository itemRepository;

	
	public Item saveItem(Item item) {
		return itemRepository.save(item);
	}

	public Item getItemById(int id) {
		
		Optional<Item> optional= itemRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public List<Item> getAllItem() {
		
		return itemRepository.findAll();
	}

	public Item updateItem(Item item) {

		return itemRepository.save(item);
	}

	public String deleteItem(int id) {
		
		Optional<Item> optional= itemRepository.findById(id);
		if(optional.isPresent()) {
			itemRepository.deleteById(id);
			return "Deleted Successfully";
		}
		return "Couldn't find the item";
	}
}
