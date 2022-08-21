package com.ballza.lunch.service;

import java.util.List;

import com.ballza.lunch.model.LunchRow;


public interface LunchService {
	
	public String queryString(String search);
	public List<LunchRow> getLunchRows(String queryString);

}
