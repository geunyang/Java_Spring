<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@  taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
* {
	
}

nav ul {
	list-style: none;
	display: flex;
	background-color: blue;
	color: white;
}

nav li {
	padding: 12px 16px;
	margin: 5px;
	cursor: pointer;
}

nav li:hover {
	box-shadow: 2px 2px 2px yellow;
}

nav li:nth-of-type(2) {
	margin-left: auto;
}

nav a {
	text-decoration: none;
	color: inherit;
}

form#logout-form {
	display: none;
}
</style>
</head>
<body>
	<header class="w3-container w3-green w3-text-white">
		<h1>안녕</h1>
		<p>가장 단순한 Spring Security Project</p>
	</header>

	<nav>
		<ul>
			<li><a href="${rootPath}/">HOME</a></li>
			<!-- 로그인이필요할때 -->
			<sec:authorize access="isAnonymous()">
				<li><a href="${rootPath}/user/login">LOGIN</a></li>
				<li><a href="${rootPath}/user/join">JOIN</a></li>
			</sec:authorize>
			<!-- 로그인후 -->
			<sec:authorize access="isAuthenticated()">
				<li class="logout">LOGOUT</li>
				<sec:authorize access="hasRole('ROLE_USER')">
					<li><a href="${rootPath}/user/mypage">MYPAGE</a></li>
				</sec:authorize>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li><a href="${rootPath}/admin">ADMIN</a></li>
			</sec:authorize>
		</ul>
	</nav>

	<section class="w3-container w3-padding-16">
		<c:choose>
			<c:when test="${LAYOUT == 'LOGIN'}">
				<%@ include file="/WEB-INF/views/user/login.jsp"%>
			</c:when>
			<c:when test="${LAYOUT == 'JOIN'}">
				<%@ include file="/WEB-INF/views/user/join.jsp"%>
			</c:when>
			<c:otherwise>
				<h1>HOME</h1>
			</c:otherwise>
		</c:choose>
	</section>

	<!-- Spring security 사용할때는 logout 시 POST 사용 -->
	<form:form id="logout-form" action="${rootPath}/logout" method="POST" />
	<script>
		document.querySelector("li.logout")?.addEventListener("click",()=>{
			document.querySelector("form#logout-form")?.submit()
		})
	</script>
	<%-- 	html 파일로 만들때는 필요함	<input name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
</body>
</html>