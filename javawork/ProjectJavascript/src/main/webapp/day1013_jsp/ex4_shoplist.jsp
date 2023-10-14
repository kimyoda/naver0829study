<%@page import="java.util.Vector"%>
<%@page import="data.ShopDto"%>
<%@page import="java.util.List"%>
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
<style>
	body * {
		font-family: 'Jua'
	}
	
 	div.box{
        width: 50px;
        height: 50px;
        border: 1px solid black;
    }
    
    img.photo{
    	width: 80px;
    	height: 100px;
    	border: 1px solid black;
    }
</style>
</head>
<body>
<%
	List<ShopDto> list = new Vector<>();
	list.add(new ShopDto("플렛슈즈", "14", "green", 8000));
	list.add(new ShopDto("보석머리띠", "30", "purple", 23000));
	list.add(new ShopDto("머리끈", "26", "red", 15000));
	list.add(new ShopDto("뿌띠스카프", "10", "magenta", 59000));
	list.add(new ShopDto("화이트자켓", "31", "black", 23000));
%>
<table class="tabel table-border" stlye="width:600px;">
	<tr>
		<th width=50>번호</th>
		<th width=150>상품명</th>
		<th width=100>가격</th>
		<th width=100>사진</th>
		<th>색상</th>
	</tr>
	<%
		int n=0;
		for (ShopDto dto:list) {
			%>
			<tr>
				<td><%=++n%></td>
				<td><%=dto.getSangpum() %></td>
				<td><%=dto.getPrice() %>원</td>
				<td aligen=center>
				<img class="photo" src="../shop/<%=dto.getPhoto()%>.jpg"></td>
				<td align=center>
				<div class="box" style="background-color: <%=dto.getColor()%>"></div>
				</td>
			</tr>
			<% 
		}
	%>
	
</table>
</body>
</html>