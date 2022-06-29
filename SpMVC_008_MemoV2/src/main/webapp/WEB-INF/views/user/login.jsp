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
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gaegu&display=swap" rel="stylesheet">
<style>
      * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
      }
      html {
        width: 100vw;
        height: 100vh;
        font-family: 'Gaegu', cursive;
      }
      body {
        width: 100%;
        height: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        background-color: powderblue;
        background-image: url("../../../images/image14.jpg");
        background-repeat: no-repeat;
        background-position: center center;
        background-size: 100% 100%;
      }
      header {
        width: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
        margin-top: 50px;
      }
      section {
        width: 80%;
        margin: 0 auto;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        flex: 1;
      }
      form {
        width: 80%;
        text-align: center;
      }
      input {
        padding: 1rem;
        width: 100%;
        background-color: inherit;
        border: none;
      }
      input:focus {
        outline: none;
        background-color: inherit;
      }
</style>
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