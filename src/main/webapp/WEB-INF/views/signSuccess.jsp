<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강신청 성공</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/main.css">
</head>
<body>
	<h3>
	${course.coursename } 과목의 수강신청을 성공하였습니다.</h3><br>
	<a href="${pageContext.request.contextPath}/sign">수강신청 계속하기</a><br>
	<a href="${pageContext.request.contextPath}/signLookup?year=2021&semester=1">수강신청 조회하기</a>.
</body>
</html>