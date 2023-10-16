<%@page import="java.text.SimpleDateFormat"%>
<%@page import="myshop.data.MyShopDto"%>
<%@page import="myshop.data.MyShopDao"%>
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
	font-family: "Jua";
}

img.photo {
	position: absolute;
	left: 400px;
	top: 70px;
	width: 200px;
	border: 5px groove orange;
}
</style>
<%
String num = request.getParameter("num");
//dao 선언
MyShopDao dao = new MyShopDao();
//dto 얻기
MyShopDto dto = dao.getSangpums(num);
%>
</head>
<body>
<form action="./myshopupdate.jsp" method="post">
	<!-- hidden 값 : 브라우저에 보이지는 않지만 폼전달 시 반드시 같이 넘겨야 하는 경우
	hidden으로 주는데 form 안에 어디에 있던 상관 없다(주로 상단에 넣음) -->
	<input type="hidden" name="num" value="<%=dto.getNum()%>">
	<table class="table table-bordered" style="width: 300px; margin: 30px 100px;">
		<caption align="top"><b>상품 등록</b></caption>
		<tr>
			<td align="center" width="100">상품명</td>
			<td><input type="text" name="sangpum" class="form-control" required="required" autofocus="autofocus" value="<%=dto.getSangpum() %>" /></td>
		</tr>
		<tr>
			<td align="center" width="100">사진선택</td>
			<td>
				<select name="photo" id="photo" class="form-select">
				<%
				//현재 num값의 getPhoto()의 확장자 지우고 파일명만 획득
				int n = Integer.parseInt(dto.getPhoto().substring(0,dto.getPhoto().indexOf(".")));
				for ( int i = 1; i <= 34 ; i++ ) { 
				%>
					<option value="<%=i%>.<%=i==24?"gif":"jpg" %>" <%=i==n?"selected":"" %>>상품 <%=i %></option>
				<%} %>
				</select>
				<script type="text/javascript">
					//select로 사진 선택 시 .photo의 사진 변경
					$("#photo").change(function(){
						$(".photo").attr("src","../shop/"+$(this).val());
					})
				</script>
			</td>
		</tr>
		<tr>
			<td align="center" width="100">색 상</td>
			<td><input type="color" name="color" class="form-control" value="<%=dto.getColor()%>"/></td>
		</tr>
		<tr>
			<td align="center" width="100">가 격</td>
			<td><input type="number" name="price" class="form-control" required="required" step="500" min="1000" max="100000" value="<%=dto.getPrice()%>"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<button type="submit">DB수정</button>
			<button type="button" onclick="history.back()">이전으로</button>
			</td>
		</tr>
	</table>
</form>
<img src="../shop/<%=dto.getPhoto() %>" class="photo" alt="" />

</body>
</html>