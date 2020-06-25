<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import = "model.Authority" %>
    <%@ page import = "java.util.ArrayList" %>
<%@ page import="common.AuthorityDAO" %>
<%@ page import="java.util.List" %>
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

	<fieldset>
		<legend>권한 조회</legend>
		<label>조회할 테이블</label>
		<input type="text" name="tableName">
		<button onclick="window.location.href='Authority.jsp?tableName=<%=request.getParameter("tableName")%>'">조회</button>
		<table width="700" border="3" bordercolor="lightgray" align="center">
			<thead>
			<tr>
				<td>대상</td>
				<td>행위</td>
			</tr>
			</thead>
			<%
				String tableName = "";
				List<Authority> list = AuthorityDAO.INSTANCE.readAuthorities(tableName);
				for (Authority authorities : list) {
					pageContext.setAttribute("authority", authorities);
			%>
			<tr>
				<td>${authority.getTarget()}</td>
				<td>${authority.getAction()}</td>
			</tr>
			<%}%>
		</table>
		
	</fieldset>
	
	<form action="updateAuthority">
		<fieldset>
			<legend>권한 수정</legend>

			<label>기존 대상</label>
			<select name = "originTarget">
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
				<label>기존 행위</label>
				<select name = "originAction">
					<option selected disabled hidden>선택해주세요</option>
					<option value="create">등록</option>
					<option value="update">수정</option>
					<option value="delete">삭제</option>
					<option value="read">조회</option>
				</select>
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
				<select name = "action">
					<option selected disabled hidden>선택해주세요</option>
					<option value="create">등록</option>
					<option value="update">수정</option>
					<option value="delete">삭제</option>
					<option value="read">조회</option>
				</select>
			</div>
			<button>확인</button>
		</fieldset>
	</form>
	
	<form action="deleteAuthority">
		<fieldset>
			<legend>삭제</legend>
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
				<select name = "action">
					<option selected disabled hidden>선택해주세요</option>
					<option value="create">등록</option>
					<option value="update">수정</option>
					<option value="delete">삭제</option>
					<option value="read">조회</option>
				</select>
			</div>
			</div>
			<button>확인</button>
		</fieldset>
	</form>
</body>

</html>