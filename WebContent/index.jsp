<%--
  Created by IntelliJ IDEA.
  User: lunaoeu
  Date: 2020-06-26
  Time: 오전 2:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SoGong</title>
	<style>
		table {
			width: 100%;
			border: 1px solid #444444;
			border-collapse: collapse;
			text-align: center;
		}
		th, td {
			border: 1px solid #444444;
		}
	</style>
</head>
<body>
<header><a href="logIn.jsp">로그인</a> | <a href="logOut.jsp">로그아웃</a></header>
<h1>소공도 통합관리 시스템</h1>
	<c:if test="${sessionId ne null}">
		<p>환영합니다 "${sessionId}" 님.</p>
	</c:if>
	<c:if test="${createResult eq true}">
		<script>
 			alert("등록완료.");
	    </script>
	</c:if>
	<c:if test="${deleteResult eq true}">
		<script>
 			alert("삭제완료.");
	    </script>
	</c:if>
	<c:if test="${updateResult eq true}">
		<script>
 			alert("수정완료.");
	    </script>
	</c:if>
	<ul>
		<li style="list-style: none">메뉴</li>
		<li><a href="createUser.jsp">회원정보등록</a></li>
		<li><a href="updateUser.jsp">회원정보수정</a></li>
		<li><a href="deleteUser.jsp">회원정보삭제</a></li>
		<li><a href="readUser.jsp">회원정보조회</a></li>
		<li><a href="Authority.jsp">권한 관리</a></li>
		<li><a href="settlement.jsp">정산 관리</a></li>
		<li><a href="reservation.jsp">예약 관리</a></li>
		<li><a href="Facility.jsp">시설 관리</a></li>
		<li><a href="workplaceMain.jsp">사업장 관리</a></li>
		<li></li>
		<li></li>
	</ul>

</body>
</html>
