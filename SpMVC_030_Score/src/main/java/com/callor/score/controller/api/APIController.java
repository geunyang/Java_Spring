package com.callor.score.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.callor.score.model.StudentVO;
import com.callor.score.service.StudentService;

/*
 * @Controller 클래스는 request(요청)에 대하여 보통 view(.jsp) 파일을
 * rendering 하여 response(응답) 하도록 설계하는 Router 클래스
 * 
 * 이 클래스에 @ResponseBody 를 부착하면 view 를 response 하는 대신에
 * 직접 문자열을 전송하거나 객체(List, VO)를 JSON type 으로 response 하도록
 * method 에 적용한다
 * 
 * @RestController 클래스는 request 에 대해서 기본값으로
 * JSON 을 Response 하도록 설계하는 router 클래스이다
 * 
 * 모든 method 에 마치 @ResponseBody 가 부착 된 것처럼 작동한다
 * Spring RestController 를 통하여 JSON 데이터를 response 하기 위해서는
 * JackBind Dependency 가 거의 필수적으로 요구된다
 * 
 * RestController 는 view 를 rendering 하지 않는다
 */
@RestController
@RequestMapping(value = "/api")
public class APIController {
	
	private final StudentService stService;

	public APIController(StudentService stService) {
		this.stService = stService;
	}
	
	@RequestMapping(value = {"/",""},method=RequestMethod.GET)
	public List<StudentVO> student() {
		return stService.selectAll();
	}
	
	@RequestMapping(value = "/{st_num}/delete", method=RequestMethod.GET)
	public String delete(@PathVariable("st_num") String st_num) {
		
		/*
		 * mybatis 에서 delete 를 수행한 후
		 * 몇개의 데이터가 삭제 되었는지 return 해준다
		 * 여기서는 PK 를 기준으로 삭제하기 때문에
		 * return 값은 삭제가 되었으면 1일 것이고
		 * 삭제에 실패하면 1 미만의 값이 return 될 것이다 (마이너스값이return되는경우존재)
		 */
		
		int ret = stService.delete(st_num);
		if(ret > 0) {
			return "OK";
		} else {
			return "FAIL";
		}
	}
	
	/* method 의 return type
	 * 
	 * void type :  아무것도 아닌 값을 return 하거나 하지 않거나
	 *
	 * public void voidMethod() {
	 * 		return; 
	 * }
	 * 아무것도 없는 값을 return method 를 종료
	 *
	 *
	 * 
	 * primitive type : 정수, 실수, 문자 등등 기본 type 의 값을 return
	 * 
	 * public int intMethod() {
	 *		 return 0; 
	 *}
	 * return type 이 int 형이므로 최소 0이라도 return 해야한다
	 * 더이상 할일이 없어 결과를 다시 되돌려 주는것
	 * return 만나면 method 는 종료
	 * 
	 * 
	 * class(참조) type : String, VO, DTO, List 등의 클래스(객체) type return
	 * 
	 * public String strMethod() {
	 * 		return null; 
	 * }
	 * 
	 * return 할 값이 없으면 최소 null 이라도 return 해야한다
	 * return 을 만나면 method 가 더이상 할일이 없다
	 * return null : 나를 호출한 곳에 보낼 데이터가 없다
	 * 
	 */


}
