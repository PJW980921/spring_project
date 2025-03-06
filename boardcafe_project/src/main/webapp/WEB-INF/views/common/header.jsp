<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<div class="header-auth">
	<div class="sign-in">
		<a href="/signin">로그인</a>
	</div>
	<div class="sign-up">
		<a href="/signup">회원가입</a>
	</div>
</div>
</header>
</body>
</html>