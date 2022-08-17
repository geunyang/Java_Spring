package com.callor.food.service;

import java.util.List;

import com.callor.food.model.FoodItem;

public interface FoodService {
	
	// query 값을 받아서 
	public String queryString(String search);
	public List<FoodItem> getFoodItems(String queryString);

}
