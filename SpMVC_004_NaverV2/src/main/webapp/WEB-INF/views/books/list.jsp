<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<html>
<%@ include file="/WEB-INF/views/books/head.jsp" %>
<body>
	<%@ include file="/WEB-INF/views/books/header.jsp"%>
	<section class="modal-content">
		<article class="ch-container ch-teal">
			<span
				onclick="document.getElementById('modal_box').style.display='none'"
				class="ch-button ch-display-top-right">&times;</span>
			<h2>도서 정보 목록 보기</h2>
		</article>
		<article class="ch-container">
			<table class="ch-table">
				<colgroup>
					<col width="300px">
					<col width="100px">
					<col width="100px">
				</colgroup>
				<thead>
					<tr>
						<th>No.</th>
						<th>ISBN</th>
						<th>도서명</th>
						<th>출판사</th>
						<th>저자</th>
						<th>출판일자</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${BOOKS}" var="BOOK">
						<tr>
							<td></td>
							<td>${BOOK.isbn}</td>
							<td>${BOOK.title}</td>
							<td>${BOOK.publisher}</td>
							<td>${BOOK.author}</td>
							<td>${BOOK.pubdate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</article>
			<button onclick="location.href = '${rootPath}/books/insert'">도서정보
		추가</button>
	</section>

	<footer>
		<address>CopyRight &copy; gaeballza@gmail.com</address>
	</footer>
</body>
</html>