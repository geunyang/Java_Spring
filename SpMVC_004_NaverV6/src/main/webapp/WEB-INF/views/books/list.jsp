<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<html>
<%@ include file="/WEB-INF/views/books/head.jsp" %>
<style>
	table {
		border-collapse: collapse;
		margin:10px auto;
		width: 80%;
	}
	
	div.btn_box {
		width:80%;
		margin:10px auto;
		text-align: right;
	}
	
	div.btn_box a {
		text-decoration: none;
		display: inline-block;
		padding:12px 16px;
		background-color: blue;
		color:white;
		border-radius: 6px;
	}
	
	div.btn_box a:hover {
		box-shadow: 2px 2px 2px rgba(0,0,0,0.7);
	}
</style>
<body>
	<table class="w3-table-all books">
		<colgroup>
			<col width="100px">
			<col width="100px">
			<col width="300px">
			<col width="100px">
			<col width="100px">
			<col width="100px">
		</colgroup>
		<thead>
			<tr>
				<th>NO</th>
				<th>ISBN</th>
				<th>도서명</th>
				<th>출판일</th>
				<th>저자</th>
				<th>출판사</th>
			</tr>
		</thead>
		<tbody>
		<%/*서버로부터 받은 데이터(도서리스트)를 보여주기 위한 부분 
		BOOKS: 서버로부터 받을 데이터
		BOOK: forEach 를 사용하여 한개의 요소를 추출하여 저장할 변수
		*/%>
		<c:forEach items="${BOOKS}" var="BOOK" varStatus="INDEX">
			<tr data-isbn="${BOOK.isbn}">			
				<td>${INDEX.count}</td>
				<td>${BOOK.isbn}</td>
				<td>${BOOK.title}</td>
				<td>${BOOK.pubdate}</td>
				<td>${BOOK.author}</td>
				<td>${BOOK.publisher}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="btn_box">
		<a href="${rootPath}/books/insert">도서정보추가</a>
	</div>
</body>
</html>