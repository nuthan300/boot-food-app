package com.ty.bootfoodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.bootfoodapp.dto.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
