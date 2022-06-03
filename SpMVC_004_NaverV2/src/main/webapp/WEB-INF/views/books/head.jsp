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

<link rel="stylesheet"
	href="${rootPath}/static/css/main.css?ver=2022-06-02-001">
<link rel="stylesheet"
	href="${rootPath}/static/css/home.css?ver=2022-06-02-005">
<link rel="stylesheet"
	href="${rootPath}/static/css/table.css?ver=2022-06-02-002">
<link rel="stylesheet" href="${rootPath}/static/css/modal.css">
<link rel="stylesheet"
	href="${rootPath}/static/css/input.css?ver=2022-05-31-001">
<style>
button {
	background-color: powderblue;
	color: white;
	outline: none;
	padding: 12px;
}

button:hover {
	cursor: pointer;
	background-color: aqua;
}
</style>
<script>
	const rootPath = '${rootPath}'
</script>
<script src="${rootPath}/static/js/input.js?ver=2022-05-31-003"></script>
</head>