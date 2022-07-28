package com.callor.sec.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.callor.sec.model.AuthorityVO;
import com.callor.sec.model.UserVO;
import com.callor.sec.persistance.UserDao;

/*
 * spring security 에서 로그인 사용자 정보를
 * db 로부터 가져와 핸들링하는 클래스
 * security UserDetailsService 인터페이스를 상속받고
 * loadUserByUsername() method 를 정의한다
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private final UserDao userDao;
	
	public UserDetailsServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/*
	 * 로그인 한 사용자의 username 을 매개변수로 전달받아
	 * UserDao 를 통해 로그인한 사용자 정보를 DB 로 부터 가져온다
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO userVO = userDao.findById(username);
		
		// 로그인 한 사용자의 username 이 table 에 없으면
		if(userVO == null) {
			// exception 을 강제로 발생시키기
			// spring security 에게 exception 을 발생시켜 메시지 전달
			throw new UsernameNotFoundException(username + " : 회원가입 후 사용 가능");
		}
		// username 에 해당하는 ROLE 정보를 tbl_authorities table 에서 가져오기
		List<AuthorityVO> authoList = userDao.roleSelect(username);
		
		// security 의 grantList 생성
		List<GrantedAuthority> grantList = new ArrayList<>();
		
		// Role 정보 문자열을 grant type 으로 변경하여 List add
		for(AuthorityVO author : authoList) {
			grantList.add(new SimpleGrantedAuthority(author.getAuthority()));
		}
		
		// GrantList UserVO.authorities 에 저장
		userVO.setAuthorities(grantList);	
		return userVO;
	}
	

}
