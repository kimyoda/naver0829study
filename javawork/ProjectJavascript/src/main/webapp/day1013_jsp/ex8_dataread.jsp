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
	//post 방식은 일단 한글 엔코딩부터
	request.setCharacterEncoding("utf-8");
	
	// 선택을 안할경우 null 값을 반환
	// 선택을 할경우에만 문자열배열값을 반환
	String nameBox = request.getParameter("nameBox");
	String java = request.getParameter("java");
	String jsp = request.getParameter("jsp");
	String spring = request.getParameter("spring");
	String hp1 = request.getParameter("hp1");
	String hp2 = request.getParameter("hp2");
	String tcolor =request.getParameter("tcolor");
	String bcolor =request.getParameter("bcolor");

	// 점수 계산
	int sum=0;
	double avg=0;
	try {
	sum=Integer.parseInt(java)+Integer.parseInt(jsp)+Integer.parseInt(spring);
	avg=sum/3.0;
	} catch(NumberFormatException e) {
		sum=0;
		avg=0;
	}
%>
<body>
<div style="font-size: 22px;background-color: <%=bcolor %>;color:<%=tcolor%>;width:300px">
	<!-- 삼항연산자 적극활용  -->
	이름 : <%=nameBox %>
	핸드폰 : <%=hp1 %>-<%=hp2 %><br>
	java 점수 : <%=java%>점<br>
	jsp 점수 : <%=jsp%>점<br>
	spring 점수 : <%=spring%>점<br>
	총 점 : <%=sum%>점<br>
	평 균 : <%=avg%>점<br>

	
	
</div>
</body>
</html>