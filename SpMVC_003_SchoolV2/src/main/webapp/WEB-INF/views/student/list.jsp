<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>
<!DOCTYPE html>

<html>
<%@ include file="/WEB-INF/views/include/include_head.jsp"%>
<style>
section {
	display: flex;
	flex-direction: column;
}

article {
	width: 80%;
	margin: 0 auto;
}

table {
	width: 80%;
	margin: 0 auto;
	border-top: 1px solid #ddd;
	border-bottom: 1px solid #ddd;
	border-collapse: collapse;
	font-size: 13px;
}

tr {
	border-bottom: 1px solid #ddd;
	border-top: 1px solid #ddd;
}

th, td {
	padding: 5px;
	text-align: left;
	cursor: pointer;
}

tr:nth-of-type(even) {
	background-color: #eee;
}

tr:nth-of-type(odd) {
	background-color: #fff;
}

tr:nth-of-type(n+2):hover {
	background-color: #ddd;
}


div.button-box {
	width: 80%;
	margin: 5px auto;
	text-align: right;
	padding: 5px 0;
}

div.button-box a {
	display: inline-block;
	padding: 12px 16px;
	text-decoration: none;
	color: white;
	background-color: blue;
	border-radius: 5px;
}

div.button-box a:hover {
	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.6);
}
</style>
<script src="${rootPath}/static/js/student.js"></script>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jsp"%>
	<%@ include file="/WEB-INF/views/include/include_nav.jsp"%>

	<section>
		<article>학생정보</article>
		<table>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>학과</th>
				<th>학년</th>
			</tr>
			<!-- 서비스의 selectAll에서 stList를 만든 데이터를 controller에게 보내고 model에 addAttribute에 담아서
			 list_view.jsp 가 랜더링해서 화면에 보여줌 -->
			<!--c tag 라이브러리에 들어있는 명령어를 가져와서 controller에서 받은 배열/리스트데이터를 
			items라는 속성에 대입 각각의 요소를 stVO에 담아 보여죠  -->
			<c:forEach items="${STUDENTS}" var="stVO">
			<tr>
				<td>${stVO.stNum}</td>
				<td class="name" data-num="${stVO.stNum}">${stVO.stName}</td>
				<td>${stVO.stDept}</td>
				<td>${stVO.intGrade}</td>
			</tr>
			</c:forEach>

		</table>
		<div class="button-box">
			<a href="${pageContext.request.contextPath}/input">학생정보 등록</a>
		</div>
	</section>

	<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>

</body>

</html>