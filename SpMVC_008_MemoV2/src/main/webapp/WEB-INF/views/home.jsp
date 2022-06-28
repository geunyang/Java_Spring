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
<link href="https://fonts.googleapis.com/css2?family=Gaegu&display=swap" rel="stylesheet">
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
        width: 100%;
        height: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        background-color: powderblue;
        background-image: url("../../images/image14.jpg");
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
/*       table {
        width: inherit;
        background-color: rgba(255, 255, 255, 0.5);
        border-collapse: collapse;
      }
      table th {
        text-align: center;
        border-bottom: 1px solid gray;
        padding: 10px;
      }
      table td {
        border-top: 1px solid gray;
        padding: 5px;
      } */
      table {
        width: inherit;
        background-color: rgba(255, 255, 255, 0.5);
        border-collapse: collapse;
      }
      table td,
      th {
        padding: 5px;
      }
      table th {
        border: none;
      }
      table td {
        border-top: 1px solid gray;
      }
      div.btn_home {
        margin: 20px auto;
      }
      div button {
        padding: 12px 16px;
        cursor: pointer;
        background-color: darkgray;
        border-style: none;
        margin: 0 20px;
        border-radius: 5px;
      }
      div button:hover {
        box-shadow: 2px 3px 5px 0px #eee;
      }
      div a {
        text-decoration: none;
        color: white;
      }
</style>
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/memo.js?20220627002"></script>
</head>
<body>
	<header>
		<h1>${USERNAME}님이 끄적댄것들</h1>
	</header>
	<section>
		<table class="memo">
			<tr>
				<th>SEQ</th>
				<th>작성일자</th>
				<th>작성시각</th>
				<th>내용</th>
			</tr>
			<c:if test="${empty MEMOS}">
				<tr>
					<td colspan="4">끄적인것이 없습니다</td>
				</tr>
			</c:if>
			<!-- ${MEMOS} controller가 준 값 -->
			<c:forEach items="${MEMOS}" var="MEMO" varStatus="INDEX">
				<tr data-seq="${MEMO.m_seq}">
					<td>${INDEX.count}</td>
					<td>${MEMO.m_date}</td>
					<td>${MEMO.m_time}</td>
					<td>${MEMO.m_memo}</td>
				</tr>
			</c:forEach>
		</table>
		<div class="btn_home">
			<button type="button">
				<a href="${rootPath}/memo/insert">끄적대기</a>
			</button>
			<button type="button">
				<c:if test="${empty USERNAME}">
					<a href="${rootPath}/user/login">로그인</a>
				</c:if>
			</button>
			<button type="button">
				<c:if test="${not empty USERNAME}">
					<a href="${rootPath}/user/logout">로그아웃</a>
				</c:if>
			</button>
		</div>
	</section>
</body>
</html>