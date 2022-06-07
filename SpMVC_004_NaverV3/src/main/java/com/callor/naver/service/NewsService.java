package com.callor.naver.service;

import com.callor.naver.persistance.NewsDao;

/*
 * Service 의 기능도 기본적으로 dao 와 같이 5가지 CRUD 가 필요하고
 * 경우에 따라 별도의 method 가 추가될 수 있다
 * 
 * Service 도 GenericDao 를 상속받아 사용할 수 있다
 * 
 * 하지만 NewsDao에 새롭게 추가한 method 가 있는데
 * GenericDao 를 상속 받으면 추가된 method 를 다시 작성해야한다
 * 이럴때는 GenericDao 대신 NewsDao 를 상속 받는다
 */
public interface NewsService extends NewsDao{
	
}
