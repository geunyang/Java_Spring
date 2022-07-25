package com.callor.score.service.impl;

import java.util.List;

import com.callor.score.model.ScoreVO;
import com.callor.score.persistance.ScoreDao;
import com.callor.score.service.ScoreService;

public class ScoreServiceImplV1 implements ScoreService{
	
	private final ScoreDao scoreDao;
	
	public ScoreServiceImplV1(ScoreDao scoreDao) {
		this.scoreDao = scoreDao;
	}
	
	@Override
	public List<ScoreVO> findByStNum(String sc_stnum) {
		// TODO Auto-generated method stub
		return scoreDao.findByStNum(sc_stnum);
	}

	@Override
	public void create_score_table() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ScoreVO> selectAll() {
		// TODO Auto-generated method stub
		return scoreDao.selectAll();
	}

	@Override
	public ScoreVO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ScoreVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ScoreVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
