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
      }
      div button {
        padding: 12px 16px;
        cursor: pointer;
        background-color: darkgray;
        border-style: none;
        margin: 0 20px;
        border-radius: 5px;
        color: white;
      }
      div button:hover {
        box-shadow: 2px 3px 5px 0px #eee;
      }
</style>
</head>
<body>
    <header>
      <h1>끄적대기</h1>
    </header>
    <section>
      <!-- DTO/VO 에 있는 이름을 name 에 사용하지 마세용 -->
      <!-- value='<c:out value="${MEMO.m_seq}" default ="0"/>' seq 값 비어있을때 0 넣기 위한 코드  -->
      <form method="POST" enctype="multipart/form-data">
        <input
          name="m_seq"
          type="hidden"
          value='<c:out value="${MEMO.m_seq}" default ="0"/>'
        />
        <input
          name="m_memo"
          placeholder="아무거나 입력하세요"
          value="${MEMO.m_memo}"
        />
        <input name="file" type="file" accept="images/*" />
        <div>
          <button type="button">낙서남기기</button>
        </div>
      </form>
    </section>
</body>
</html>