package com.ballza.lunch.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ballza.lunch.config.LunchConfig;
import com.ballza.lunch.model.LunchRow;
import com.ballza.lunch.service.LunchService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LunchServiceImplV1 implements LunchService{
	
	@Override
	public String queryString(String search) {
		String queryString = LunchConfig.API_FULL_URL;
		String encodeParams = null;

		try {
			encodeParams = "?" + URLEncoder.encode("Key","UTF-8");
			encodeParams += "=" + LunchConfig.SERVICE_KEY;
			
			encodeParams += "&" + URLEncoder.encode("pIndex","UTF-8");
			encodeParams += "=1";
			
			encodeParams += "&" + URLEncoder.encode("pSize","UTF-8");
			encodeParams += "=10";
			
			encodeParams += "&" + URLEncoder.encode("Type","UTF-8");
			encodeParams += "=json";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		queryString += encodeParams;
		log.debug("쿼리문자열 {}",queryString);
		return queryString;
	}

	@Override
	public List<LunchRow> getLunch(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
