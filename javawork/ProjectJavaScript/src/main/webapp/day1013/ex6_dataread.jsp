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
//post 방식의 한글 엔코딩
request.setCharacterEncoding("utf-8");
//post 방식의 폼데이터 읽기
String irum = request.getParameter("irum");
String license = request.getParameter("license");
String gender = request.getParameter("gender");
String home = request.getParameter("home");
%>
<body>
	<pre style="font-size: 2em">
	이름 : <%=irum%>
	운전면허 : <%=license == null ? "무면허" : "1종"%>
	성별 : <%=gender%>
	거주지 : <%=home%>
	</pre>

</body>
</html>