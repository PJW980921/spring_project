<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="_csrf" content="${ _csrf.token}">
<meta name="_csrf_header" content="${ _csrf.headerName}">
<title>Insert title here</title>
</head>

<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %> <!-- header  -->
<main class="main-container">	
<div class="menu-admin">
	<h2 class="announcement">공지사항</h2>
	<c:if test="${MANAGER == true}">
		<button type="button" onClick="location.href=`${pageContext.request.contextPath}/noticeAdd`">
			작성
		</button>
	</c:if>
	
		<div class="menu-list">
		
		</div>
		</div>
</main>
<%@ include file="/WEB-INF/views/common/footer.jsp" %> <!-- footer  -->

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/script.js }"></script>
</body>
</html>