package com.callor.ems.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.ems.model.EmsVO;
import com.callor.ems.model.UserVO;
import com.callor.ems.service.QualifyConfig;
import com.callor.ems.service.SendMailService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	@Qualifier(QualifyConfig.SERVICE.MAIL_V2)
	private SendMailService xMail;
	
	@RequestMapping(value = "/join", method=RequestMethod.GET)
	public String join(@ModelAttribute("userVO") UserVO userVO, Model model) {
		model.addAttribute("userVO", userVO);
		return null;
	}
	
	@RequestMapping(value = "/join", method=RequestMethod.POST)
	public String join(@Valid UserVO userVO, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		
		EmsVO emsVO = EmsVO.builder()
				.e_to_email(userVO.getEmail())
				.e_to_name("새로운 회원")
				.build();
		xMail.sendMail(emsVO);
		return "redirect:user/join_next";
	}
	@ModelAttribute("userVO")
	private UserVO userVO() {
		return new UserVO();
		
	}
	
}
