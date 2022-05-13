package com.callor.school.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.school.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	/* 생성자 주입방식
	 * HomeController homeController
	 * = new HomeController(stService)
	 */
	private final StudentService stService;
	public HomeController(StudentService stService) {
		// stService = new StudentServiceImplV1();
		this.stService = stService;
	}

	/* 클래스에 @slf4j annotation 을 부착하므로서 다음 코드르 ㄹ
	 * lombok이 대신 만들어준다
	 */
//	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		log.trace("Hello");
		log.debug("Hello");
		log.info("Hello");
		log.warn("Hello");
		log.error("Hello");
		
		return "home";
	}
	
}
