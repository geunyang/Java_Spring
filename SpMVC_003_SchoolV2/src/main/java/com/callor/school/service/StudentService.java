package com.callor.school.service;

import java.util.List;

import com.callor.school.domain.StudentVO;

public interface StudentService {
	/*
	 * CRUD method 의 prototype 선언
	 * C(Create,insert) : 새로운 데이터 추가
	 * R(Read, selectAll, findByStNum) :  데이터읽기
	 * U(Update, update) : 기존 데이터 변경
	 * D(Delete, delete) : 기존 데이터 중 삭제
	 */
	
	//CRUD(create,read,update,delete) : 데이터베이스 프로젝트에서 구현해야 할 4가지 기본요소
	//식별자 기본키 unique
	public List<StudentVO> selectAll();
	public StudentVO findByStNum(String stNum);
	public Integer insert(StudentVO stVO);
	public Integer update(StudentVO stVO);
	public Integer delete(StudentVO stNum);
	
	// id(절대유일한값)를 기본값으로 조회하는것 이외에는 List 사용해야함
	public List<StudentVO> findByStTel(String stTel);
	public List<StudentVO> findByStName(String stName);
	public List<StudentVO> findByStAddr(String stAddr);
	//인터페이스를 실제로 만드는것 구현클래스/구현체
	
	
	

}
