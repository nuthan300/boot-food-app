package com.ty.bootfoodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.bootfoodapp.dao.ProductDao;
import com.ty.bootfoodapp.dto.Products;

@Service
public class ProductServices {

	@Autowired
	private ProductDao dao;

	public Products saveProduct(Products products) {

		return dao.saveProduct(products);
	}

	public String deleteProduct(int id) {

		return dao.deleteProduct(id);
	}

	public Products updateProduct(Products products) {

		return dao.updateProduct(products);
	}
	
	public List<Products> getAllProducts(){
		return dao.getAllProducts();
	}
	
	public Products getProductById(int id) {
		return dao.getProductById(id);
	}
}