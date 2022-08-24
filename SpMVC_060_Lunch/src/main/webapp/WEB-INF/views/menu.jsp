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
<title>Insert title here</title>
</head>
<body>
	<section>
		<div>
			<table>
				<tr>
					<th>급식일자</th>
					<td>MLSV_YMD</td>
				</tr>
				<tr>
					<th>요리명</th>
					<td>DDISH_NM</td>
				</tr>
				<tr>
					<th>원산지정보</th>
					<td>ORPLC_INFO</td>
				</tr>
				<tr>
					<th>칼로리정보</th>
					<td>CAL_INFO</td>
				</tr>
				<tr>
					<th>영양정보</th>
					<td>NTR_INFO</td>
				</tr>
			</table>
		</div>
	</section>
</body>
</html>