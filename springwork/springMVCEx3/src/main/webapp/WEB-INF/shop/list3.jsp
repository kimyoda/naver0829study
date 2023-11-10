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
   body * {
       font-family: 'Jua';
   }
    .photo {
   	width:200px;
   	height: 300px;
   	padding: 10px;
   	border: 2px solid gray;
   	border-radius: 30px;
   	box-shadow: 3px 3px 3px gray;
   	float: left;
   	margin:10px;
   }
  
   .photo img {
   	width:160px;
   	height: 180px;
   	border-radius: 30px;
   }
 
  
</style>
</head>
<!-- 강사님 코드
	<h2>이름 : ${name}</h2>
	<h3>주소 : ${addr}</h3>
	<br>
	<c:forEach var="f" items="${food}">
	  <img src="../../photo/${f}" width="200" height="200" border="3">
	</c:forEach>
	
 -->
<body>
	<h3 class="alert alert-info">내가 매일 먹는 음식ㅠ.ㅠ</h3>
	<hr>
	<c:forEach var="dto" items = "${list}">
		<div class="photo">
			<figure>
				<img src="../../photo/${dto.photo}">
				<figcaption>
					<h5>${dto.name}</h5>
					<h6>${dto.addr}</h6>	
				</figcaption>
			</figure>
		</div>
	</c:forEach>
</body>
</html>