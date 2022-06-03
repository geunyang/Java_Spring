package com.callor.naver.persistance;

import java.util.List;

import com.callor.naver.model.NewsVO;

public interface NewsDao extends GenericDao<NewsVO, String>{
	/*
	 * GenericDao 를 상속 받음으로 해서 기본 CRUD 5개의 method는 
	 * 만들지 않아도 된다
	 */
//	public List<NewsVO> selectAll();
//	public NewsVO findByID(String id);
//	public int insert(NewsVO vo);
//	public int update(NewsVO vo);
//	public int delete(String id);
	
	// 필요한 method 추가
	// 기본 제공 method 와 겹치면 이전 데이터 안보이게됨
	// 중복되지 않도록 주의
	
	// 기본 CRUD 외에 필요한 method가 있을 경우 별도로 얼마든지 추가 가능
	public List<NewsVO> findByTitle(String title);
	
}
