<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/signin" method="post" id="authForm">
<h2 id="signInTitlte">로그인</h2>
<input type="hidden" name="_csrf" value="${_csrf.token}"/>	
	<div id="inputBox">
		<label for="username">아이디 </label>
		<input id="username" type="text" name="username" required/>	
	</div>
		<div id="inputBox">
		<label for="password">비밀번호 </label>
		<input id="password" type="password" name="password" required/>	
	</div>
		
		<button id="signInBtn" type="submit">로그인</button>
		<a id="signUpHref" href="/signup">회원가입</a>
	
</form>
</body>
</html>