<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/header.css"/>
</head>
<body>
<header class="header-container">
	<div class="header-logo">
		<a href="/">Board</a>
	</div>

<c:choose> 
<c:when test="${isAuthenticated != null && isAuthenticated == true }">
<div class="header-auth">
	<div class="sign-in">
		<a href="/logout">로그아웃</a>
	</div>
</div>
</c:when>

<c:otherwise>
<div class="header-auth">
	<div class="sign-in">
		<a href="/signin">로그인</a>
	</div>
	<div class="sign-up">
		<a href="/signup">회원가입</a>
	</div>
</div>
</c:otherwise>
</c:choose>

</header>
</body>
</html>