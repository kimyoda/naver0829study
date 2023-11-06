<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>signUp</title>
    <link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"> 
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <link href="../styles/style.css" rel="stylesheet">
  </head>
  <body>
    <div class="wrapper">
      <div class="form-wrapper">
        <h1>signUp</h1>
	      <form action ="signUpAction.jsp" method="post"> 
	        <input type = "text" class = "form-control" autofocus required placeholder ="아이디" name="id" value = "">
	        <input type = "password" class = "form-control" required placeholder ="비밀번호" name="loginpass">
	        <input type = "password" class = "form-control" required placeholder ="비밀번호 확인" name="checklogin">
	        <input type = "text" class = "form-control" required placeholder ="이름" name="name">
	        <input type = "text" class = "form-control" required placeholder ="주민등록번호" name="rsdnt_rgnmb">
	        <input type = "text" class = "form-control" required placeholder ="핸드폰번호" name="phoneNumber">
	        <input type = "text" class = "form-control" required placeholder ="주소" name="address">
	        <input type = "text" class = "form-control" required placeholder ="이메일" name="email">
	        <input type = "text" class = "form-control" required placeholder ="별명" name="nickname">
	        <button type = "submit">회원가입</button> 
	        <a href="../login/loginform.jsp">로그인페이지로 이동</a>
	      </form>
      </div>
    </div>
  </body>
</html>