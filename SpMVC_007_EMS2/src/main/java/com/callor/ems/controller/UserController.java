package com.callor.ems.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.intercept.RunAsUserToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.callor.ems.model.EmsVO;
import com.callor.ems.model.UserVO;
import com.callor.ems.service.QualifyConfig;
import com.callor.ems.service.SendMailService;
import com.callor.ems.service.UserService;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

/*
 * userController 에서
 * @SessionAttributes("userVO")
 * 라고 이름붙은 ?? 가 있으면
 * 데이터가 유지된다
 * 직접적으로 jsp에서 쓸수 없지만
 * spring form tag 와 연동하면
 * session에 user 정보를 담아둔 것과 똑같은 효과
 * 여러 화면에 걸쳐있는 데이터를 하나로 모아서 쓸 수 있다
 * VO 데이터를 지울때까지 유지
 */
@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	@Qualifier(QualifyConfig.SERVICE.MAIL_V2)
	private SendMailService xMail;
	
	@Autowired
	private UserService userService;
	

	@RequestMapping(value = "/join", method=RequestMethod.GET)
	public String join(@ModelAttribute("userVO") UserVO userVO, Model model) {
		

		model.addAttribute("userVO", userVO);
		return null;
	}
	
	@RequestMapping(value = "/join", method=RequestMethod.POST)
	public String join(@ModelAttribute("userVO") UserVO userVO) {
		
		// join 에 userVO를 전달
		userService.join(userVO);
		return "user/join_email";
	}
	
	/*
	 * pathva.. 방식은 패턴 일치하게 요청해야 실행됨
	 * ? 이후는 없어도 됨
	 */
	// PathVarriable 방식의 데이터 전송
	// .../user/aa/email_ok_/bb
	// .../user/1/email_ok_/33
	// .../user/2/email_ok_/55
	// .../user/가/email_ok_/na
	// .../user/1234/email_ok_/ga
	// 같이 패턴이 일치하는요청을 모두 수용하는 method
	
	@RequestMapping(value = "/email_ok/")
	public String email_ok() {
		return "user/join_email";
	}
	@RequestMapping(value = "/email_ok/{email:.*}")
	public String email_ok(@PathVariable("email") String email, @ModelAttribute("userVO") UserVO userVO) {
		
		UserVO emailUserVO = userService.findById(email);
		if(emailUserVO == null) {
			return "redirect:/user/join?error=error";
		}
		
		userVO.setUsername(null);
		userVO.setEmail(emailUserVO.getEmail());
		userVO.setPassword(null);
		
		log.debug(email);
		return "user/join_next";
	}

	@ModelAttribute("userVO")
	private UserVO userVO() {
		return new UserVO();
		
	}
	
}
