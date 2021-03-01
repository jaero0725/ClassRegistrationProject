<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>종합정보시스템</title>
</head>
<body>
	<!-- 기존 -->
	<p>
		<a href="${pageContext.request.contextPath}/courses"> 학기별 이수 학점 조회</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/sign"> 수강신청 하기 </a>
	</p>
	<p>
		<a
			href="${pageContext.request.contextPath}/signLookup?year=2021&semester=1">수강신청
			조회</a>
	</p>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<a href="javascript:document.getElementById('logout').submit()">Logout</a>
	</c:if>

	<form id="logout" action="<c:url value="/logout" />" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>


</body>
</html>