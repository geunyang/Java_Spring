<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<!DOCTYPE html>
<html>

<%@ include file="/WEB-INF/views/include/include_head.jsp"%>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border-collapse: collapse;
	width: 50%;
	margin: 20px auto;

	font-size: 13px;
	/* text-align: center; */
}

tr th, tr td {
	border: 1px solid #ddd;
}

tr th {
	background-color: #eee;
}

table th, table td {
	padding: 6px;
}
</style>
</head>
<script src="${rootPath}/static/js/student.js"></script>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jsp"%>
	<%@ include file="/WEB-INF/views/include/include_nav.jsp"%>
	<h1>학생 정보 자세히 보기</h1>
	<table>
		<tr>
			<th>학번</th>
			<td>${ST.stNum}</td>
			<th>이름</th>
			<td>${ST.stName}</td>
		</tr>
		<tr>
			<th>학과</th>
			<td>${ST.stDept}</td>
			<th>학년</th>
			<td>${ST.intGrade}</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${ST.stTel}</td>
			<th>주소</th>
			<td>${ST.stAddr}</td>
		</tr>
	</table>
	<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
</body>
</html>