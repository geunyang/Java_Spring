package com.callor.naver.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.model.UserVO;
import com.callor.naver.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	// UserService interface 를 상속받은 어떤 클래스를 주입 받겠다는 선언
	//setter 주입
	@Autowired
	@Qualifier(QualifierConfig.SERVICE.USER_V2)
	private UserService userService;
	
	@RequestMapping(value = "/join", method=RequestMethod.GET)
	public String join(Model model) {
		
		model.addAttribute("LAYOUT","JOIN");
		return "home";
	}
	
	@RequestMapping(value = "/join",method=RequestMethod.POST)
	public String join(UserVO userVO) {
		
		log.debug("회원정보 : {}", userVO.toString());
		
		userService.join(userVO);
		
		return "redirect:/user/login";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String login(String error, Model model) {
		
		model.addAttribute("error",error);
		model.addAttribute("LAYOUT","LOGIN");
		return "home";
	}
	
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public String login(UserVO userVo, Model model, HttpSession session) {
		
		UserVO loginUser = userService.findById(userVo.getUsername());
		if(loginUser == null) {
			model.addAttribute("error","USERNAME_FAIL");
			return "redirect:/user/login";
		}
		loginUser = userService.login(userVo);
		if(loginUser == null) {
			model.addAttribute("error","PASSWORD_FAIL");
			return "redirect:/user/login";
		}
		
		log.debug(loginUser.toString());
		session.setAttribute("USER", loginUser);
		return "redirect:/";
		
		
	}
	
	@RequestMapping(value = "/logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("USER");
		return "redirect:/";
	}
	
	/*
	 * 매개변수로 설정한 HttpSession 
	 * Controller 의 각 method 는 Spring 으로부터 HttpSession 객체를
	 * 주입 받을 수 있다
	 * 
	 * HttpSession 객체에는 client 와 server 간에 상태(status)를 유지하는
	 * 정보를 담을 수 있다
	 * 
	 * 여기에 담긴 데이터는 서버가 Run 하는 동안, 일정 조건을 만족하는 동안
	 * Session 제거하지 않는 한 계속 메모리에 값이 남아있다
	 * 
	 * 큰 데이터를 HttpSession 에 담는것은 좋지 않다
	 * 최소한으로 status 를 유지할 수 있는 데이터만 담는것이 좋다
	 * 필요가 없어지면 반드시 remove 해주는것이 좋다
	 * 
	 * 프로젝트의 어떤 method 에서든지 한번 담은 Session 정보는
	 * 전체 프로젝트의 Controller method 에서 값을 참조할 수 있다
	 */
	@RequestMapping(value = "/mypage",method=RequestMethod.GET)
	public String mypage(Model model,HttpSession session) {
		UserVO loginUser = (UserVO) session.getAttribute("USER");
		if(loginUser == null) {
			model.addAttribute("error","LOGIN_NEED");
			return "redirect:/user/login";
		}
		model.addAttribute("LAYOUT","MYPAGE");
		return "home";
	}
	
}
