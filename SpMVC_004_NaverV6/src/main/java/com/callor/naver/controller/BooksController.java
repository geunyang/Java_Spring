package com.callor.naver.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.naver.model.BookVO;
import com.callor.naver.model.UserVO;
import com.callor.naver.service.BookService;

import lombok.extern.slf4j.Slf4j;

/*
 * 프로젝트의 요청에 대하여 소수의 Controller를 만들고 처리 가능
 * 하지만 프로젝트 규모가 커지면 코드 관리가 어려워지고
 * 결국에는 프로젝트를 Refactoring 해야 됨
 */

@Slf4j
@RequestMapping(value = "/books")

public class BooksController {
	private final BookService bookService;
	// 이쪽 뭐 놓친것같음
	public BooksController(BookService bookService) {
		this.bookService = bookService;

	}

	/*
	 * return 문자열 형식은
	 * 명시적으로 어떤 jsp 파일을 rendering 할 것인지 알려주는것
	 * 현재 method를 요청한 URL에 대하여  jsp를 명시적 전달
	 * 
	 * return null 형식은
	 * 암시적으로 어떤 jsp 파일을 rendering 할 것인지 알려주는 것
	 * 현재 method를 요청한 URL이 명시적으로 명확 할 경우
	 * null을 return 하면 Spring에서 자체적으로 폴더 / 파일 형식으로 구성
	 */

	@RequestMapping(value = { "/", "" })
	public String home() {
		return "redirect:/books/list";
	}

	@RequestMapping(value = "/list")
	public String list(Model model) {
		List<BookVO> bookList = bookService.selectAll();

		// bookList에 담긴 데이터를 BOOKS 이름으로 변수에 담아 jsp 파일로 보내기
		model.addAttribute("BOOKS", bookList);
		model.addAttribute("LAYOUT", "BOOK-LIST");
		return "home";
	}

	/*
	 * RequestMethod가 없는 Mapping은
	 * get 요청이나 POST 요청을 모두 처리하는 method가 되버린다
	 * 
	 * method = RequestMethod.GET로 지정하면 a tag link를 눌렀을 때의 요청만 처리하도록 역할 제한
	 */

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model, HttpSession session) {
		model.addAttribute("LAYOUT", "BOOK-INPUT");
		
		// 형변환 왜?
		UserVO userVO = (UserVO) session.getAttribute("USER");
		if(userVO == null) {
			model.addAttribute("error","LOGIN_NEED");
			return "redirect:/user/login";
		}
		
		return "home";
	}

	/*
	 * method = POST가 부착된 form으로 감싼 데이터들이 전송되었을때
	 * 요청을 받아 처리 할 method 
	 */

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(BookVO bookVO) {
		log.debug("도서정보 : " + bookVO.toString());
		int ret = bookService.insert(bookVO);
		// 주석누락
		
		// insert 처리를 수행한 후 list 보기 화면으로 전환하라
		return "redirect:/books/list";
		/*
		 * Controller method 의 return type 이 String 일때
		 * views/*.jsp 파일을 열어 rendering 을 수행한 후 USER 에게 보여라
		 * 이러한 것을 Forwarding 이라고 한다
		 * 
		 * redirect 로 시작되는 문자열을 만나면
		 * 서버의 다른 URL로 요청을 전달해버린다
		 */
	}
	
	@RequestMapping(value="/insert2",method=RequestMethod.GET)
	public String insert2() {
		
		
		return null;
	}
	
	@RequestMapping(value="/insert2",method=RequestMethod.POST)
	public String insert2(BookVO vo) {
		log.debug("도서정보 : "+ vo.toString());
		
		return null;
	}
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail() {
		
		return null;
	}
	
	@RequestMapping(value = "/{isbn}/detail", method = RequestMethod.GET)
	public String detail(@PathVariable("isbn") String isbn, Model model) {
		
		BookVO bookVO = bookService.findById(isbn);
		model.addAttribute("BOOK", bookVO);
		
		model.addAttribute("LAYOUT", "BOOK-DETAIL");
		return "home";
	}
	
	/*
	 * 전달받은 id 값으로 데이터를 Select 하고 model 에 담아서
	 * 입력 form 으로 전달한다
	 */
	@RequestMapping(value = "/{isbn}/update", method = RequestMethod.GET)
	public String update(@PathVariable("isbn") String isbn, Model model) {
		
		BookVO bookVO = bookService.findById(isbn);
		model.addAttribute("BOOK", bookVO);
		
		model.addAttribute("LAYOUT", "BOOK-INPUT");
		return "home";
	}
	
	@RequestMapping(value = "/{isbn}/update", method=RequestMethod.POST)
	public String update(BookVO bookVO) {
		int ret = bookService.update(bookVO);
		String retStr = String.format("redirect:/books/%s/detail", bookVO.getIsbn());
		return retStr;
	}
	
	@RequestMapping(value = "/{isbn}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable("isbn") String isbn) {
		
		// 삭제한 데이터 개수를 return 한다
		int ret = bookService.delete(isbn);
		
		return "redirect:/books/list";
	}
	
}