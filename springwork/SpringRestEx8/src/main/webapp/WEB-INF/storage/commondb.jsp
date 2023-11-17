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
  
</style>
<script type="text/javascript">
	$(function() {
	  list();
	  $("#upload").change(function() {
	    	 let form = new FormData();
	    	 form.append("upload", $("#upload")[0].files[0]); // 선택한 1개의 파일만 추가(무조건 배열만)
	    	 
	    	 /*
	    	 processData: false => 서버에 전달하는 데이타는 querry string이라는 형태로 전달된다
	    	 파일전송의 경우 이를 하지 ㅇ낳아야 하는데 그 설정이 false,
	    	 contentType: false : enctype이 원래 기본값이 application/x-ww.... 이거인데
	    	 multipart/form-data로 변경해준다
	    	 */
	    	 $.ajax({
	    		 type:"post",
	    	 	 dataType:"text",
	    	 	 url:"./addphoto",
	    	 	 processData: false,
	    	 	 contentType: false,
	    	 	 data:form,
	    	 	 success:function(res){
	    	 		//alert(res);
	    	 		$(".photo80").attr("src",res);
	    	 	 }
	    	 });		  
	  });
	  
	  $("#btnsend").click(function() {
		  
	  });
	});

	function list() {
		
	}
</script>
</head>
<body>
	<h4>스트로지에 사진 올리기</h4>
	<div class = "input-group" style = "width: 600px;">
		<input type="text" id="title" style = "width: 200px;" class = "form-control" placeholder = "제목넣기">
		<input type="file" id="upload" style = "width: 200px;" class = "form-control">
		<button type = "button" id = "btnsend">서버전송</button>
	</div>
	80x80 사진만 확인 : <img src="" class="photo80">
	<div class = "list" style = "margin: 20px;">목록</div>
</body>
</html>