package com.callor.naver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
 * context.xml 대신 클래스를 사용해 bean 설정
 * spring-security-core 필요
 */
@Configuration
public class PasswordConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder(4);
		return encoder;
	}

}
