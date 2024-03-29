<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />

<div class="student detail body">
	<div>학번 :</div>
	<div class="student detail">${STUDENT.st_num}</div>
</div>
<div class="student detail body">
	<div>이름 :</div>
	<div class="student detail">${STUDENT.st_name}</div>
</div>
<div class="student detail body">
	<div>학과 :</div>
	<div class="student detail">${STUDENT.st_dept}</div>
</div>
<div class="student detail body">
	<div>연락처 :</div>
	<div class="student detail">${STUDENT.st_tel}</div>
</div>
<div class="student detail body">
	<div>주소 :</div>
	<div class="student detail">${STUDENT.st_addr}</div>
</div>

<div>
	<c:forEach items="${STUDENT.scoreList}" var="SCORE">
		<div>${SCORE.sb_name} (${SCORE.sc_sbcode}) : ${SCORE.sc_score}</div>
	</c:forEach>
</div>
<div>
	<button><a href="${rootPath}/student/update?st_num=${STUDENT.st_num}">수정</a></button>
	<button><a href="${rootPath}/student">목록</a></button>
</div>