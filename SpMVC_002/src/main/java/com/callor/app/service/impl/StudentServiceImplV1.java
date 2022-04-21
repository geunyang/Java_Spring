package com.callor.app.service.impl;

import org.springframework.stereotype.Service;

import com.callor.app.domain.StudentVO;
import com.callor.app.service.StudentService;

@Service
public class StudentServiceImplV1 implements StudentService {
	
	//override 1.7 이상에서는 안써도 됨
	// to do 이용해서 빠르게 이동
	// TODO 학생데이터를 추가하기
	@Override
	public int insert(StudentVO studentVO) {
		
		return 0;
	}
	// TODO 전체 데이터 가져오기
	@Override
	public StudentVO[] selectAll() {

		return null;
	}
	// TODO 학생 데이터 id로 조회하기
	@Override
	public StudentVO findById(String stNum) {

		return null;
	}
}
