package com.callor.school.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.school.model.UserVO;
import com.callor.school.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/user")
public class UserControllerV2 {
	
	/*
	 * @Qualifier("userServiceV2")
	 * UserService 인터페이스를 상속받은 클래스가 2개 있다
	 * ImplV1 과 ImplV2 가 있는데
	 * 그 중에서 @Service("userServiceV2") 라고 명시된
	 * 클래스를 주입해달라
	 */
	private final UserService userService;

	public UserControllerV2(@Qualifier("userServiceV2") UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return null;
	}
	/*
	 * HttpSession
	 * 웹 애플리케이션은 한번 요청을 수행하고, 응답을 받으면
	 * 연결이 종료된다 이러한 것을 stateless(상태가없다) 라고 한다
	 * 사용자가 로그인에 성공하면 다른 페이지로 이동하였을때도 그 정보가 유지 되어야한다
	 * 매번 페이지 이동때 재 로그인을 수행한다면 상당히 불편할것이다
	 * 
	 * 웹 애플리케이션은 로그인한 사용자 정보를 어딘가에 보관하고 있다가
	 * 다른 페이지로 이동하였을때 그 정보를 참조할 수 있어야한다
	 * 웹 애플리케이션은 이러한 유지되어야 할 정보를
	 * 서버의 메모리에 보관해놓는다
	 * 
	 * Spring 에서는 이 정보를 httpSession  클래스를 사용하여 관리한다
	 * 로그인한 사용자의 정보(VO 데이터)를 HttpSession 에 변수로 저장을 해놓는다
	 * session.setAttribute("USER", loginUser); 명령을 사용하여
	 * USER 라는 변수에 loginUser 정보를 저장해 놓는다
	 * 이후 서버를 재시작, 종료 하기 전까지 USER 라는 변수에는
	 * loginUser 정보가 계속 담겨 있게 된다
	 * 
	 * 임의로 이 정보를 삭제하려면 
	 * session.removeAttribute() 메서드를 사용하여 USER 변수를 삭제해주어야한다
	 */

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserVO userVO, HttpSession session, Model model) {

		UserVO loginUser = userService.login(userVO);
		if(loginUser == null) {
			session.removeAttribute("USER");
		} else {
			session.setAttribute("USER", loginUser);
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {

		session.removeAttribute("USER");

		/*
		 * redirect: 로그아웃이 끝나면 web browser 의 주소창에 /user/login 을 입력하고 enter 를 눌러라
		 * 
		 */

		return "redirect:/";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {

		/*
		 * 이 method 를 요청하는 url 은 /user/join 이다 return null 을 실행하면 return user/join 을 실행한
		 * 것과 같다 views/user/join.jsp 를 rendering 하라는 의미
		 */
		return null;
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVO userVO) {
		log.debug("join");
		log.debug(userVO.toString());
		userService.join(userVO);
		/*
		 * return "문자열" => views/문자열.jsp 를 rendering 하라
		 * 
		 * return "redirect:/url" : pass, toss, redirect => 서버의 localhost:8080/url 을 다시
		 * request 하라 => web browse 주소창에 localhost:8080/url 을 입력하고 Enter 를 누르는 것과 같은 효과
		 */
		return "redirect:/user/login";
	}

	/*
	 * username 중복 검사를 하기 위하여 보통 다음과 같은 요청을 수행한다 /user/idcheck?usercame=callor
	 * 
	 * fetch(`${rootPath}/user/idcheck/${username.value}`); 만약 username 에 callor
	 * 입력했으면 /user/idcheck/callor 처럼 요청 URL 을 만들어서 요청을 수행하라
	 * 
	 */
	
	/*
	 * id 를 email 주소로 사용할 때 PathVarriable 로 받을 경우
	 * dot(.) 이후의 문자열을 잘라버리는 현상이 있다
	 * 이때는 정규식(rexp) 를 사용하여 dot(.) 이후 문자열을 포함하여
	 * 변수에 저장하도록 변수를 수정
	 * {username:.+} 형식으로 지정한다
	 */
	@ResponseBody
	@RequestMapping(value = "/idcheck/{username:.+}", method = RequestMethod.GET)
	public String idcheck(@PathVariable String username) {

		UserVO userVO = userService.findById(username);
		
		// if(username.equalsIgnoreCase(username))
		//if (userVO.getUsername().equalsIgnoreCase(username)) {
		//	return "FAIL";
		//} else {
		//	return "OK";
		//}
		
		if (userVO == null) {
			return "OK";
			
		} else {
			return "FAIL";
		}
	}
}
