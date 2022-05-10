# Spring CRUD 구현

## VO 클래스 디자인(추상화, 클래스 선언)

## 입력 form 화면을 디자인
## form 에서 데이터를 입력하고 전송 데이터 유효성 검사
* form 에서 입력한 데이터를 유효성 검사를 수행하는 것은
서버로 데이터를 보내기 전에 입력한 사용자에게 데이터가 잘 입력되었나 확인시키는 절차
* Client Side Validation  이라고 하는데, 보통 이때 JS 코드로 수행한다
* 데이터를 입력하고 저장(전송) button click 하면 form 에 담긴 데이터는 무조건 서버로 전송된다
* 이러한 상황이 되면 JS 코드를 사용하여 client size validation을 수행할 수 없다
* form 에 포함된 모든 버튼의 기본 속성을 무력화하여 무조데이터가 서버로 전송되는것을 방지해야한다
* form 에 포함된 버튼의 기본속성이란 버튼을 클릭했을때 submit event 가 자동으로 수행되는 것을 말한다
* 아래와 같이 form tag 로 감싸진 button 은 클릭했을 때 무조건 form tag 의 action 주소로 서버에 요청 하도록 사전에 정의 되어 있다
* form tag 내의 button 에는 submit 이라는 default event 가 자동으로 설정된다
* 이러한 상황에서는 JS 코드를 사용하여 데이터 유효성 검사를 할 수 없다
* 때문에 button submit event 를 무력화 시켜야 한다
```
	<form action="/school/score">
		<button class="btn-red">서버로 보내기</button>
	</form>
```
* form tag 내의 button 은 기본 type 이 ```type="submit"```이다
* button 을 클릭하면 서버로 무조건 달려가는 event 가 실행된다
* 이 button type 을 ```type="button"```으로 설정하면 submit event 가 무력화 된다
```
	<form action="/school/score">
		<button type="button" class="btn-red">서버로 보내기</button>
	</form>
```
* 또 다른 방법으로 form 의 submit() event 를 가로채는 방법도 있다
## Controller 에 데이터 수신할 method 처리
## Service 로 데이터 전송
## Dao 를 통해서 DBMS insert 요청

## Dao 를 통해서 DBMS 에게 Select 요청
## Service 에 받고
## Controller 로 return
## JSP 에 View Rendering 수행