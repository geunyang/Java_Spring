# Spring 의 이해

## 데이터를 내보내는 방식
* web -> req -> tomcat -> dispatcherservlet

## MVC2 pattern
* JSP 를 직접 핸들링 하지 않고 controller 를 통해 접근

* ```<logger name="com.callor.hello" level="DEBUG" additivity="false">``` 프로젝트 완성후 DEBUG 부분 INFO로 바꿔서 배포
* ```<param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value>``` servlet 부분 * 로 바꿔서 모든 context 포함하게 변경
* ```<resources mapping="/resources/**" location="/resources/" />``` resources 부분 오타 나기 쉽기 때문에 static 으로 변경

## 오류
* 401/403 권한오류
* 404/405 주소없음
* 400 ????

## client(서버에게 요청하는 대상)/server(요청에 응답하는 대상)
* response
* request
* 다이나믹 서버랑 apatch 서버 차이점 찾아볼것