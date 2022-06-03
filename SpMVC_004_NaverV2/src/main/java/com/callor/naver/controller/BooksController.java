package com.callor.naver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.model.BookVO;
import com.callor.naver.service.BookService;

import lombok.extern.slf4j.Slf4j;

/*
 * 프로젝트의 요청에 대하여 소수의 Controller를 만들고 처리 가능
 * 하지만 프로젝트 규모가 커지면 코드 관리가 어려워지고
 * 결국에는 프로젝트를 Refactoring 해야 됨
 */

@Slf4j
@RequestMapping(value = "/books")
@Controller
public class BooksController {
	private final BookService bookService;

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
		return "books/list";
	}

	@RequestMapping(value = "/list")
	public String list(Model model) {
		List<BookVO> bookList = bookService.selectAll();

		// bookList에 담긴 데이터를 BOOKS 이름으로 변수에 담아 jsp 파일로 보내기
		model.addAttribute("BOOKS", bookList);

		return null;
	}

	/*
	 * RequestMethod가 없는 Mapping은
	 * get 요청이나 POST 요청을 모두 처리하는 method가 되버린다
	 * 
	 * method = RequestMethod.GET로 지정하면 a tag link를 눌렀을 때의 요청만 처리하도록 역할 제한
	 */

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {

		return null;
	}

	/*
	 * method = POST가 부착된 form으로 감싼 데이터들이 전송되었을때
	 * 요청을 받아 처리 할 method 
	 */

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(BookVO bookVO) {
		log.debug("도서정보 : " + bookVO.toString());
		bookService.insert(bookVO);

		return null;
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
	
}
