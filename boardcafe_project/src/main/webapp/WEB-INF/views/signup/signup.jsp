<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/signup" method="post" id="authForm">
<h2 id="signInTitlte">회원가입</h2>
	<div id="inputBox">
		<label for="username">아이디 </label>
		<input id="username" type="text" name="username" required/>	
	</div>
		<div id="inputBox">
		<label for="password">비밀번호 </label>
		<input id="password" type="password" name="password" required/>	
	</div>
	<div id="inputBox">
		<label for="writer">작성자 </label>
		<input id="writer" type="text" name="writer" required/>	
	</div>
		<button id="signInBtn" type="submit">회원가입</button>
		<a id="signUpHref" href="/signin">로그인 페이지 이동</a>
	
</form>
</body>
</html>