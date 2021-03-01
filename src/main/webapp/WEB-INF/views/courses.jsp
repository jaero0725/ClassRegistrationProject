<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학기별 이수 학점 조회</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/main.css">
</head>
<body>
<h3>수강과목 누적 조회 </h3>
<table class="formtable"> 
<tr class="toptr">
	<th>수강년도</th>
	<th>수강학기</th>
	<th>취득학점</th>
	<th>비고</th>
</tr>
	<c:set var ="sum" value="0"/>
	<c:forEach var ="course" items="${courses}" > <!-- key에 맞게 -->
		<tr>
			<td>${course.getYear()}</td>
			<td>${course.getSemester()}</td>
			<td> ${course.getCredit()}</td>
			<td>
			<a href=
				"${pageContext.request.contextPath}
				/courses/semester?year=${course.getYear()}&semester=${course.getSemester()}">
				상세보기
			</a>
			</td>
		</tr>
		<!-- 합계점수를 위해 -->
		<c:set var ="sum" value="${sum+course.getCredit()}"/>
	</c:forEach>
<tr class="bottomtr">
	<td>총계</td>
	<td></td>
	<td><c:out value="${sum}"/></td>
	<td></td>
</tr>
</table>
<p><a href = "${pageContext.request.contextPath}/menu"> 메뉴로 돌아가기  </a> </p>
</body>
</html>