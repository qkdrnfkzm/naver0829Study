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
<body>
	
	<h3 class="alert alert-danger">ex4_forward 파일</h3>
	<%
	//jsp:param 데이터는 getparameter로 읽는다
	String photo = request.getParameter("photo");
	String msg = request.getParameter("msg");
	%>
	<img src="<%=photo%>" alt="" />
	<h4><%=msg%></h4>
</body>
</html>