<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>상품 패키지 수정</title>
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
		<h2>상품패키지 수정</h2>
    </div>
    <form method="GET" action="productPackageController" name="updateProduct">
    	<input type="hidden" name="menu" value="2">
        <fieldset class="f1">
            <legend>상품 패키지 수정</legend>
            <br>
            <div>
                	기존 상품명 <input type="text" name="name" required> <br>
					수정될 상품명 <input type="text" name="newname" required> <br>
                	가격 <input type="text" name="newprice" required>
            </div>
            <br>
        </fieldset>
    </form>
    <div>
        <input type="button" name="update" value="수정" onclick="update()">
        <input type="button" name="back" value="뒤로가기" onclick="location.href='readProductPackage.jsp'">
    </div>

	<script>
		function update() {
			var isValid = document.updateProduct;
			if (isValid.name.value=='') {
				alert("상품패키지명을 입력하세요");
				isValid.name.focus();
			}
			else if (isValid.newname.value=='') {
				alert("수정될 상품명을 입력하세요");
				isValid.newname.focus();
			}
			else if (isValid.newprice.value=='') {
				alert("요금을 입력하세요");
				isValid.newprice.focus();
			}
			else {
				alert(" 상품패키지를 수정하였습니다");
				isValid.submit();
			}
			
		}
	</script>
</body>
</html>