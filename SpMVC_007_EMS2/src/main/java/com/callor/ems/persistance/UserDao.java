package com.callor.ems.persistance;

import com.callor.ems.model.UserVO;

// VO 가 UserVO로 바뀌어 복제 없는것은 생성
// PK 는 String으로 바뀌어 복제
// 중복 작성을 막기 위해
/*
 * Generic type의 상속
 * Generic 인터페이스를 상속(extends) 하면서 실제 사용할 type 을 명시해주면
 * 마치 새로운 코드를 복제하면서 type 을 지정하는 효과를 발휘한다
 */
public interface UserDao extends GenericDao<UserVO, String> {
	
	public void create_user_table();
	
}
