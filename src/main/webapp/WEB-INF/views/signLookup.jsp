<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강신청과목 조회</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/main.css">
</head>
<body>
<h3>2021학년도 1학기  수강신청 과목 조회</h3><br>
<table class="formtable">
<tr>
	<th>교과목명</th>
	<th>교과구분</th>
	<th>담당교수</th>
	<th>학점</th>
	<th></th>
</tr>
	<c:forEach var ="course" items="${courses}" >
		<tr>
			<td> ${course.getCoursename()}</td>
			<td> ${course.getClassification()}</td>
			<td> ${course.getProfessor()}</td>
			<td> ${course.getCredit()}</td>
		</tr>
	</c:forEach>
</table>
<br><br>
<a href="${pageContext.request.contextPath}/sign">수강신청 계속하기.</a><br>
</body>
</html>