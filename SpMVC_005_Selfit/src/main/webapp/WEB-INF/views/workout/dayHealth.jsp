<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }" var="rootPath"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<style>
	div.list {
		display: flex;
		justify-content: space-around;
	}
</style>
</head>
<body>
	<section class="health">
		<h1>${HEALTH.list_name}</h1>
		<p>** 세트가 끝날 때마다 체크를 눌러 주세요</p>
		<c:forEach begin="1" end="${HEALTH.sl_set }" varStatus="index">
		<div class="list">
			<span>${INDEX.count} set)</span>
			<input placeholder="${HEALTH.sl_weight}"><label>KG</label>
			<input placeholder="${HEALTH.sl_rep}"><label>회</label>		
			<button>체크</button>
			</div>
		</c:forEach>
	</section>
</body>
</html>