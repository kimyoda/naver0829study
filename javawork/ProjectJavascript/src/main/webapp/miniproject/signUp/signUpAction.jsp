<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 아이디와 비번을 읽는다
	String loginid = request.getParameter("id");
	String loginpass = request.getParameter("loginpass");
	String saveid = request.getParameter("saveid"); // 체크를 안할경우 null
	String name = request.getParameter("name");
	System.out.println("loginid " + loginid);
	System.out.println("loginpass " + loginpass);
	System.out.println("name " + name);
%>