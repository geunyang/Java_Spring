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
<style>
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
          <button>낙서남기기</button>
        </div>
      </form>
    </section>
</body>
</html>