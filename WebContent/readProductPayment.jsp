<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@page import ="java.util.List" %>
<%@page import ="model.*" %>  
<%@page import ="common.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ǰ �Ǹ� ���� ��ȸ</title>
<style>
	.t2{
		font-size:30px;
	}
</style>
</head>
<body>
    <div class="title">
    	<h1>�Ұ��������� ���հ����ý���</h1>
		<h2>��ǰ �Ǹ� ���� ���� ��ȸ</h2>
    </div>
    	<input type="button" name="back" value="�ڷΰ���" onclick="location.href='readProductPackage.jsp'">
    <table width="700" border="3" bordercolor="lightgray" align="center">
		<thead>
			<tr>
				<td>��ǰ��Ű����</td>
	            <td>������ ���̵�</td>
	            <td>����</td>
	            <td>�Ǹ�����</td>
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
			<td>�� �ǸŽ���  :  </td>
			<td><%=total %></td>
		</tr>
	</table>
    
</body>
</html>