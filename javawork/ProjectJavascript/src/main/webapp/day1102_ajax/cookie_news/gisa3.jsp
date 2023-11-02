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
지현 전 더불어민주당 비상대책위원장은 2일 내년 총선서 서울 송파구에 출마하겠다고 밝혔다.

박 전 비대위원장은 이날 공보 성격을 띠는 메신저를 통해 "비대위원장 시절 지역 곳곳을 돌며 만났던 시민 분들과 약속했다"며 "정치를 바로잡고 소외된 분들의 목소리를 더 듣겠다고 했다"고 말했다.

이어 "총선을 앞두고 긴 시간 고민이 많았지만 한 가지는 분명했다. 정치가 있어야 할 자리에 있을 때까지 정치를 할 거라는 제 소명"이라고 전했다.

박 전 비대위원장은 지역구 고민이 많았다며 세 가지 기준을 세웠다고 했다. 그 기준은 △민주당 확장에 도움되는 곳 △윤석열 정권의 교만함에 철퇴를 내린다는 의미를 줄 수 있는 곳 △기꺼이 변화를 선택해 줄 주민이 있는 곳이라고 밝혔다.

박 전 비대위원장은 "(세 가지 기준에 적합한 곳이) 송파라고 생각했다"고 설명했다
	</pre>
	<br><br>
	<a href="loginmain.jsp">메인페이지로 이동</a>
	<%}
%>
</body>
</html>