package com.callor.naver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.naver.config.QualifierConfig;
import com.callor.naver.model.BookVO;
import com.callor.naver.persistance.BookDao;
import com.callor.naver.service.BookService;

import lombok.extern.slf4j.Slf4j;

/*
 * bookServiceV1
 * BookService interface 를 상속받은 클래스가 다수 있을때
 * Controller 에서 어떤 클래스를 지금 연결하여 사용할 것인가의
 * 문제가 발생
 * 
 * 그럴때 @Service Annotation 이름(식별자)을 부착하여 두고
 * 클래스 중에서 필요한 부분을 선택할 수 있도록 하기 위하여
 * 부착하는 것
 */
@Slf4j
@Service(QualifierConfig.SERVICE.BOOKS_V1)
public class BookServiceImplV1 implements BookService {
	
	/*
	 * GenericDao 를 상속 받아 BookDao 를 만들고, 
	 * BookDao를 상속받아 BookService 를 만들었다
	 * 이러한 다중상속 관계에서
	 * BookDao 를 사용하여 서비스를 구현하려고 한다
	 * 
	 * 보통 Dao 를 설정할때 private final 로 선언하고
	 * 생성자에서 주입받아 사용했다
	 * 
	 * 그런데 다중 상속 관계에서
	 * 각각의 상속이 얽히며 무한 반복 구조가 만들어질 수 있다
	 * 이때는 생성자 주입을 할 수 없고.
	 * setter(@Autowired) 주입으로 사용해야한다
	 */
	@Autowired
	private BookDao bookDao;
	
	/*
	 * spring 에서 어떤 자동화 된 코드를 실행하고 싶을때
	 * method 를 만들고 method 에 @Autowired 를 설정해두면
	 * 서비스가 처음 실행될때 method 를 자동으로 실행해준다 
	 */
	@Autowired
	@Override
	public void create_book_table() {
		log.debug("CREATE TABLE");
		
		/*
		 * BookDao 의 create_book_table() method 를 실행하라
		 * 만약 exception 이 발생하면 무시하라
		 */
		try {
			/*
			 * dao 에 create table SQL 을 작성해두고
			 * Service 클래스에 Autowired 된 method 를 선언하고
			 * 자동으로 실행되도록 한다
			 */
			bookDao.create_book_table();
			log.debug("BOOK TABLE 생성 완료");
		} catch (Exception e) {
			log.debug("BOOK TABLE 생성 실패");
		}
		
	}
	
	public BookServiceImplV1(BookDao book) {
		this.bookDao = book;
	}
	
	

	@Override
	public List<BookVO> selectAll() {
		List<BookVO> bookList = bookDao.selectAll();
		return bookList;
		
	}

	@Override
	public BookVO findById(String id) {
		
		BookVO bookVO = bookDao.findById(id);
		return bookVO;
	}

	@Override
	public int insert(BookVO vo) {
		/*
		 * mybatis 에서 db 에 insert 를 수행하고 나면
		 * insert 된 데이터의 행 개수를 return 한다
		 * 만약 return 된 값이 0이라면 한개의 데이터도 insert 하지 못한 것이다
		 * 1 이상의 정수값이 return 되면 몇개의 데이터가 insert 되었는지
		 * 확인 할 수 있다
		 */
		int ret = bookDao.insert(vo);
	return ret;
	}

	@Override
	public int update(BookVO vo) {
		// TODO Auto-generated method stub
		bookDao.update(vo);
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		bookDao.delete(id);
		
		return 0;
	}



	@Override
	public List<BookVO> findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<BookVO> findByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<BookVO> findByPublisher(String publisher) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<BookVO> findByIsbn(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<BookVO> findByPubdate(String pubdate) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<BookVO> findByPrice(int price) {
		// TODO Auto-generated method stub
		return null;
	}




}
