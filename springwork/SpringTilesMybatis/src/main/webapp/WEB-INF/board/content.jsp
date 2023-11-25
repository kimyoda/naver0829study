
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
	body * {
		font-family: 'Jua';
	}
	
	span.day {
		font-size: 11px;
		color: gray;
		margin-left: 20px;
	}
	
	.grid {
		display: flex;
		justify-content: space-around;
	}
	
	.grid img {
		width: 200px;
		height: 200px;
	}
</style>
</head>
<body>
	<div>
		<h3>
			<b>${dto.subject}</b>
		</h3>
		<br> <img src="../res/upload/${profile_photo}"
			class="rounded-circle" border="1" hspace="10" align="left" width="50"
			height="50" onerror="this.src='../res/photo/noimage.png"> <b>${dto.writer}</b><br>
		<span class="day"> <fmt:formatDate value="${dto.writeday}"
				pattern="yyyy-MM-dd HH:mm" /> &nbsp;&nbsp; 조회 ${dto.readcount}
		</span> <br>
		<br>
		<pre style="font-size: 17px;">${dto.content}</pre>
		<br>
		<br>
		<div class="grid" style="width: 800px;">
      <c:if test="${dto.photocount>0}">
         <c:forEach var="photo" items="${dto.photoNames}">
            <div>
            <img src="../res/upload/${photo}">
            </div>
            <br><br>
         </c:forEach>
      </c:if>
      </div>
      </div>
	<div>
	<br>
		<button type="button" class="btn btn-outline-secondary btn-sm"
			style="width: 80px;" onclick="location.href='./form'">글쓰기</button>
		<button type="button" class="btn btn-outline-secondary btn-sm"
			style="width: 80px;"
			onclick="location.href='./form?num=${dto.num}&regroup=${dto.regroup}&restep=${dto.restep}&relevel=${dto.relevel}&currentPage=${currentPage}'">
			답글 쓰기</button>
		<button type="button" class="btn btn-outline-secondary btn-sm"
			style="width: 80px;"
			onclick="location.href='./list?currentPage=${currentPage}'">목록</button>
		
		<!-- 로그인한 사람이 쓴 글에만 수정,삭제 버튼이 보이도록 한다 -->
		<c:if test="${sessionScope.loginok!=null and dto.myid==sessionScope.myid}">
			<button type="button" class="btn btn-outline-secondary btn-sm"
			style="width: 80px;"
				onclick="location.href='./updateform?num=${dto.num}&currentPage=${currentPage}'">수정</button>
				
			<button type="button" class="btn btn-outline-secondary btn-sm"
			style="width: 80px;"
				onclick="location.href='./delete?num=${dto.num}&currentPage=${currentPage}'">삭제</button>
		</c:if>
	</div>
</body>
</html>