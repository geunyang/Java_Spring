<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/books/head.jsp" %>
<body>
	<%@ include file="/WEB-INF/views/books/header.jsp"%>
	<section class="main">
	<h2>도서 정보 상세 보기</h2>
		<table>
			<tr>
				<th>도서코드</th>
				<td></td>
				<th>도서명</th>
				<td></td>
			</tr>
			<tr>
				<th>출판사</th>
				<td></td>
				<th>저자</th>
				<td></td>
			</tr>
			<tr>
				<th>출판일자</th>
				<td></td>
				<th>정가</th>
				<td></td>
			</tr>
		</table>
		<article>
			<button><a href="${rootPath}/books/insert">저장</a></button>
			<button><a href="${rootPath}/books/detail">새로작성</a></button>
			<button><a href="${rootPath}/books/list">리스트보기</a></button>
		</article>
	</section>
	<footer>
		<address>CopyRight &copy; gaeballza@gmail.com</address>
	</footer>
</body>
</html>