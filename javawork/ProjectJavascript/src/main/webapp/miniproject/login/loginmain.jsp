<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>loginPage</title>
	<link
		href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap"
		rel="stylesheet">
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
		rel="stylesheet">
	<link href="../styles/style.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
</head>
	<%
	// 로그인 상태인지 세션값을 얻는다
	String loginok = (String) session.getAttribute("loginok");
	%>
	<body>
		<div class="wrapper">
			<%
			if (loginok == null) {
			%>
			<jsp:include page="loginform.jsp" />
			<br>
			<br>
			<h3>
				<b></b>
			</h3>
		<%
		} else {
		%>
		<jsp:include page="../login/loginform.jsp" />
		<br>
		<br> <img src="main_page.png">
		<%
		}
		%>
	</div>
</body>
</html>