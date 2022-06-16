package com.ty.bootfoodapp.dao;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.bootfoodapp.dto.Products;
import com.ty.bootfoodapp.repository.ProductsRepository;

@Repository
public class ProductDao {

	@Autowired
	private ProductsRepository productsRepository;

	public Products saveProduct(Products products) {
		
		return productsRepository.save(products);
	}

	public String deleteProduct(int id) {
		Optional<Products> optional= productsRepository.findById(id);
		if(optional.isPresent()) {
			productsRepository.deleteById(id);
			return "Deleted";
		}
		return "Couldn't find Order";
	}

	public Products updateProduct(Products products) {
		return productsRepository.save(products);
	}
	
	public List<Products> getAllProducts(){
		return productsRepository.findAll();
	}
	
	public Products getProductById(int id) {
		Optional<Products> optional= productsRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
}
