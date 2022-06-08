<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/books/head.jsp"%>
<style>
section.w3-container {
	display: flex;
	flex-direction: column;
	width: 80%;
	margin: 10px auto;
}

div.detail-flex {
	display: flex;
	justify-content: space-around;
}

div.detail, div.btn-box {
	width: 80%;
	margin: 10px auto;
}

div.btn-box {
	text-align: right;
}

div.btn-box a {
	text-decoration: none;
	color: white;
	display: inline-block;
	padding: 12px 16px;
	border-radius: 5px;
}

div.btn-box a:hover {
	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.7);
}

a.list {
	background-color: green;
}

a.update {
	background-color: blue;
}

a.delete {
	background-color: red;
}
</style>
<body>
	<section class="w3-container">
		<div class="w3-container detail-flex">
			<div>
				<img src="${BOOK.image}">
			</div>
			<div class="detail">
				<h2>도서명 : <a href="${BOOK.link}" target=_Blank>${BOOK.title}</a></h2>
				<p>ISBN : ${BOOK.isbn}</p>
				<p>저자 : ${BOOK.author}</p>
				<p>출판사 : ${BOOK.publisher}</p>
				<p>가격 : ${BOOK.price}</p>
				<p>출판일자 : ${BOOK.pubdate}</p>
			</div>
		</div>
		<div class="btn-box">
			<a href="${rootPath}/books/list" class="list">리스트</a> <a
				href="${rootPath}/books/${BOOK.isbn}/update" class="update">수정</a>
			<%
			//href="javascript:void(0)" : atag 의 link 연결기능을 완전 무력화하기
			%>
			<a href="javascript:void(0)" class="delete">삭제</a>
		</div>
	</section>
	<footer>
		<address>CopyRight &copy; gaeballza@gmail.com</address>
	</footer>
</body>
<script>
	document.querySelector("a.delete")?.addEventListener("click",()=>{
		if(confirm("정말 삭제할까요?")) {
			document.location.replace("${rootPath}/books/${BOOK.isbn}/delete")
		}
	});
	/*
	location.href = URL 과 location.replace(URL) 의 차이점
	.href 는 브라우저 화면이 전환될때 history 를 계속 간직하고 있다
	어떤 page 에서 계속 뒤로가기를 클릭하면 연속으로 뒤로 복귀가 된다
	
	.replace() 는 현재화면의 history 를 제거해버리고 새로운 page 로 
	덮어쓰기가 된다
	뒤로가기를 눌렀을때 현재 보고 있는 페이지를 열수없다는 것이다
	
	보통 detail 에서 삭제를 선택했을때
	삭제하고 난 후 뒤로 가기를 눌러 이미 삭제된 데이터를 보는것을 
	방지하기 위함이다
	*/
</script>
</html>