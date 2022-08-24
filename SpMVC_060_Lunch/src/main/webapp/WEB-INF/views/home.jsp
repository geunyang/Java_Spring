<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>SOME LUNCH</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

html {
	width: 100vw;
	height: 100vh;
}

body {
	display: flex;
	flex-direction: column;
	width: 100%;
	height: 100%;
}

section.main {
	flex: 1;
}

header {
	padding: 1.2rem;
	text-align: center;
	background-color: rgb(193, 226, 237);
	color: rgb(47.41, 41);
	font-weight: 900;
}

a {
	text-decoration: none;
}

footer {
	background-color: skyblue;
	text-align: center;
	padding: 1rem;
}
.hidden_td {
	display: none;
}
</style>
<script>
	const rootPath = '${rootPath}'
</script>
</head>
<body>
	<header>
		<h1>환영합니다 운암중 급식 안내 사이트 어떤급식 입니다</h1>
	</header>
	<section class="main">
		<table class="LUNCHS">
			<tr>
				<th>날짜</th>
				<th>메뉴</th>
			</tr>
			<c:forEach items="${LUNCHS}" var="LUNCH">
				<tr data-mlsv_ymd="${LUNCH.MLSV_YMD}">
					<td>${LUNCH.MLSV_YMD}</td>
					<td>${LUNCH.DDISH_NM}</td>
				</tr>
			</c:forEach>
		</table>
	</section>
	<footer class="main">
		<address>CopyRight &copy; https://github.com/geunyang</address>
	</footer>
</body>
</html>