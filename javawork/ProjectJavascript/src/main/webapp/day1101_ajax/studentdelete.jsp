<%@page import="student.data.StudentDao"%>
<%@page import="student.data.StudentDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// num
	String num = request.getParameter("num");

	// dao
	StudentDao dao = new StudentDao();
	
	// delete
	dao.deleteStudent(num);
%>