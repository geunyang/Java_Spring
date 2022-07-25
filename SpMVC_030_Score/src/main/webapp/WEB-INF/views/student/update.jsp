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
	<form method="post">
		<fieldset>
			<legend>학생 정보 등록</legend>
			<label>학번 : </label> 
			<div>${STUDENT.st_num}</div>
			<label>이름 : </label> 
			<input name="st_name" type="text" placeholder="이름" value="${STUDENT.st_name}"> 
			
			<label>학과 : </label>
			<input name="st_dept" type="text" placeholder="학과" value="${STUDENT.st_dept}"> 
			
			<label>연락처 : </label>
			<input name="st_tel" type="text" placeholder="학년" value="${STUDENT.st_tel}"> 
			
			<label>주소 : </label> 
			<input name="st_addr" type="text" placeholder="주소" value="${STUDENT.st_addr}">
			<div>
				<button type="submit">저장</button>
				<button type="button"><a href="${rootPath}/student">리스트</a></button>
			</div>
		</fieldset>
	</form>
</body>
</html>