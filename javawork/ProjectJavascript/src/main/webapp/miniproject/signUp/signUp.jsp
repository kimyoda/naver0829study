<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"> 
		<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
		<style>
			body * {
				font-family: 'Jua'
			}
		</style>
	</head>
	<body>
    <div class="w-100 h-100 d-flex justify-content-center">
      <form action ="loginaction.jsp" method="post"> 
        <table class = "table table-bordered" style = "width:300px;border:5px groove gray;">
          <tr>
            <td width=150>
              <input type = "text" class = "form-control" autofocus required placeholder ="아이디" name="loginid" value = "">
            </td>
            <td rowspan="2" width = 100>
              <button type = "submit" style = "width : 100%;height : 100px">회원가입</button>
            </td>
          </tr>
          <tr>
            <td width = 150>
              <input type = "password" class = "form-control" required placeholder ="비밀번호" name="loginpass">
            </td>
          </tr>
          <tr>
            <td width = 150>
              <input type = "password" class = "form-control" required placeholder ="비밀번호 확인" name="checklogin">
            </td>
          <tr>
            <td width = 150>
              <input type = "text" class = "form-control" required placeholder ="이름" name="name">
            </td>
          </tr>
          <tr> 
            <td width = 150>
              <input type = "text" class = "form-control" required placeholder ="주민등록번호" name="rsdnt_rgnmb">
            </td>
          </tr>
          <tr>
            <td width = 150>
              <input type = "text" class = "form-control" required placeholder ="핸드폰번호" name="phoneNumber">
            </td>
          </tr>
          <tr>  
            <td width = 150>
              <input type = "text" class = "form-control" required placeholder ="주소" name="address">
            </td>
          </tr>
          <tr>  
            <td width = 150>
              <input type = "text" class = "form-control" required placeholder ="별명" name="nickname">
            </td>
          </tr>
        </table>
      </form>
    </div>
	</body>
</html>