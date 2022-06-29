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
<title>끄적끄적</title>
<link rel="stylesheet" href="static/css/memo.css">
</head>
<body>
    <header><h1>로그인</h1></header>
    <section>
      <form method="POST">
        <input name="username" placeholder="별명 입력 후 ENTER" />
      </form>
    </section>
</body>
</html>