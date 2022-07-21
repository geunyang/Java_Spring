package com.callor.score.persistance;

import java.util.List;

import com.callor.score.model.ScoreVO;

public interface GenericDao<VO, PK> {
	public void create_score_table();
	public List<VO> selectAll();
	public VO findById(PK id);
	
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK id);
}
