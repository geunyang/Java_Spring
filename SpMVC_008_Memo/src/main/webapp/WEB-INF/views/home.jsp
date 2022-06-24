<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@  taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<script>
	const rootPath = "${rootPath}"
</script>
</head>
<body>
	<h1>HOME</h1>

	<div class="memo">
		<c:forEach items="${memoVO}" var="VO">
			<div class="m_content" data-id="${VO.m_seq}">
				<h3>${VO.m_author}</h3>
				<h1>${VO.m_memo}</h1>
				<img src="${rootPath}/upload/${VO.m_image}" width="100px"
					alt="${VO.m_image}">
				<hr>
			</div>
		</c:forEach>
	</div>
	<a href="${rootPath}/input">추가</a>


	<%-- 	
	<a href="${rootPath}/memo/write">게시판</a>
	<a href="${rootPath}/file/fileups">여러 이미지 업로드</a>
	<div class="images">
		<c:forEach items="${FILES}" var="FILE">
			<img src="${rootPath}/upload/${FILE.i_imageName}" width="100px" alt="${FILE}">
		</c:forEach>
	</div> 
--%>
</body>
<script src="${rootPath}/static/js/detail.js?2022-06-24-001"></script>
</html>