package com.callor.school.exec;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/*
 * 암호화, 복호화
 * 평문을 보통으로 알아보기 힘든 특별한 문자열로 변환하여
 * 통신을 통해서 전송하는 것을 암호화 라고 한다
 * 
 * 암호화된 특별한 문자열을 수신하여
 * 다시 원래의 평문으로 변환하는 것을 복호화 라고 한다
 * 
 * 인가 : 보안과 관련된 용어로 
 * 정상적인 ID 와 비밀번호를 사용하여 접속한 사용자에게
 * 데이터 접속을 허가하는 것
 * 
 * 암호화의 방법
 * 1. 쌍방향 암호화
 * 암호화와 복호화 기능을 같이 겸해서 사용하는 기법
 * 만약 비번을 암호화 한다면
 * 회원가입에서 입력된 비번을 암호화 하여 table 에 저장하고
 * 이후 로그인을 시도하면 table 에 저장된 비번을 
 * 다시 복호화 하여 로그인 정보와 비교하는것
 * 
 * 중간에 key 가 노출될 수 있고 복호화 하는 코드가 공개될 경우
 * 치명적인 보안 사고가 일어날 수 있다
 * 
 * 2. 단방향 암호화
 * 암호화 기능은 존재하지만 복호화 기능이 없는 기법
 * 회원 가입 시 입력된 비번을 암호화 하여 table 에 저장하고
 * 이후 로그인을 시도하면
 * 입력된 비번을 다시 암호화 하여 table 에 저장된 값과 비교한다
 * 복호화 기능이 존재하지 않아
 * 암호화 할 때 사용된 기법이 노출되지 않고
 * 다소 안전하게 작동 할 수 있다
 * 
 * 암호화 하는 방법과 비교 하는 방법을 통일해야 하는 단점이 존재한다
 */
public class CrypyEx1 {
	
	public static void main(String[] args) {
		
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		String planText = "Republic of Korea";
		
		/*
		 * Spring Security 프로젝트 에서 제공하는
		 * BCryptPasswordEncoder 를 사용하여
		 * 평문을 암호화 하기
		 * 코드 내부에서 자동으로 생성되는 salt key 에 의해
		 * 암호화를 할 때마다 다른 값들이 추출된다
		 */
		String encText = bCrypt.encode(planText);
		
		System.out.println(encText);
		System.out.println(encText.length());
		
	}

}