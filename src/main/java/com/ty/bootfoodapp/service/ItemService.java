package com.ty.bootfoodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.bootfoodapp.dao.ItemDao;
import com.ty.bootfoodapp.dto.Item;

@Service
public class ItemService {

	@Autowired
	ItemDao dao;

	public Item saveItem(Item item) {
		return dao.saveItem(item);
	}

	public Item getItemById(int id) {
		return dao.getItemById(id);
	}

	public List<Item> getAllItem() {
		return dao.getAllItem();
	}

	public Item updateItem(Item item, int id) {
		return dao.updateItem(item);
	}

	public String deleteItem(int id) {
		return dao.deleteItem(id);
	}
}
