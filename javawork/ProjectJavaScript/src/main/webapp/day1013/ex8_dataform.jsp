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
<h5>폼 태그 읽기</h5>
<form action="./ex8_dataread.jsp" method="post">
<table class="table table-bordered" style="width: 400px;">
	<tr>
		<th width="100">이름</th>
		<td><input type="text" name="name" class="form-control" required="required" autofocus="autofocus"/></td>
	</tr>
	<tr>
		<th width="100">점수</th>
		<td class="input-group">
			<input type="text" name="java" value="0" step="10" class="form-control"/>
			<input type=""text"" name="jsp" value="0" step="10" class="form-control"/>
			<input type=""text"" name="spring" value="0" step="10" class="form-control"/>
		</td>
	</tr>
	<tr>
		<th width="100">핸드폰</th>
		<td class="input-group">
			<select name="hp1" class="from-select" style="width: 50px">
				<option>010</option>
				<option>02</option>
				<option>031</option>
			</select>
			<input type="text" class="form-control" name="hp2" placeholder="나머지번호입력"/>
		</td>
	</tr>
	<tr>
		<th width="100">색상</th>
		<td class="input-group">
		<b>글자색</b>&nbsp;
			<input type="color" name="tcolor" value="#0000ff" class="form-control"/>
			&nbsp;&nbsp;
		<b>배경색</b>&nbsp;
			<input type="color" name="bcolor" value="#ff77ff" class="form-control"/>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<button type="submit" class="btn btn-outline-danger">서버로 전송</button>
		</td>
	</tr>
</table>

</form>
</body>
</html>