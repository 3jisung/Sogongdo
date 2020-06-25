<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
    <%@ page import = "model.Authority" %>
<%@ page import="common.AuthorityDAO" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>소공도 통합관리시스템 - 권한관리</title>
</head>
<body>
	<form method="post" action="AuthorityCreate.jsp">
		<fieldset>
			<legend>생성</legend>
			<div>
				<label>대상</label>
				<select name = "target">
					<option selected disabled hidden>선택해주세요</option>
					<option value="user">사용자</option>
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
		<input type="text" name="tableName" id="tableName">
		<button onclick="window.location.href='Authority.jsp?tableName='+getTableName()">확인</button>
		<script type="text/javascript">
			function getTableName(){
				return document.getElementById("tableName").value
			}
		</script>
		<table width="700" border="3" bordercolor="lightgray" align="center">
			<thead>
			<tr>
				<td><b>target</b></td>
				<td><b>action</b></td>
			</tr>
			</thead>
			<%
				String tablename = request.getParameter("tableName");
				if(tablename == null)
					tablename = "";

				List<Authority> list = AuthorityDAO.INSTANCE.readAuthorities(tablename);
				for (Authority authority : list) {
					pageContext.setAttribute("authority", authority);
			%>
			<tr>
				<td>${authority.getTarget()}</td>
				<td>${authority.getAction()}</td>
			</tr>
			<%}%>

			<%-- 		<c:forEach var="dto" items="${boardDto}" begin="0" end="2">
                        <tr>
                            <td>${dto.id}</td>
                            <td>${dto.title}</td>
                            <td>${dto.writer}</td>
                            <td>${dto.contents}</td>
                            <td>${dto.regdate}</td>
                            <td>${dto.hit}</td>
                        </tr>
                    </c:forEach> --%>

		</table>
		
	</fieldset>
	
	<form method="post" action="AuthorityUpdate.jsp">
		<fieldset>
			<legend>권한 수정</legend>

			<label>기존 대상</label>
			<select name = "originTarget">
				<option selected disabled hidden>선택해주세요</option>
				<option value="user">사용자</option>
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
					<option value="user">사용자</option>
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
			<input type="submit" value="확인">
		</fieldset>
	</form>

	<form method="post" action="AuthorityDelete.jsp">
		<fieldset>
			<legend>삭제</legend>
			<div>
				<label>대상</label>
				<select name = "target">
					<option selected disabled hidden>선택해주세요</option>
					<option value="user">사용자</option>
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
			<input type="submit" value="확인">
		</fieldset>
	</form>
</body>

</html>