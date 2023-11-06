<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>logout</title>
    <link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <link href="../styles/style.css" rel="stylesheet">
    <style>
        body * {
            font-family: 'Jua';
        }
    </style>
</head>
<%
    // 세션으로부터 저장된 아이디를 얻는다
    String loginid = (String) session.getAttribute("loginid"); // 없을 경우 null
%>
<body>
    <div class="wrapper">
        <h4><%= loginid %>님이 로그인을 하였습니다.</h4>
        <!-- 로그인 페이지의 버튼 스타일을 그대로 사용 -->
        <form action="../login/loginform.jsp" method="post">
        	<button type="submit" class="form-wrapper form button">logout</button>
        </form>
        	<br>
        	<a href="../review_board/list.jsp" class="btn btn-success">게시판으로 이동</a>
     </div>
</body>
</html>