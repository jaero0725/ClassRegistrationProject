<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%  request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강신청 홈페이지</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/css/main.css">
</head>
<body>
	<!-- Data Binding / Data Validation 0 / Data Buffering 0-->
	
	<h3> 2021학년도 1학기 수강신청 </h3>
	<img src="${pageContext.request.contextPath }/resources/img/course.png" alt="2021_1"
		style="display:block; margin: 0 auto;
		 width:500px; height :1000px; margin-bottom:10px";>
		 
	<sf:form method="post"
		action="${pageContext.request.contextPath}/docreate"
		modelAttribute="course">
		<table class="formtable">
			<tr>
				<td></td>
				<td><input class="control" type="hidden" name="year" value="2021"></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="control" type="hidden" name="semester" value="1"></td>
			</tr>
			<tr>
				<td class="label">과목명 :</td>
				<td>
					<sf:input class="control" type="text" path="coursename"/><br>
					<sf:errors path="coursename" class="error"/>
				</td>
			</tr>
			<tr>
				<td class="label">과목구분 :</td>
				<td>
					<sf:input class="control" type="text" path="classification"/><br>
					<sf:errors path="classification" class="error"/>
				</td>
			</tr>
			<tr>
				<td class="label">교수명:</td>
				<td>
					<sf:input class="control" type="text" path="professor"/><br>
					<sf:errors path="professor" class="error"/>
				</td>
			</tr>
			<tr>
				<td class="label">학점 :</td>
				<td>
					<sf:input class="control" type="text" path="credit"/><br>
					<sf:errors path="credit" class="error"/>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="수강신청"></td>
			</tr>
		</table>
	</sf:form>
	<a href="${pageContext.request.contextPath}/menu">메뉴로 돌아가기</a><br>
	<a href="${pageContext.request.contextPath}/signLookup?year=2021&semester=1">수강신청 조회</a>
</body>
</html>