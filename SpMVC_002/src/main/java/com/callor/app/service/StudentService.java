package com.callor.app.service;

import com.callor.app.domain.StudentVO;

public interface StudentService {
	// 학생데이터를추가하기
	public int insert(StudentVO studentVO);
	// 전체 리스트 가져오기
	public StudentVO[] selectAll();
	// 특정한 한개의 데이터만 가져오기
	public StudentVO findById(String stNum);

}
