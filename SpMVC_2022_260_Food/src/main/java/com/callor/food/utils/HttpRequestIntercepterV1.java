package com.callor.food.utils;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class HttpRequestIntercepterV1 implements ClientHttpRequestInterceptor {

	// 가로채기를 수행해줄 함수method
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		
		// 수신받은 데이터
		ClientHttpResponse response = execution.execute(request, body);
		// 수신된 부분의 header 를 꺼내서 강제로 json 으로 변환
		response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
		// 임의로 변경한 response 를 return
		return response;
	}
	
	
}
