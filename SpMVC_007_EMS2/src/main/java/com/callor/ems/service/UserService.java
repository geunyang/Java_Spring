package com.callor.ems.service;

import com.callor.ems.model.UserVO;
import com.callor.ems.persistance.UserDao;

// generic 과 userdao 를 한꺼번에 상속받겠다
public interface UserService extends UserDao {
	
	public int join(UserVO userVO);
	public int join_next(UserVO userVO);

}
