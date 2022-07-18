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
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>이름</th>
			<td>${ADDR.a_name}</td>
		</tr>
		<tr>
			<th>연락처</th>
			<td>${ADDR.a_tel}</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${ADDR.a_address}</td>
		</tr>
	</table>
	<div>
		<a href="${rootPath}/update?seq=${ADDR.a_seq}">수정하기</a>
		<a href="${rootPath}/delete?seq=${ADDR.a_seq}">삭제하기</a>
		<a href="${rootPath}/">목록으로</a>
	</div>
</body>
</html>