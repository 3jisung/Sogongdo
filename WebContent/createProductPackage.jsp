<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>��ǰ ��Ű�� ���</title>
	<style>
	        .f1{
	            border:3px solid pink; 
	            width:300px;
	        }

	</style>
</head>
<body>
    <div class="title">
        <h1>�Ұ��������� ���հ����ý���</h1>
		<h2>��ǰ��Ű�� ���</h2>
    </div>
    <form method="GET" action="productPackageController" name="createProduct">
    	<input type="hidden" name="menu" value="1">
        <fieldset class="f1">
            <legend>��ǰ ��Ű�� �߰�</legend>
            <br>
            <div>
                <label>��ǰ��</label>
                <input type="text" name="name" required> 
            </div>
            <br>
            <div>
                <label>����</label>
                <input type="text" name="price" required>
            </div>
            <br>
        </fieldset>
    </form>
    <div>
        <input type="button" name="create" value="�߰�" onclick="create()" style="float:none; margin-left:1000px;">
        <input type="button" name="back" value="�ڷΰ���" onclick="location.href='readProductPackage.jsp'" style="float:none; margin-left:1000px;">
    </div>

	<script>
		function create() {
			var isValid = document.createProduct;
			if (isValid.name.value=='') {
				alert("��ǰ��Ű������ �Է��ϼ���");
				isValid.name.focus();
			}
			else if (isValid.price.value=='') {
				alert("����� �Է��ϼ���");
				isValid.price.focus();
			}
			else {
				alert("��ǰ��Ű���� ����Ͽ����ϴ�");
				isValid.submit();
			}
			
			
		}
	</script>
</body>
</html>