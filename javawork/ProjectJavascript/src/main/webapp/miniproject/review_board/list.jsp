<%@page import="simpleboard.AnswerBoardDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="simpleboard.SimpleBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="simpleboard.SimpleBoardDao"%>
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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
	body * {
		font-family: 'Jua'
	}
	
	a:link{/*초기 a 링크에 적용*/
		text-decoration: none;
		color: black;
	}
	a:visited {/*한번이라도 클릭한 글에만 적용*/
		text-decoration: none;
		color: gray;
    }
    a:hover {/*a태그에 마우스를 올렸을 때*/
    	text-decoration: underline;
    	color: blue;
    }
    
    .photoicon {
    	font-size: 0.8em;
    	color: gray;
    }
</style>
</head>
<%
	// dao 선언
	SimpleBoardDao dao = new SimpleBoardDao();
	// 전체 데이터 가져오기
	List<SimpleBoardDto> list = dao.getAlllist();
	// 날짜 형식
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
	// 댓글 dao 선언
	AnswerBoardDao adao = new AnswerBoardDao();
%>
<body>
<%
	// 세션에서 loginid 가져오기
	String loginid = (String)session.getAttribute("loginid");

	if (loginid != null) {
	%>
    <div class="wrapper">
      <!-- "00님이 로그인 중입니다" 메시지 표시 -->
      <h4><%=loginid %>님이 로그인 중입니다.</h4>
      <!-- 로그아웃 버튼 -->
      <form action="../login/loginmain.jsp" method="post">
      	<button type="submit" class="form-wrapper form button">로그아웃</button>
      </form>
    </div>
	<%
	} else {
    // 로그인이 안 된 경우에 대한 처리
	%>
    <div class="wrapper">
        <!-- 로그인 버튼 또는 로그인 관련 내용 표시 -->
        <h4>로그인하세요</h4>
        <a href="login.jsp">로그인</a>
    </div>
	<%
	}
	%>
<div style="margin: 30px 50px;">
	<button type="button" class="btn btn-success btn-sm" onclick="location.href='boardform.jsp'">글쓰기</button>
	<br>
	<h5><b>총 <%=list.size() %>개의 게시글이 있습니다</b></h5>
	<br>
	<table class="table table-striped" style="width:600px;">
		<thead>
			<tr>
				<th width="50">번호</th>
				<th width="300">제목</th>
				<th width="80">작성자</th>
				<th width="100">작성일</th>
				<th width="70">조회</th>
			</tr>
		</thead>
		<tbody>
		<%
		if(list.size()==0) {%>
			<tr height="50">
				<td colspan="5" align="center">
					<h5>등록된 글이 없습니다</h5>
				</td>
			</tr>	
		<%} else {
			 int n = 0;
			 for (SimpleBoardDto dto:list) {
				 
				 // 댓글 갯수 가져오기
				 int acount = adao.getBoardAnswers(dto.getNum()).size();
				 // dto에 저장
				 dto.setAnswercount(acount);
			%>	
				<tr align = "center">
					<td><%=list.size()-n++ %></td>
					<td align="left">
						<a href="content.jsp?num=<%=dto.getNum() %>">
							<%=dto.getSubject() %>
							<%
							if (!dto.getPhoto().equals("no")) {%>
								<i class="bi bi-image photoicon"></i>
							<%}
							
							if (acount > 0) {%>
								&nbsp;
								<span style = "color: red">(<%=dto.getAnswercount()%>)</span> 
							<%}
							%>
						</a>
					</td>
					<td><%=dto.getWriter() %></td>
					<td><%=sdf.format(dto.getWriteday()) %></td>
					<td><%=dto.getReadcount() %></td>
				</tr> 
			 <%}
		}
		%>
		</tbody>
	</table>
</div>
</body>
</html>