package com.ty.bootfoodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.bootfoodapp.dto.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer>{

}
