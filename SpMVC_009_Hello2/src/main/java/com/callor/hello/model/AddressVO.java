package com.callor.hello.model;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 * 자바에서 데이터를 담아 method 와 method 사이에 전달하기 위한 도구
 * model 클래스, domain 클래스, VO 클래스, DTO 클래스
 * 
 * method 에 전달해야할 매개변수(parameter, argument) 가 2개 초과시
 * 개별 변수로 선언하지 않고 VO(DTO) 클래스를 선언하여 사용하는것이
 * 가독성이나 편리성에서 유리하다
 * 
 * VO 클래스는 데이터 구조가 여러가지 칼럼으로 구성되어
 * 실질적인 데이터 객체를 상징하는 중요한 개념
 * 
 * VO 클래스는 변수를 모두 private 로 선언하고
 * getter, setter method 를 통해서 데이터를 읽거나 저장하는 패턴을 사용한다
 * 이는 객체지향에서 캡슐화, 정보은닉에 해당한다
 * 
 * VO 클래스를 디자인 할때는 꼭 필요한 항목(속성)만 포함하여 설계하는것이 좋다
 * 
 * DB 와 연동하고 JSP 등 view 와 연결할 때 단일 단어로 되어있는 변수를 사용하는 경우
 * 잘못된 데이터가 담기는 등의 오류가 발생할 가능성이 있어
 * snake case 변수명을 선언하는 것이 권장된다
 */

@Getter
@Service
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressVO {
	
	private String ad_name;
	private String ad_tel;
	private String ad_addr;	

}
