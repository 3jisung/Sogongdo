<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>��ǰ ��Ű�� ����</title>
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
		<h2>��ǰ��Ű�� ����</h2>
    </div>
    <form method="GET" action="productPackageController" name="updateProduct">
    	<input type="hidden" name="menu" value="2">
        <fieldset class="f1">
            <legend>��ǰ ��Ű�� ����</legend>
            <br>
            <div>
                	���� ��ǰ�� <input type="text" name="name" required> <br>
					������ ��ǰ�� <input type="text" name="newname" required> <br>
                	���� <input type="text" name="newprice" required>
            </div>
            <br>
        </fieldset>
    </form>
    <div>
        <input type="button" name="update" value="����" onclick="update()">
        <input type="button" name="back" value="�ڷΰ���" onclick="location.href='readProductPackage.jsp'">
    </div>

	<script>
		function update() {
			var isValid = document.updateProduct;
			if (isValid.name.value=='') {
				alert("��ǰ��Ű������ �Է��ϼ���");
				isValid.name.focus();
			}
			else if (isValid.newname.value=='') {
				alert("������ ��ǰ���� �Է��ϼ���");
				isValid.newname.focus();
			}
			else if (isValid.newprice.value=='') {
				alert("����� �Է��ϼ���");
				isValid.newprice.focus();
			}
			else {
				alert(" ��ǰ��Ű���� �����Ͽ����ϴ�");
				isValid.submit();
			}
			
		}
	</script>
</body>
</html>