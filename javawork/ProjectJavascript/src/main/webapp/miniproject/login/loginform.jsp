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
<link href="../styles/style.css" rel="stylesheet">

</head>
<% 
  // 세션으로부터 아이디와 체크저장값을 얻는다
  String loginid = (String)session.getAttribute("loginid");
  String savestatus = (String)session.getAttribute("savestatus");
  boolean bCheck = false;
  if (savestatus == null || savestatus.equals("no")) {
    bCheck = false; // 체크를 안했을 경우
  } else {
    bCheck = true; // 체크를 했을 경우 
  }
  
  // 체크를 안헀을 경우 아이디를 없앤다
  if (!bCheck) loginid = "";
  
%>
<body>
<div class="form-wrapper">
  <h1>로그인</h1>
  <form action="loginaction.jsp" method="post">
    <input type="text" class="form-control" autofocus required placeholder ="아이디" name="loginid" value = "<%=loginid %>">
    <input type="password" class="form-control" required placeholder ="비밀번호" name="loginpass">
    <button type="submit">로그인</button>
    <a href="../signUp/signUp.jsp">회원가입</a>
  </form>
</div>
</body>
</html>