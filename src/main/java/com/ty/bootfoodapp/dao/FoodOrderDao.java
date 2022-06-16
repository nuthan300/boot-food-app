package com.ty.bootfoodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.bootfoodapp.dto.FoodOrder;
import com.ty.bootfoodapp.repository.FoodOrderRepository;

@Repository
public class FoodOrderDao {

	@Autowired
	private FoodOrderRepository foodOrderRepository;

	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return foodOrderRepository.save(foodOrder);
	}

	public FoodOrder getFoodOrderById(int id) {
		Optional<FoodOrder> optional= foodOrderRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public String deleteFoodOrderById(int id) {
		Optional<FoodOrder> optional= foodOrderRepository.findById(id);
		if(optional.isPresent()) {
			foodOrderRepository.deleteById(id);
			return "Deleted";
		}
		return "Couldn't find Order";
	}

	public FoodOrder updateFoodOrder(FoodOrder foodOrder) {
		return foodOrderRepository.save(foodOrder);
	}

	public List<FoodOrder> getAllFoodOrder(){
		return foodOrderRepository.findAll();
	}
//	public FoodOrder getFoodOrderByPhone(long phone) {
//		String sql = "SELECT f FROM FoodOrder f WHERE phone=?1";
//		Query query = entityManager.createQuery(sql);
//		query.setParameter(1, phone);
//		return (FoodOrder)query.getSingleResult();
//	}
//
//	public FoodOrder getFoodOrdersByName(String name) {
//		Query query = entityManager.createQuery("SELECT f FROM FoodOrder f WHERE f.name=?1");
//		query.setParameter(1, name);
//		return (FoodOrder)query.getSingleResult();
//	}

}
