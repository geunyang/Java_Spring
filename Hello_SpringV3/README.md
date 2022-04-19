# SpringMVC 패턴의 Request, Response
* web browser 의 주소창에 ```http://localhost:8080/hello/``` 라고 입력후 Enter를 누르면 
* ```http://lacalhost:8080``` 에서 실행중인 tomcat에 요청이 전달된다. 
* tomcat에 의해 실행중인 ```hello``` project에 요청이 전달된다.
* project 에 ```@Controller``` 가 설정된 class를 찾는다.
* ```@Controller``` class의 메서드 중 ```@RequestMapping``` 의 value가 ```"/"```  설정된 부분이 있는지 찾는다.
* ```request``` 와 일치하는 ```@RequestMapping``` 을 찾으면 해당 메서드를 실행하여 결과를 web browser 로 ```response``` 한다.

## ```@RequestMapping(value="/korea"```
* client 의 request를 받았을 때 적절한 코드를 실행할 메서드를 지정하는 Annotation
* ```value``` 속성에 request 의 요청 key를 작성한다.

## RequestMethod : method="POST" 또는 method="GET"
* web page 에 form 을 작성하여 데이터를 입력받고 서버로 전송 하는 코드를 작성 하는 경우 form tag 에 ```method="POST"``` 또는 	```method="GET"``` 속성이 기본 값으로 부여된다.
* form tag 만 단독으로 작성할 경우 ```method="GET"``` 속성이 기본값으로 부여된다.
* ```method="GET"``` 속성은 input box 에 입력된 데이터가 주소 표시줄에 노출되는 형태로 서버에 전송된다.
* 입력된 데이터가 주소 표시줄에 노출되면 보안에 매우 취약한 상황이 발생한다
* form tag 에는 특별한 경우가 아니면 반드시 ```method="post"``` 속성을 부여하여 사용하는 것이 좋다.
* form 에서 RequestMethod 를 구분해서 사용하면 Controller 에서는 ```RequestMethod``` 에 따라 ```다른 메서드를 실행```하게 할 수 있다.

## method="POST"
* 데이터의 크기 제한이 없음