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
	width: inherit;
	height: inherit;
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
}
header {
	width: inherit;
	display: flex;
	justify-content: center;
	align-items: center;
	margin-top: 50px;
	background-color: #118bee;
}
form {
	width: 80%;
	text-align: center;
	margin: 20px;
}
input {
	padding: 1rem;
	width: 100%;
}
button {
	width: 100%;
}
</style>
<link rel="stylesheet" href="https://unpkg.com/mvp.css">
</head>
<body>
	<header>
		<h1>주소록</h1>
	</header>
	<form method="POST">
		<input name="a_seq" type="hidden" value='<c:out value="${ADDR.a_seq}" default="0"/>'/>
		<input name="a_name"  value="${ADDR.a_name}"/> 
		<input name="a_tel" value="${ADDR.a_tel}"/> 
		<input name="a_address" value="${ADDR.a_address}"/>
		<button>전송</button>
	</form>
	<table>
		<thead>
			<tr>
				<th>No.</th>
				<th>이름</th>
				<th>연락처</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ADDRS}" var="ADDR" varStatus="INDEX">
				<tr>
					<td>${INDEX.count}</td>
					<td><a href="${rootPath}/detail?seq=${ADDR.a_seq}">${ADDR.a_name}</a></td>
					<td>${ADDR.a_tel}</td>
					<td>${ADDR.a_address}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<%@include file="/WEB-INF/views/pagination.jsp" %>

</body>
</html>