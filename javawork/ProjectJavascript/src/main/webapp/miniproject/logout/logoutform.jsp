<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그아웃</title>
    <link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
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
        <h4><%= loginid %>님이 로그인을 하였습니다</h4>
        <!-- 로그인 페이지의 버튼 스타일을 그대로 사용 -->
	<button type="button" class="form-wrapper form button" style="width:100px; margin-left:20px;" onclick="location.href='logoutaction.jsp'">로그아웃</button>
    </div>
</body>
</html>