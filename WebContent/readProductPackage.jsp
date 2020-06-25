<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@page import ="java.util.List" %>
<%@page import ="model.*" %>  
<%@page import ="common.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>상품 패키지 조회</title>
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
		<h1>소공도 관광지 통합관리시스템</h1>
		<h2>상품패키지 조회</h2>
	</div>
	<table width="700" border="3" bordercolor="lightgray" align="center">
		<thead>
			<tr>
				<td>상품패키지명</td>
				<td>가격</td>
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
		<legend>관리자</legend>
		<input type="button" name="readProductPayment" value="상품 판매 실적 집계 조회" onclick="location.href='readProductPayment.jsp'">
		
		<form method="GET" action="productPackageController" name="createPP">
			<input type="hidden" name="menu" value="1">
			상품패키지 신규등록 : <input type="button" name="create" value="등록" onclick="location.href='/createProductPackage.jsp'">	
		</form>
		
		<form method="GET" action="productPackageController" name="updatePP">
			<input type="hidden" name="menu" value="2">
			상품패키지 수정 : <input type="button" name="update" value="수정" onclick="location.href='/updateProductPackage.jsp'">
		</form>
		
		<form method="GET" action="productPackageController" name="deletePP">
			<input type="hidden" name="menu" value="3">
			삭제할 상품패키지명 : <input type="text" name = "pname">
			<input type="button" name ="delete" value="삭제" onclick="deleteProductPackage()">
		</form>
	</fieldset>
	<fieldset class="f2">
		<legend>고객</legend>
		<form method="GET" action="productPackageController" name="paymentPP">
		<input type="hidden" name="menu" value="4">
			구매할 상품패키지명 : <input type="text" name ="pname">
			<input type="number" name="quantity">
			<input type ="button" name="buy" value="구매" onclick="createProductPayment()">
		</form>
	</fieldset>
	
	<script>
		
		function deleteProductPackage() {
			var va = document.deletePP;
			if (va.pname.value=='') {
				alert("삭제할 상품패키지명을 입력하세요");
				va.pname.focus();
			}
			else {
				alert("삭제되었습니다");
				va.submit();
			}
		}
		
		
		function createProductPayment() {
			var va = document.paymentPP;
			if (va.pname=="") {
				alert("구매할 상품패키지명을 입력하세요");
				va.pname.focus();
			}
			else if (va.quantity==""){
				alert("수량을 입력하세요");
				va.quantity.focus();
			}
			else {
				alert("구매되었습니다");
				va.submit();
			}
		}
		
	</script>
</body>
</html>