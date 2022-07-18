package com.callor.hello.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.hello.model.AddressVO;
import com.callor.hello.service.HomeService;


@Controller
public class HomeController {
	/*
	 * HomeService 인터페이스를 사용하여 객체를 선언하고
	 * 생성자를 통하여 주입을 받기 위한 준비
	 * 
	 * Spring 인터페이스 주입 패턴
	 * 
	 * 클래스를 통하여 객체를 선언하지 않고
	 * 인터페이스를 통해서 객체를 선언해
	 * 결합도는 낮아지고 코드 응집도는 높아져
	 * 코드 확장시 여러가지로 유리한 패턴이 된다
	 */
	
	private final HomeService homeService;
	
	public HomeController(@Qualifier(QualifyConfig.HOME_SERVICE_V1) HomeService homeService) {
		this.homeService = homeService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		/*
		 * homeService 의 hello(), hello("홍길동"), goodBye(), goodBuy("이몽룡") 
		 * 메서드를 사용하는 HomeController 작성자는 아직 HomeServiceImpl 클래스의
		 * 메서드들이 구체적으로 내용이 완성이 되지 않았지만
		 * 전체적인 완성과 상관 없이 틀을 만들 수 있다 
		 */
		String hello = homeService.hello();
		hello = homeService.hello("홍길동");
		String goodBye = homeService.goodBye();
		goodBye = homeService.goodBye("이몽룡");
		
		return "home";
	}
	
	/*
	 * form 에서 보내온 데이터를 각각의 문자열형 변수에 받기
	 * 
	 * 데이터가 뒤섞이는 오류가 발생할 확률이 있음
	 */
//	public String home(String ad_name, String ad_tel, String ad_addr) {
//		homeService.insert(ad_name, ad_tel, ad_addr);
//		return "home";
//	}
	
	/*
	 * form 에서 보내온 데이터를 AddressVO 클래스 타입의 객체에 한번에 받기
	 * 
	 * 클래스 타입의 객체를 사용하여 method 간에 데이터를 보내면
	 * 단일 변수들을 나열하여 사용하는 것보다 신뢰할수 있으며 가독성이 높고 효율적인 코드가 된다
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(AddressVO address) {
		homeService.insert(address);
		return "home";
	}
	
	@RequestMapping(value = "/findName",method = RequestMethod.GET)	
	public String findByName(String ad_name, Model model) {
		AddressVO address = homeService.findByName(ad_name);
		model.addAttribute("ADDR",address);
		return "home";
	}
	
	
	
}
