<%@page import="student.data.StudentDao"%>
<%@page import="java.util.List"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="student.data.StudentDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 읽기
	String name = request.getParameter("name");
	String blood = request.getParameter("blood");
	String phone = request.getParameter("phone");
	
	// dao 선언
	StudentDao dao = new StudentDao();
	
	// dto 담기
	List<StudentDto> list = dao.getAllStudent();	
	// 날짜 포멧 지정
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	// 리스트 목록을 JSONArray로 배열 형태로 json으로 구현
	JSONArray arr = new JSONArray();
	
	for (StudentDto dto:list) {
		JSONObject ob = new JSONObject();
		ob.put("num", dto.getNum());
		ob.put("name", dto.getName());
		ob.put("blood", dto.getBlood());
		ob.put("phone", dto.getPhone());
		ob.put("writeday",sdf.format(dto.getWriteday()));
		
		arr.add(ob);
	}
%>
<%=arr.toString() %>