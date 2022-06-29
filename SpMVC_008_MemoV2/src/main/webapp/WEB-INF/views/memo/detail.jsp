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
<link rel="stylesheet" href="static/css/memo.css">
<style>
      table {
        width: inherit;
        background-color: rgba(255, 255, 255, 0.5);
        border-collapse: collapse;
      }
      table th,
      td {
        padding: 20px;
      }
      table tr:not(:last-of-type) {
        border-bottom: 1px solid gray;
      }
      div.btn_detail {
        margin: 20px auto;
      }
</style>
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
				<a href="${rootPath}/memo/${MEMO.m_seq}/update">다시쓰기</a>
			</button>
			<button type="button">
				<a href="${rootPath}/memo/${MEMO.m_seq}/delete">이별하기</a>
			</button>
			<button type="button">
				<a href="${rootPath}/">목록으로</a>
			</button>
		</div>
	</section>
</body>
</html>