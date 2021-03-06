# 성적처리 프로젝트
* SpMVC_030_Score
* basse-package : com.callor.score

## DB 연결
* MySQL 의 schoolDB

## table 
* tbl_student, tbl_score, tbl_subject

## DB 연결을 위한 Dependency 설정
* spring-jdbc
* commons-dbcp2
* mybatis
* mybatis-spring
* mysql-connector/J
* spring-framework : 5.2.22.rel
* lombok
* logback-classic
* jackson-databind


## package 설정
* model package, persistance package

## mapper folder 생성
* /WEB-INF/spring/mapper

## VO 클래스
* tbl_student, tbl_score, tbl_subject 를 참조하여 각각
StudentVO, ScoreVO, SubjectVO 를 model package 에 생성

## Dao 인터페이스
* persistance.GenericDao interface
selectAll(), findById(), insert(), update(), delete() method 선언

## Student 정보 요청
* http://localhost:8080/score/student 로 요청하면 학생 데이터 전체를 JSON 웹 화면에 보여주는 코드 작성
* StudentController 에 @ResponseBody 부착된 home() method 선언
* StudentService.selectAll()
* StudentDao.selectAll()
* student-mapper.xml.selectAll

## Student 정보 삭제
* http://localhost:8080/score/api/student/학번/delete 로 요청시 학생의 데이터를 삭제할 수 있는 코드 작성
* 학번에 해당하는 학생의 데이터를 삭제할 수 있는 method 생성 
* stService.delete(학번)
* stDao.delete(학번)
* student-mapper.xml.delete
