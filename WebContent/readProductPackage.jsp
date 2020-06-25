<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@page import ="java.util.List" %>
<%@page import ="model.*" %>  
<%@page import ="common.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>��ǰ ��Ű�� ��ȸ</title>
	<style>
		body{
			text-align:center;
		}
		table{
			text-align:left;
		}	
	    table>thead{
	    	background-color : lightgray;
	    }
	</style>
</head>
<body>
	<div class="title">
		<h1>�Ұ��� ������ ���հ����ý���</h1>
		<h2>��ǰ��Ű�� ��ȸ</h2>
	</div>
	<table width="700" border="3" bordercolor="lightgray" align="center">
		<thead>
			<tr>
				<td>��ǰ��Ű����</td>
				<td>����</td>
			</tr>
		</thead>
		<%
			ProductPackageDAO pdao = new ProductPackageDAO();
			List<ProductPackage> list = pdao.read();
		if (list!=null) {
			for (ProductPackage productpackage : list) {
				pageContext.setAttribute("productpackage", productpackage);			
		%>
			<tr>
				<td>${productpackage.getName()}</td>
				<td>${productpackage.getPrice()}</td>
			</tr>
		<%
		}}%>
	</table>
	<fieldset>
		<legend>������</legend>
		<input type="button" name="readProductPayment" value="��ǰ �Ǹ� ���� ���� ��ȸ" onclick="location.href='readProductPayment.jsp'">
		
		<form method="GET" action="productPackageController" name="createPP">
			<input type="hidden" name="menu" value="1">
			��ǰ��Ű�� �űԵ�� : <input type="button" name="create" value="���" onclick="location.href='/createProductPackage.jsp'">	
		</form>
		
		<form method="GET" action="productPackageController" name="updatePP">
			<input type="hidden" name="menu" value="2">
			��ǰ��Ű�� ���� : <input type="button" name="update" value="����" onclick="location.href='/updateProductPackage.jsp'">
		</form>
		
		<form method="GET" action="productPackageController" name="deletePP">
			<input type="hidden" name="menu" value="3">
			������ ��ǰ��Ű���� : <input type="text" name = "pname">
			<input type="button" name ="delete" value="����" onclick="deleteProductPackage()">
		</form>
	</fieldset>
	<fieldset class="f2">
		<legend>��</legend>
		<form method="GET" action="productPackageController" name="paymentPP">
		<input type="hidden" name="menu" value="4">
			������ ��ǰ��Ű���� : <input type="text" name ="pname">
			<input type="number" name="quantity">
			<input type ="button" name="buy" value="����" onclick="createProductPayment()">
		</form>
	</fieldset>
	
	<script>
		
		function deleteProductPackage() {
			var va = document.deletePP;
			if (va.pname.value=='') {
				alert("������ ��ǰ��Ű������ �Է��ϼ���");
				va.pname.focus();
			}
			else {
				alert("�����Ǿ����ϴ�");
				va.submit();
			}
		}
		
		
		function createProductPayment() {
			var va = document.paymentPP;
			if (va.pname=="") {
				alert("������ ��ǰ��Ű������ �Է��ϼ���");
				va.pname.focus();
			}
			else if (va.quantity==""){
				alert("������ �Է��ϼ���");
				va.quantity.focus();
			}
			else {
				alert("���ŵǾ����ϴ�");
				va.submit();
			}
		}
		
	</script>
</body>
</html>