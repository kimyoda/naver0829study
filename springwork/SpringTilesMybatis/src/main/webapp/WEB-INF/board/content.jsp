
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
<script type="text/javascript">
	$(function(){
	  list(); // 처음 로딩 시 댓글 출력
		// 댓글 카메라 클릭시 파일 업로드 버튼 실행
		$(".uploadcamera").click(function() {
			$("#upload").trigger("click");
		});
		
		// 사진 업로드
		$("#upload").change(function() {
			
			let formData = new FormData();
			formData.append("upload", $("#upload")[0].files[0]);
			$.ajax({
				type : "post",
				dataType : "json",
				url : "../answer/upload",
				data:formData,
				processData : false,
				contentType : false,
				success : function(res) {
					// 업로드 후에 반환받은 파일명을 댓글의 이미지에 넣어준다
					$("img.answerphoto").attr("src", "../res/upload/" + res.photoname);
				}
			});
		});
		
		// 댓글 추가 이벤트
		$("#btnansweradd").click(function() {
			
			let msg = $("#answermsg").val();
			let num = ${dto.num};
			if (msg.length == 0) {
				alert("댓글 내용을 입력해주세요");
				return;
			}
			// alert(msg + ":" + num);
			$.ajax({
				type:"post",
				dataType: "text",
				url: "../answer/insert",
				data:{"num" : num, "msg" : msg},
				success: function(res) {
					// db insert 성공 후 댓글 목록 다시 출력
					list();
					// 입력 창 초기화
					$("#answermsg").val("");
					// 댓글 사진 초기화
					$("img.answerphoto").attr("src","../res/photo/noimage.png");
					
					
				}
			});
		});
		
		// 댓글 삭제 이벤트
		$(document).on("click", ".ansdel", function(){
			let ansidx = $(this).attr("ansidx");
			$.ajax({
				type :"get",
				dataType : "text",
				url : "../answer/delete",
				data : {"ansidx" : ansidx},
				success: function(res) {
					list(); // 삭제 후 목록 다시 출력
				}
			});			
		});
	}); // close function
	
// 댓글 출력
function list () {
	
	let num = ${dto.num};
	
	let loginok='${sessionScope.loginok}';
	let loginid='${sessionScope.myid}';
		// 댓글 출력하는 일반함수
	$.ajax({
		type:"get",
		dataType: "json",
		url: "../answer/list",
		data:{"num":num},
		success: function(res) {
			$("#answercount").text("댓글" + res.length);
			
			let s = "";
			$.each(res, function(idx, item){
				s +=
					`
					\${item.ansname}(\${item.ansid})<br>
					`;
				if (item.ansphoto!=null) {
					s += 
						`
						<img src = "../res/upload/\${item.ansphoto}" width = 60 height = 60 border = 1 haspce = 20
						>
						`;
				}
				
				s +=
					`<span style = "margin-left:20px;">\${item.ansmsg}</span>
					&nbsp;
					<span style = "color:gray;font-size;0.9em;">\${item.writeday}</span>
					`;
				if (loginok!='' && item.ansid == loginid) {
					s +=
						`<i class = "bi bi-trash ansdel" ansidx = "\${item.ansidx}"></i>`;
				} 
					
					s +="<br>";
			});
			
			$("div.answerlist").html(s);
		}
	  });		
	}
	
</script>
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
		<div id = "answercount">댓글 0</div>
		<div class="answerlist" style = "margin-left: 10px;">
			댓글목록 나올 곳
		</div>
		<c:if test = "${sessionScope.loginok!=null}">
			<div class = "answerform input-group" style = "width: 600px;"> 
				<input type = "file" id = "upload" style = "display: none;">
				<i class = "bi bi-camera uploadcamera" style = "cursor: pointer;font-size: 23px;"></i>
				<img src = "" class = "answerphoto" width = "50" height = "50" border = "1" onerror = "this.src='../res/photo/noimage.png'" 
				hspace = "10">
				
				<input type = "text" class = "form-control" style = "width: 300px;" placeholder = "댓글내용" id = "answermsg">
				<button type="button" class = "btn-sm btn btn-outline-success" id = "btnansweradd">저장</button>
			</div>
		</c:if>
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