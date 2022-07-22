package com.callor.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.score.model.StudentVO;
import com.callor.score.service.StudentService;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
	
	private final StudentService stdService;
	
	public StudentController(StudentService stdService) {
		this.stdService = stdService;
	}
	
	// json type 으로 보내기위해 @ResponseBody
	@ResponseBody
	@RequestMapping(value = {"/",""}, method=RequestMethod.GET)
	// 학생 리스트를 return 하기 위해 return type List<StudentVO>
	public List<StudentVO> home() {
		List<StudentVO> stdList = stdService.selectAll();
		return stdList;
	}

	

}
