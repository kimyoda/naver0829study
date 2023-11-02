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
	Cookie []cookies = request.getCookies();
	boolean find = false;
	if (cookies!=null) {
		for (Cookie ck:cookies) {
			// 저장된 쿠키 이름을 얻기
			String name = ck.getName();
			if(name.equals("loginok")) {
				find = true; // 해당 쿠키가 존재하면 true;
			}
		}
	}
%>
<body>
<%
	if (!find) {%>
		<script type = "text/javascript">
			alert("먼저 로그인을 해주세요");
			history.back();
		</script>
	<%} else {%>
	<pre style="width:500px;">
펜싱 국가대표 출신 남현희 씨의 펜싱학원과 함께 전청조 씨도 또 다른 펜싱학원을 운영한 사실이 드러난 가운데, 이 학원이 학부모들로부터 수억원을 뜯어냈다는 의혹을 받고 있다.

2일 JTBC 보도에 따르면, 전청조가 운영한 학원 수강료는 남현희 씨 이름의 통장으로 받아왔고 남 씨가 직접 학부모들에게 레슨을 권하기도 했다.

전청조는 '매널'이라는 펜싱학원을 운영해 고위층만을 수강생으로 받는다고 홍보했다. 매널의 수강료는 월 200만 원에 달하는 것으로 알려졌다.

보도에 따르면 남현희는 직접 학부모에게 이 매널의 고급 레슨을 받으라며 등록을 권한 것으로 알려졌다. 수강료 이체 내역을 확인한 결과 매널은 '남현희 펜싱 아카데미'보다 수십만원 더 비싼 월 200만원을 받은 것으로 나타났다.

남현희는 매체에 매널에 대한 질문에 아무 입장도 밝히지 않았다.
	</pre>
	<br><br>
	<a href="loginmain.jsp">메인페이지로 이동</a>
	<%}
%>
</body>
</html>