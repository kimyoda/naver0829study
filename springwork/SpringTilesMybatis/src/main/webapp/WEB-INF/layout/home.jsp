 <%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
div.main_container div.home {
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    width: 40%;
    height: 40%;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    align-items: flex-start;
}

div.main_container div.home h2 {
    width: 40%;
    text-align: center;
    margin-bottom: 10px;
}

div.main_container div.home img {
    width: 30%; /* 사진 크기를 40%로 축소 */
    height: auto;
    border-radius: 40%;
    object-fit: cover;
    margin-bottom: 3px;
}
</style>

</head>
<c:set var="root" value="<%=request.getContextPath()%>"/>
<body>
 <h2>2023 월즈 T1 우승!</h2>
  <img src = "${root}/res/photo/T1_1.jpg">
  <img src = "${root}/res/photo/T1_2.jpg">
  <img src = "${root}/res/photo/T1_3.jpg">
  <img src = "${root}/res/photo/T1_4.jpeg">

</body>
</html>