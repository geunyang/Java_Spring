package com.ballza.lunch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ballza.lunch.service.LunchService;

@Controller
@RequestMapping(value = "/lunch")
public class LunchController {
	
	private final LunchService lunchService;

	public LunchController(LunchService lunchService) {
		this.lunchService = lunchService;
	}
	
	@RequestMapping(value = {"/",""}, method=RequestMethod.GET)
	public String home() {
		String queryString = lunchService.queryString(null);
		lunchService.getl
		
	}
	
	
	
	

}
