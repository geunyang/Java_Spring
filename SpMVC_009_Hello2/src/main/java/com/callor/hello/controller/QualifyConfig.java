package com.callor.hello.controller;

public class QualifyConfig {
	
	/* 
	 * 문자열로 구분하는 코드가 필요할때 오타로 인해 찾기 어려운 RuntimeException 오류가 발생하기 쉽기 때문에
	 * 문자열 자체를 클래스로 선언을 해두고 편하게 사용
	 * 정적(static) 패턴
	 */
	public final static String HOME_SERVICE_V1 = "homeServiceV1";
	public final static String HOME_SERVICE_V2 = "homeServiceV2";
	public final static String HOME_SERVICE_V3 = "homeServiceV3";
	

}