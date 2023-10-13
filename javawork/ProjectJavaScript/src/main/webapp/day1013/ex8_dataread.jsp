<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link
	href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Inter&family=Jua&family=Nanum+Pen+Script&family=REM&family=Single+Day&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
body * {
	font-family: " Jua";
}
</style>
</head>
<%
request.setCharacterEncoding("utf-8");
String name = request.getParameter("name");
String hp1 = request.getParameter("hp1");
String hp2 = request.getParameter("hp2");
String tcolor = request.getParameter("tcolor");
String bcolor = request.getParameter("bcolor");
int java = 0;
int jsp = 0;
int spring = 0;
try {
	java = Integer.parseInt(request.getParameter("java"));
	jsp = Integer.parseInt(request.getParameter("jsp"));
	spring = Integer.parseInt(request.getParameter("spring"));

} catch (NumberFormatException e) {
	java = 0;
	jsp = 0;
	spring = 0;
}
%>
<body>
<div style="background-color: <%=bcolor%>; color: <%=tcolor %>; width:250px; height:200px; padding:20px; margin:50px;" >
이름 : <%=name %><br>
핸드폰 : <%=hp1 %> - <%=hp2 %>
java : <%=java %>점<br>
jsp : <%=jsp %>점<br>
spring : <%=spring %>점<br>
총점 : <%=java+jsp+spring %>점<br>
평균 : <%=(double)((java+jsp+spring)/3.0) %>점<br>
</div>
</body>
</html>