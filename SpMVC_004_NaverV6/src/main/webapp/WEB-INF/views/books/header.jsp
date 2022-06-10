<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<header>
	<h1>MY API</h1>
	<p>Naver API 를 활용한 도서, 뉴스, 영화 정보 서비스</p>
</header>
<nav>
	<ul>
		<li><a href="${rootPath}/">Home</a></li>
		<li><a href="${rootPath}/books/list">도서 정보</a></li>
		<li><a href="${rootPath}/news">오늘의 뉴스</a></li>
		<li><a href="${rootPath}/movies">영화 정보</a></li>
		<li><a href="${rootPath}/naver">네이버 체험</a></li>

		<%
		// 로그인을 하지 않았을때
		%>
		<c:if test="${empty USER}">
			<li><a href="${rootPath}/user/login">로그인</a></li>
			<li><a href="${rootPath}/user/join">회원가입</a></li>
		</c:if>

		<%
		// 로그인을 했을때는 MEMBER 객체에 로그인 한 사용자 정보가 담겨있다
		%>
		<c:if test="${not empty USER}">
			<li><a href="${rootPath}/user/mypage">My page(${USER.nickname})</a></li>
			<li><a href="${rootPath}/user/logout">Logout</a></li>
		</c:if>
	</ul>
</nav>