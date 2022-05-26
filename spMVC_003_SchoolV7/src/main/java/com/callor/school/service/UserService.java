package com.callor.school.service;

import com.callor.school.model.UserVO;
import com.callor.school.persistance.GenericDao;

public interface UserService extends GenericDao<UserVO, String> {
	
	public UserVO login(UserVO userVO);
	public UserVO join(UserVO userVO);
	

}
