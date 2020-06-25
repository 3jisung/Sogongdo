<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>상품 패키지 등록</title>
	<style>
	        .f1{
	            border:3px solid pink; 
	            width:300px;
	        }

	</style>
</head>
<body>
    <div class="title">
        <h1>소공도관광지 통합관리시스템</h1>
		<h2>상품패키지 등록</h2>
    </div>
    <form method="GET" action="productPackageController" name="createProduct">
    	<input type="hidden" name="menu" value="1">
        <fieldset class="f1">
            <legend>상품 패키지 추가</legend>
            <br>
            <div>
                <label>상품명</label>
                <input type="text" name="name" required> 
            </div>
            <br>
            <div>
                <label>가격</label>
                <input type="text" name="price" required>
            </div>
            <br>
        </fieldset>
    </form>
    <div>
        <input type="button" name="create" value="추가" onclick="create()" style="float:none; margin-left:1000px;">
        <input type="button" name="back" value="뒤로가기" onclick="location.href='readProductPackage.jsp'" style="float:none; margin-left:1000px;">
    </div>

	<script>
		function create() {
			var isValid = document.createProduct;
			if (isValid.name.value=='') {
				alert("상품패키지명을 입력하세요");
				isValid.name.focus();
			}
			else if (isValid.price.value=='') {
				alert("요금을 입력하세요");
				isValid.price.focus();
			}
			else {
				alert("상품패키지를 등록하였습니다");
				isValid.submit();
			}
			
			
		}
	</script>
</body>
</html>