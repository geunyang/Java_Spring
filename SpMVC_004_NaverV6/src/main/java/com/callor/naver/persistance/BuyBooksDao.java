package com.callor.naver.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.callor.naver.model.BuyBooksVO;

public interface BuyBooksDao {

	public List<BuyBooksVO> selectAll();
	/*
	 * mapper 와 연동할 때 mapper 에게 전달하는 변수가 2개 이상일때는
	 * 각각의 변수에 @param 속성을 지정해주어야한다
	 * 그렇지 않으면 mapper 가 어떤 변수에 데이터가 담겨있는지 혼동하게 된다
	 */
	public BuyBooksVO findByIsbnAndUserName(@Param("isbn") String isbn, @Param("username") String username);
	public List<BuyBooksVO> findByIsbn(String isbn);
	public List<BuyBooksVO> findByUsername(String username);
	
	public int insert(BuyBooksVO vo);
}
