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
<title>끄적끄적</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gaegu&display=swap"
	rel="stylesheet">
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

html {
	width: 100vw;
	height: 100vh;
	font-family: 'Gaegu', cursive;
}

body {
	width: 100%;
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
	background-color: powderblue;
	background-image: url("${rootPath}/static/image/image14.jpg");
	background-repeat: no-repeat;
	background-position: center center;
	background-size: 100% 100%;
}

header {
	width: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	margin-top: 50px;
}

section {
	width: 80%;
	margin: 0 auto;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	flex: 1;
}

table {
	width: inherit;
	background-color: inherit;
	font-size: 25px;
}

table td, th {
	padding: 5px;
}

table th {
	border: none;
	text-align: right;
}

table td {
	border: none;
	text-align: center;
} 

div button {
	padding: 12px 16px;
	cursor: pointer;
	background-color: darkgray;
	border-style: none;
	margin: 0 20px;
	border-radius: 5px;
	color: white;
}

div button:hover {
	box-shadow: 2px 3px 5px 0px #eee;
}

div a {
	text-decoration: none;
	color: white;
	font-family: 'Gaegu', cursive;
	font-size: 20px;
}
</style>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
</head>
<body>
	<header>
		<h1>끄적댄것</h1>
	</header>
	<section>
		<table>
			<tr>
				<th>작성자</th>
				<td>${MEMO.m_author}</td>
			</tr>
			<tr>
				<th>작성일자</th>
				<td>${MEMO.m_date}</td>
			</tr>
			<tr>
				<th>작성시각</th>
				<td>${MEMO.m_time}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${MEMO.m_memo}</td>
			</tr>
			<tr>
				<th>이미지</th>
				<td><img src="${rootPath}/upload/${MEMO.m_up_image}"
					alt="${MEMO.m_image}" width="500px" /></td>
			</tr>
		</table>
		<div class="btn_detail">
			<button type="button">
				<a href="${rootPath}/memo/${MEMO.m_seq}/update"><i class="xi-save"></i>다시쓰기</a>
			</button>
			<button type="button">
				<a href="${rootPath}/memo/${MEMO.m_seq}/delete"><i class="xi-trash-o"></i>이별하기</a>
			</button>
			<button type="button">
				<a href="${rootPath}/"><i class="xi-home-o"></i>목록으로</a>
			</button>
		</div>
	</section>
</body>
</html>