<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"> 
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
	body * {
		font-family: 'Jua'
	}
</style>
</head>
<%
	// post 방식의 폼데이타 읽기
	request.setCharacterEncoding("utf-8");
	// post 방식의 폼데이타 읽기
	String irum=request.getParameter("irum");
	String lic=request.getParameter("license");
	String gender=request.getParameter("gender");
	String home=request.getParameter("home");
%>
<body>
<pre style="font-size: 2em";>
이름 : <%=irum %>
	<!-- 삼항연산자 적극활용  -->
운전면허 : <%=(lic==null)?"없음":"있음"%>
성별 : <%=gender %>
주거지 : <%=home %>
</pre>
</body>
</html>