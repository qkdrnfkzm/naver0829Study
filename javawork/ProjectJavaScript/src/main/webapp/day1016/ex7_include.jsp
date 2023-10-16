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
	<h5>include : 다른 파일의 실행 결과를 현재파일에 포함시킨다</h5>
	<h5>구구단</h5>
	<jsp:include page="../day1013/ex3_gugudan.jsp"></jsp:include>
	<hr />
	<h5>ShopList</h5>
	<jsp:include page="../day1013/ex4_shop_list.jsp"></jsp:include>
</body>
</html>