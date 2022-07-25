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

## tiles 적용하기
* 스프링 타일즈란 뷰페이지의 jsp들을 상단, 사이드, 메인, 하단을 설정 상태로 include 처리해주는 구조의 템플릿. 페이지들을 일괄관리 할 수 있고, 공통사용하는 부분들을 매번 등록을 따로 해주지 않아도 되기 때문에 편리
* pom.xml에 maven 추가, 버전 통일
```
		<org.tiles-version>3.0.8</org.tiles-version>
```
```
		<!-- https://mvnrepository.com/artifact/org.apache.tiles/tiles-core -->
		<dependency>
			<groupId>org.apache.tiles</groupId>
			<artifactId>tiles-core</artifactId>
			<version>${org.tiles-version}</version>
		</dependency>
```
```
		<!-- https://mvnrepository.com/artifact/org.apache.tiles/tiles-extras -->
		<dependency>
			<groupId>org.apache.tiles</groupId>
			<artifactId>tiles-extras</artifactId>
			<version>${org.tiles-version}</version>
		</dependency>
```
