<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import = "model.Authority" %>
    <%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>소공도 통합관리시스템 - 권한관리</title>
</head>
<body>
	<form action="createAuthority">
		<fieldset>
			<legend>생성</legend>
			<div>
				<label>대상</label>
				<select name = "target">
					<option selected disabled hidden>선택해주세요</option>
					<option value="userInfo">사용자</option>
					<option value="authority">권한</option>
					<option value="workplace">사업장</option>
					<option value="facility">시설</option>
					<option value="reservation">예약</option>
					<option value="package">판매 상품</option>
					<option value="paymentHistory">결제</option>
					<option value="settlement">정산</option>
				</select>
			</div>
			
			<div>
				<label>행위</label>
				<select name="action">
					<option selected disabled hidden>선택해주세요</option>
					<option value="create">등록</option>
					<option value="update">수정</option>
					<option value="delete">삭제</option>
					<option value="read">조회</option>
				</select>
			</div>
			<input type="submit" value="확인">
		</fieldset>
	</form>
	
	<form action="readAuthority">
	<fieldset>
		<legend>권한 조회</legend>
		
 		<tr>
			<td>권한id</td>
			<td>대상정보</td>
			<td>행위</td>
		</tr>
		
	</fieldset>
	</form>>
	
	<form action="updateAuthority">
		<fieldset>
			<legend>권한 수정</legend>
			
			<div>
			<label>권한 id</label>
			<input type="text" name="id">
			</div>
			
			<div>
				<label>대상</label>
				<select name = "target">
					<option selected disabled hidden>선택해주세요</option>
					<option value="userInfo">사용자</option>
					<option value="authority">권한</option>
					<option value="workplace">사업장</option>
					<option value="facility">시설</option>
					<option value="reservation">예약</option>
					<option value="package">판매 상품</option>
					<option value="paymentHistory">결제</option>
					<option value="settlement">정산</option>
				</select>
			</div>
			
			<div>
				<label>행위</label>
				<select name = action>
					<option selected disabled hidden>선택해주세요</option>
					<option value="create">등록</option>
					<option value="read">수정</option>
					<option value="update">삭제</option>
					<option value="delete">조회</option>
				</select>
			</div>
			<button>확인</button>
		</fieldset>
	</form>
	
	<form action="deleteAuthority">
		<fieldset>
			<legend>삭제</legend>
			<div>
			<label>권한 id</label>
			<input type="text" name="id">
			</div>
			<button>확인</button>
		</fieldset>
	</form>
</body>

</html>