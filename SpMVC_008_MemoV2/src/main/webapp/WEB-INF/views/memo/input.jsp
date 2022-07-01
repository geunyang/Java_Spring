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
<title>끄적끄적</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Gaegu&display=swap"
	rel="stylesheet">
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
	background-image: url("${rootPath}/static/image/image14.jpg");
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

div button {
	padding: 12px 16px;
	cursor: pointer;
	background-color: darkgray;
	border-style: none;
	margin: 0 20px;
	border-radius: 5px;
	color: white;
	font-family: 'Gaegu', cursive;
	font-size: 20px;
}

div button:hover {
	box-shadow: 2px 3px 5px 0px #eee;
}

form {
	width: 50%;
	text-align: center;
}

input {
	padding: 1rem;
	width: 50%%;
	background-color: inherit;
	border: none;
}

#write {
	font-family: 'Gaegu', cursive;
	font-size: 25px;
}

input:focus {
	outline: none;
	background-color: inherit;
}

div.rgyPostIt {
	position: relative;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center; 
	padding : 20px 45px 20px 15px;
	margin: 5px 0;
	border: 1px solid #f8f861;
	border-left: 30px solid #f8f861;
	border-bottom-right-radius: 60px 10px;
	font-size: 27px;
	color: #555;
	word-break: break-all;
	background: #ffff88; /* Old browsers */
	background: -moz-linear-gradient(-45deg, #ffff88 81%, #ffff88 82%, #ffff88 82%,
		#ffffc6 100%); /* FF3.6+ */
	background: -webkit-gradient(linear, left top, right bottom, color-stop(81%, #ffff88
		), color-stop(82%, #ffff88), color-stop(82%, #ffff88),
		color-stop(100%, #ffffc6)); /* Chrome,Safari4+ */
	background: -webkit-linear-gradient(-45deg, #ffff88 81%, #ffff88 82%, #ffff88 82%,
		#ffffc6 100%); /* Chrome10+,Safari5.1+ */
	background: -o-linear-gradient(-45deg, #ffff88 81%, #ffff88 82%, #ffff88 82%,
		#ffffc6 100%); /* Opera 11.10+ */
	background: -ms-linear-gradient(-45deg, #ffff88 81%, #ffff88 82%, #ffff88 82%,
		#ffffc6 100%); /* IE10+ */
	background: linear-gradient(135deg, #ffff88 81%, #ffff88 82%, #ffff88 82%, #ffffc6
		100%); /* W3C */
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffff88',
		endColorstr='#ffffc6', GradientType=1);
	/* IE6-9 fallback on horizontal gradient */
	transition: all 0.2s;
	-webkit-transition: all 0.2s;
	padding: 20px 45px 20px 15px;
}

div.rgyPostIt::after {
	content: " ";
	position: absolute;
	z-index: -1;
	right: 0;
	bottom: 35px;
	width: 150px;
	height: 30px;
	background-color: rgba(0, 0, 0, 0);
	box-shadow: 2px 35px 5px rgba(0, 0, 0, 0.4);
	-webkit-box-shadow: 2px 35px 5px rgba(0, 0, 0, 0.4);
	transform: matrix(-1, -0.1, 0, 1, 0, 0);
	-webkit-transform: matrix(-1, -0.1, 0, 1, 0, 0);
	-moz-transform: matrix(-1, -0.1, 0, 1, 0, 0);
	-ms-transform: matrix(-1, -0.1, 0, 1, 0, 0);
	-o-transform: matrix(-1, -0.1, 0, 1, 0, 0);
	transition: all 0.2s;
	-webkit-transition: all 0.2s;
}

div.rgyPostIt:hover {
	border-bottom-right-radius: 75px 30px;
}

div.rgyPostIt:hover::after {
	box-shadow: 2px 37px 7px rgba(0, 0, 0, 0.37);
	-webkit-box-shadow: 2px 37px 7px rgba(0, 0, 0, 0.37);
}
</style>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
</head>
<body>
	<header>
		<h1>끄적대기</h1>
	</header>
	<section>
		<!-- DTO/VO 에 있는 이름을 name 에 사용하지 마세용 -->
		<!-- value='<c:out value="${MEMO.m_seq}" default ="0"/>' seq 값 비어있을때 0 넣기 위한 코드  -->
		<form method="POST" enctype="multipart/form-data">
			<input name="m_seq" type="hidden"
				value='<c:out value="${MEMO.m_seq}" default ="0"/>' />
			<div class="rgyPostIt">
				<input id="write" name="m_memo" placeholder="아무거나 입력하세요"
					value="${MEMO.m_memo}" />
			</div>
			<input name="file" type="file" accept="images/*" />
			<div>
				<button><i class="xi-save"></i>낙서남기기</button>
			</div>
		</form>
	</section>
</body>
</html>