<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="simpleboard.SimpleBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="simpleboard.SimpleBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	SimpleBoardDao dao = new SimpleBoardDao();
	List<SimpleBoardDto> list = dao.getAlllist();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	JSONArray arr = new JSONArray();
	for(SimpleBoardDto dto:list) {
		JSONObject ob = new JSONObject();
		ob.put("num", dto.getNum());
		ob.put("writer", dto.getWriter());
		ob.put("subject", dto.getSubject());
		ob.put("content", dto.getContent());
		ob.put("photo", dto.getPhoto());
		ob.put("readcount", dto.getReadcount());
		ob.put("writeday", sdf.format(dto.getWriteday()));
		
		arr.add(ob);
	}
%>
<%=arr.toString()%>