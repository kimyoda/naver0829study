<%@page import="review_board.ReviewBoardDto"%>
<%@page import="review_board.ReviewBoardDao"%>
<%@page import="org.apache.catalina.valves.RemoteIpValve"%>
<%@page import="simpleboard.SimpleBoardDto"%>
<%@page import="simpleboard.SimpleBoardDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MultipartRequest multipartRequest = null;
	
	String realPath = getServletContext().getRealPath("/save");
	System.out.println("path="+realPath);
	int uploadSize = 1024*1024*5; //5mb
	try {
		multipartRequest = new MultipartRequest(request, realPath, uploadSize, "utf-8", new DefaultFileRenamePolicy());
		// dao, dto 선언
		ReviewBoardDao dao = new ReviewBoardDao();
		ReviewBoardDto dto = new ReviewBoardDto();
		
		// 데이타 읽기(파일 포함)
		String num = multipartRequest.getParameter("num");
		String id = multipartRequest.getParameter("id");
		String write_id = multipartRequest.getParameter("write_id");
		String title = multipartRequest.getParameter("title");
		String content = multipartRequest.getParameter("content");
		String view_cnt = multipartRequest.getParameter("view_cnt");
		String delete_yn = multipartRequest.getParameter("delete_yn");
		
		
		// 업로드된 실제 파일명, 업로드 안했을 경우 null
		String photo = multipartRequest.getFilesystemName("upload");
		
		
		dto.setId(Integer.parseInt(id)); // id을 정수로 변환하여 설정
		dto.setWriter_id(id); // id를 writer로 설정
		dto.setTitle(title); // title을 subject로 설정
		dto.setContent(content);
		//dto.setPhoto(photo); // 사진 수정안했을 경우 null값이 들어간다

		dao.updateBoard(dto);
		
		// content.jsp로 이동(content는 num을 필요로 한다)
		response.sendRedirect("content.jsp?num="+num);
	} catch(Exception e) {
		out.print("<h3>파일 업로드 오류 발생:" +e.getMessage()+"</h3>");
	}
%>