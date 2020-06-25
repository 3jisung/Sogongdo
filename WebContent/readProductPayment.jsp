<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@page import ="java.util.List" %>
<%@page import ="model.*" %>  
<%@page import ="common.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>상품 판매 실적 조회</title>
<style>
	.t2{
		font-size:30px;
	}
</style>
</head>
<body>
    <div class="title">
    	<h1>소공도관광지 통합관리시스템</h1>
		<h2>상품 판매 실적 집계 조회</h2>
    </div>
    	<input type="button" name="back" value="뒤로가기" onclick="location.href='readProductPackage.jsp'">
    <table width="700" border="3" bordercolor="lightgray" align="center">
		<thead>
			<tr>
				<td>상품패키지명</td>
	            <td>구매자 아이디</td>
	            <td>개수</td>
	            <td>판매일자</td>
			</tr>
		</thead>
		<%
		int total;
		ProductPaymentDAO pdao = new ProductPaymentDAO();
		List<ProductPayment> list = pdao.read();
		if (list!=null) {
			for (ProductPayment productpayment : list) {
				pageContext.setAttribute("productpayment", productpayment);
			
		%>
		<tr>
			<td>${productpayment.getProductPackage_Name()}</td>
			<td>${productpayment.getUser_id()}</td>
			<td>${productpayment.getQuantity()}</td>
			<td>${productpayment.getSaleDate()}</td>
		</tr>
			<%}}%>
		<%total =  pdao.total();%>
		
	</table>
	<table class="t2">
		<tr>
			<td>총 판매실적  :  </td>
			<td><%=total %></td>
		</tr>
	</table>
    
</body>
</html>