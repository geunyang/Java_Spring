<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@  taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set value="${pageContext.request.contextPath }" var="rootPath"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
</head>
<body>
	<h1>안녕</h1>
	<p>가장 단순한 Spring Security Project</p>
	<!-- Spring security 사용할때는 logout 시 POST 사용 -->
	<form:form action="${rootPath}/logout" method="POST">
		<button>로그아웃</button>
<%-- 	html 파일로 만들때는 필요함	<input name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
	</form:form>
</body>
</html>