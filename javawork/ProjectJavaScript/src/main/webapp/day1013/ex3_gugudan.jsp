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

table.tb thead tr th {
	text-align: center;
	background-color: orange;
	color: blue;
}

table.tb tbody tr td {
	text-align: center;
}
</style>
</head>
<body>
	<table class="table table-bordered tb">
		<thead>
			<tr>
				<%
				for (int dan = 2; dan <= 9; dan++) {
				%>
				<th><%=dan%>단</th>
				<%
				}
				%>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 1; i <= 9; i++) {
			%>
			<tr>
				<%
				for (int dan = 2; dan <= 9; dan++) {
				%>
				<td><%=dan%> X <%=i%> = <%=dan * i%></td>
				<%
				}
				%>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

</body>
</html>