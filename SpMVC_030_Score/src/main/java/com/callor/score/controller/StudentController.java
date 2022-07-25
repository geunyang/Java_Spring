package com.callor.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping(value = {"/",""}, method=RequestMethod.GET)
	public String home(Model model) {
		List<StudentVO> stdList = stdService.selectAll();
		model.addAttribute("STUDENTS", stdList);
		return "student/list";	
	}
	
	@RequestMapping(value = "/detail", method=RequestMethod.GET)
	public String detail(@RequestParam("st_num") String st_num, Model model) {
		StudentVO student = stdService.findById(st_num);
		model.addAttribute("STUDENT", student);
		
		return "student/detail";
	}
	
	@RequestMapping(value = "/update", method=RequestMethod.GET)
	public String update(@RequestParam("st_num") String st_num, Model model) {
		StudentVO student = stdService.findById(st_num);
		model.addAttribute("STUDENT", student);
		return null;
	}
	
	@RequestMapping(value = "/update", method=RequestMethod.POST)
	public String update(StudentVO studentVO, Model model) {
		stdService.update(studentVO);
		return "redirect:/student";
	}
	
	// json type 으로 보내기위해 @ResponseBody
	@ResponseBody
	@RequestMapping(value = "/json", method=RequestMethod.GET)
	// 학생 리스트를 return 하기 위해 return type List<StudentVO>
	public List<StudentVO> home() {
		List<StudentVO> stdList = stdService.selectAll();
		return stdList;
	}

	

}
