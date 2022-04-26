package com.callor.school.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.school.domain.StudentVO;
import com.callor.school.service.StudentService;

/*
 * Controller level에 @RequestMapping을 설정하면
 * Controller 의 mapping 과 method의 mapping이 서로 연결되어 RequestMapping을 구성한다
 * localhost:8080/school/student : StudentController 의 mapping이 연동
 * localhost:8080/school/student/list : StudentController#list() 의 mapping 이 연결
 */
@RequestMapping(value="/student")
@Controller
public class StudentController {
	
	/*
	 * Dependency inject 중
	 * 생성자 injection
	 */
	private final StudentService stService;
	public StudentController(StudentService stService) {
		this.stService = stService;
	}
	// return type이 class일떄는(첫글자가대문자일때는) null 값 사용가능
	// 스프링 내부에서 null값을 위치값으로 변환

	/*
	 * return type 이 String type 인 method인 경우
	 * null 값을 return 하면 Request path와 같은 jsp 파일을 찾아서
	 * rendering 을 수행한다
	 * 단 @ResponseBody 설정이 없어야 한다 
	 * localhost:8080/school/student/list
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String list(Model model) {
		List<StudentVO> stList = stService.selectAll();
		model.addAttribute("STUDENTS", stList);		
		return "student/list_view";
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		// RequestMapping 이 /student/list 이기 때문에
		// return null을 수행하면
		// return "student/list"를 수행한것과 동일한 효과
		return null;
	}

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input() {
		return null;
	}

	@RequestMapping(value = "/detail_view", method = RequestMethod.GET)
	public String detail() {
		return "detail_view";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update() {
		return null;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete() {
		return null;
	}

}
