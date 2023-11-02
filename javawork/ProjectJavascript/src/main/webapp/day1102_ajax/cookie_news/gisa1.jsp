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
	국민의힘이 당론으로 추진하는 김포시의 서울 편입을 놓고 전문가 사이에서 기대와 우려가 교차하고 있다.

주민 불편 해소와 비용 절감 등 긍정적인 효과를 낼 것이라는 찬성 의견이 있는 반면 절차나 부작용을 제대로 검토하지 않고 편입을 추진한다는 비판도 나오고 있다.

홍준현 중앙대 공공인재학부 교수는 2일 연합뉴스와 통화에서 "김포시의 서울 편입은 서울시 25개 자치구와 경기도 31개 시·군에 모두 큰 영향을 미친다"며 "김포시민의 의견이라면서 추진하는 것은 맞지 않는다"고 지적했다.

홍 교수는 "김포가 자치구가 되면 읍·면을 둘 수 없게 돼 농어촌 주민들에 대한 특례가 사라지고 지방교부세와 세수도 줄어들게 된다"며 "수행 사무와 공무원 수도 줄여야 하는데 이런 부분이 제대로 검토됐는지도 의문"이라고 질문했다.
	</pre>
	<br><br>
	<a href="loginmain.jsp">메인페이지로 이동</a>
	<%}
%>
</body>
</html>