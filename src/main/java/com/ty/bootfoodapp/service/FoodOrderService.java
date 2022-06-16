package com.ty.bootfoodapp.service;

import static com.ty.bootfoodapp.util.Tax.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.bootfoodapp.dao.FoodOrderDao;
import com.ty.bootfoodapp.dto.FoodOrder;
import com.ty.bootfoodapp.dto.Item;

@Service
public class FoodOrderService {

	@Autowired
	FoodOrderDao dao;

	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {

		double cost = 0;
		
		for(Item item : foodOrder.getItems()) {
			int q = item.getQuantity();
			double mrp = item.getMrp();
			double res = q * mrp;
			item.setCost(res);
			cost = cost + res;
		}
		foodOrder.setTotal(cost);
		return dao.saveFoodOrder(foodOrder);
	}

	public FoodOrder getFoodOrderById(int id) {
		return dao.getFoodOrderById(id);
	}

	public String deleteFoodOrder(int id) {
		return dao.deleteFoodOrderById(id);
	}

	public FoodOrder updateFoodOrder(FoodOrder foodOrder) {

		int total = 0;
		for (Item item1 : foodOrder.getItems()) {
			item1.setFoodOrder(foodOrder);
			total += item1.getCost();
		}
		foodOrder.setTotal(total);
		return dao.updateFoodOrder(foodOrder);
	}
	
	public List<FoodOrder> getAllFoodOrder(){
		return dao.getAllFoodOrder();
	}

//	public FoodOrder getFoodOrderByPhone(long phone) {
//		return dao.getFoodOrderByPhone(phone);
//	}
//
//	public FoodOrder getFoodOrdersByName(String name) {
//
//		return dao.getFoodOrdersByName(name);
//	}

	public double billGenerated(double amount) {
		double gst = amount + getCgst(amount) + getSgst(amount);
		return gst;
	}

	public double getCgst(double amount) {
		return amount *(CGST/100);
	}

	public double getSgst(double amount) {
		return amount * (SGST/100);
	}
}
