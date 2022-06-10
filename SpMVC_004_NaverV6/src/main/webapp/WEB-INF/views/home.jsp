<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }" var="rootPath"/>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/books/head.jsp" %>
<body>
	<%@ include file="/WEB-INF/views/books/header.jsp"%>
	<section class="main">
		<c:choose>
			<c:when test="${LAYOUT == 'BOOK-INPUT'}">
				<%@ include file="/WEB-INF/views/books/insert.jsp" %>
			</c:when>
			<c:when test="${LAYOUT == 'BOOK-LIST'}">
				<%@ include file="/WEB-INF/views/books/list.jsp" %>
			</c:when>
			<c:when test="${LAYOUT == 'BOOK-DETAIL'}">
				<%@ include file="/WEB-INF/views/books/detail.jsp" %>
			</c:when>
			<c:when test="${LAYOUT == 'JOIN'}">
				<%@ include file="/WEB-INF/views/user/join.jsp" %>
			</c:when>
			<c:when test="${LAYOUT == 'LOGIN'}">
				<%@ include file="/WEB-INF/views/user/login.jsp" %>
			</c:when>
			<c:when test="${LAYOUT == 'MYPAGE'}">
				<%@ include file="/WEB-INF/views/user/mypage.jsp" %>
			</c:when>
			<c:otherwise>
				<%@ include file="/WEB-INF/views/main_view.jsp" %>
			</c:otherwise>
		</c:choose>
	</section>
	<footer class="main">
		<address>CopyRight &copy; gaeballza@gmail.com</address>
	</footer>
	<div class="w3-modal modal-result">
		<div class="w3-modal-content w3-card-4">
			<header class="w3-container w3-teal">
				<span class="w3-button w3-display-topright modal-close">&times;</span>
				<h2>도서검색정보</h2>
			</header>
			<div class="w3-container search-content">
				<p>검색결과나올곳</p>
			</div>
			<footer class="w3-container w3-teal">
				<address>CopyRight &copy; gaeballza@gmail.com</address>
			</footer>
		</div>
		<script>
			document.querySelector("span.modal-close")?.addEventListener("click",()=>{
				document.querySelector("div.modal-result").style.display='none'
			})
			document.querySelector("footer.main").addEventListener("click",()=>{
				document.querySelector("div.modal-result").style.display='block'
			})
		</script>
	</div>
</body>
</html>