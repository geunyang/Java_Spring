package com.callor.sec.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.callor.sec.model.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("authenticationProvider")
public class AuthorProviderImpl implements AuthenticationProvider{
	
	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService userDeService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		/*
		 * Authentication
		 * 로그인한 사용자의 정보를 전달받을 객체
		 * username password 를 통한 login 절차
		 * principal credentials 방식의 로그인
		 */
		// id password 추출
		String username = authentication.getPrincipal().toString();
		String password = authentication.getCredentials().toString();
		
		// 사용자 정보 전달
		UserVO user = (UserVO) userDeService.loadUserByUsername(username);
		
		// 사용자의 비밀번호 검사등을 실행하여 정상 접근인지 확인
		
		/* 최초 회원가입시 절차가 완료 전 로그인에 성공해도 다른 기능을 사용할수 없도록
		 * 회원 데이터의 isEnabled 값을 false 로 설정하고
		 * 이후 다른 절차를 통하여 정상 사용자 확인을 거쳐 isEnabled 칼럼을 true 로 바꿔 사용 인가 절차 진행 
		 */
		// 로그인시도
		if(user.isEnabled() == false) {
			throw new BadCredentialsException(username + "Not Recognize");
		}
		
		log.debug("인증클래스");
		
		/*	인증이 완료되면 사용자 정보를 security.Context 에 tokken 과 함께 담아
		 *  로그인 성공을 프로젝트에 전달하기 위해 객체로 구현
		 *  user: 로그인 한 사용자 정보
		 *  user.getAuthorities(): 로그인한 사용자의 권한 리스트
		 */
		// 정상적 사용자일 경우 security 에 요청(저장됨)
		Authentication authorOk = new UsernamePasswordAuthenticationToken(user, null,user.getAuthorities());
		return authorOk;
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
