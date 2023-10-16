<%@page import="myshop.data.MyShopDto"%>
<%@page import="myshop.data.MyShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
//dao, dto 선언
MyShopDao dao = new MyShopDao();

//입력값을 읽어서 dto에 담기
String num = request.getParameter("num");

//delete 메소드 호출(db저장)
dao.deleteShop(num);

//목록 페이지로 이동(redirect)
response.sendRedirect("myshop.jsp");
%>