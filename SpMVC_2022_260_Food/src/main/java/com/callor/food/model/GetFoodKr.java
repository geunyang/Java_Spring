package com.callor.food.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class GetFoodKr {
	
	// json 에 넘어오는 실제 데이터이름
	@JsonProperty("header")
	public Header header;
	
	@JsonProperty("item")
	public List<FoodItem> item;
	
	@ToString
	public class Header {

			public String code;
			public String message;
	}

}
