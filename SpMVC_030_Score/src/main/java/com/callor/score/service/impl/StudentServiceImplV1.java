package com.callor.score.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.score.model.StudentVO;
import com.callor.score.persistance.StudentDao;
import com.callor.score.service.StudentService;

@Service
public class StudentServiceImplV1 implements StudentService{
	
	private final StudentDao studentDao;
	
	public StudentServiceImplV1(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public void create_score_table() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StudentVO> selectAll() {
		return studentDao.selectAll();
	}

	@Override
	public StudentVO findById(String id) {
		// TODO Auto-generated method stub
		return studentDao.findById(id);
	}

	@Override
	public int insert(StudentVO vo) {
		// TODO Auto-generated method stub
		return studentDao.insert(vo);
	}

	@Override
	public int update(StudentVO vo) {
		// TODO Auto-generated method stub
		return studentDao.update(vo);
	}
	
	@Override
	public int delete(String id) {
		return studentDao.delete(id);
	}

}
