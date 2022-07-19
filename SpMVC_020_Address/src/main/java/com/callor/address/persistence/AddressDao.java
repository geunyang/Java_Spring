package com.callor.address.persistence;

import java.util.List;

import com.callor.address.model.AddressVO;
import com.callor.address.model.SearchPage;

public interface AddressDao {
	
	public void create_addr_table();
	public List<AddressVO> selectAll();
	public AddressVO findById(Long a_seq);
	
	public List<AddressVO> searchAndPage(SearchPage searchPage);

	public int insert(AddressVO address);

	public int update(AddressVO address);
	public int delete(Long a_seq);
}
