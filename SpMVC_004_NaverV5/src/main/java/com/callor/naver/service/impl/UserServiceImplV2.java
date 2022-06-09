package com.callor.naver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.model.UserVO;
import com.callor.naver.persistance.UserDao;
import com.callor.naver.service.UserService;

import lombok.extern.slf4j.Slf4j;

/*
 * No qualifying bean of type..  오류가 발생하는 경우
 * UserService 인터페이스를 사용하여 bean 을 주입받겠다고  Controller 에 선언함
 * 1. 생성자를 통해 주입받기
 * 2. Autowired 를 사용하여 setter 를 통해서 주입받기
 * 
 * 어디에도 해당하는 bean 을 생성, 선언한 곳이 없을때 발생하는 오류
 */
@Slf4j
@Service(QualifierConfig.SERVICE.USER_V2)
public class UserServiceImplV2 extends UserServiceImplV1{
	
	// bean으로 만들어 @Autowired로 바로 연결가능
	@Autowired
	protected PasswordEncoder passwordEncoder;
	
	@Override
	public int join(UserVO userVO) {
		
		List<UserVO> users = userDao.selectAll();
		if(users == null || users.size() < 1) {
			userVO.setRole("ADMIN");
		} else {
			userVO.setRole("GUEST");
		}
		
		//password 를 암호화
		String planPassword = userVO.getPassword();
		String encPassword = passwordEncoder.encode(planPassword);
		
		//암호화된 password 를 다시 VO에 setting
		userVO.setPassword(encPassword);;
		
		//user 정보를 insert
		userDao.insert(userVO);
		
		return 0;
		
	}
	
	@Override
	public UserVO login(UserVO userVO) {
		
		UserVO loginUser = userDao.findById(userVO.getUsername());
		String encPassword = loginUser.getPassword();
		String planPassword = userVO.getPassword();
		// 평문, 암호화된 문자열
		if(passwordEncoder.matches(planPassword,encPassword)) {
			return loginUser;		
		}
		return null;
	}


}
