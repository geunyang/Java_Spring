<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }" var="rootPath"/>
<!DOCTYPE html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>나의 API APP</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="${rootPath}/static/css/main.css?ver=2022-06-08-002">
<link rel="stylesheet"
	href="${rootPath}/static/css/home.css?ver=2022-06-09-001">
<link rel="stylesheet"
	href="${rootPath}/static/css/table.css?ver=2022-06-08-002">
<style>
button {
	background-color: powderblue;
	color: white;
	outline: none;
	padding: 12px 16px;
	margin : 10px auto;
	text-decoration: none;
	display: inline-block;
}

button:hover {
	cursor: pointer;
	background-color: aqua;
}
</style>
<script>
	const rootPath = '${rootPath}'
</script>
<script src="${rootPath}/static/js/input.js?ver=2022-06-08-010"></script>
<script src="${rootPath}/static/js/books.js?ver=2022-06-07-001"></script>
</head>