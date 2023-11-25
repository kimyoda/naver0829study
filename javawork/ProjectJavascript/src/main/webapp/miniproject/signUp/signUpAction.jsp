<%@page import="user_info.UserInfoDto"%>
<%@page import="user_info.UserInfoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("utf-8");


    String id = request.getParameter("id");
    String password = request.getParameter("loginpass"); // 비밀번호
    String name = request.getParameter("name");
    String gender = request.getParameter("gender"); // 성별
    String nickname = request.getParameter("nickname");
    String address = request.getParameter("address");
    String email = request.getParameter("email");
    String phone = request.getParameter("phoneNumber"); // 핸드폰 번호
    String jumin = request.getParameter("rsdnt_rgnmb");

    UserInfoDto dto = new UserInfoDto();
    dto.setId(id);
    dto.setPassword(password);
    dto.setName(name);
    dto.setGender(gender);
    dto.setNickname(nickname);
    dto.setAddress(address);
    dto.setEmail(email);
    dto.setPhone(phone);
    dto.setJumin(jumin);
    
	UserInfoDao dao = new UserInfoDao();
	dao.insertUserInfo(dto);
    // 회원가입이 되면 게시판으로 이동
	response.sendRedirect("../login/loginmain.jsp");
    


%>