<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/main.css">
<title>상세 과목 조회</title>
</head>
<body>
<table class="formtable">
<tr>
	<th>수강년도</th>
	<th>수강학기</th>
	<th>교과목명</th>
	<th>교과구분</th>
	<th>담당교수</th>
	<th>학점</th>
</tr>
	<c:forEach var ="course" items="${courses}" > <!-- key에 맞게 -->
		<tr>
			<td>${course.getYear()}</td>
			<td>${course.getSemester()}</td>
			<td> ${course.getCoursename()}</td>
			<td> ${course.getClassification()}</td>
			<td> ${course.getProfessor()}</td>
			<td> ${course.getCredit()}</td>
		</tr>
	</c:forEach>
</table>
	<p><a href = "${pageContext.request.contextPath}/courses"> 이전페이지로  </a> </p>
	<p><a href = "${pageContext.request.contextPath}/menu"> 메뉴로 돌아가기  </a> </p>
</body>
</html>