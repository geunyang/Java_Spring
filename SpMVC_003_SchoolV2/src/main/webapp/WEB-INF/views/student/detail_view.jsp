<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }" var="rootPath"/>
<!DOCTYPE html>
<html>

<%@ include file="/WEB-INF/views/include/include_head.jsp"%>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="${rootPath}/static/js/student.js"></script>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jsp"%>
	<%@ include file="/WEB-INF/views/include/include_nav.jsp"%>
	<h1>학생 정보 자세히 보기</h1>

	<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
</body>
</html>