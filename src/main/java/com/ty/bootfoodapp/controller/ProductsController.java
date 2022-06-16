package com.ty.bootfoodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.bootfoodapp.dto.Products;
import com.ty.bootfoodapp.service.ProductServices;

@RestController
public class ProductsController {

	@Autowired
	private ProductServices service;

	@PostMapping("/products")
	public Products saveItem(@RequestBody Products products) {
		return service.saveProduct(products);
	}

	@GetMapping("/products/{id}")
	public Products getProductById(@PathVariable int id) {
		return service.getProductById(id);
	}

	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}

	@GetMapping("/products")
	public List<Products> getAllItem() {
		return service.getAllProducts();
	}
	
	
}
