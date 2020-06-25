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
</head>
<body>
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
	<a href="logIn.jsp">로그인</a>
	<a href="logOut.jsp">로그아웃</a>
	<a href="createUser.jsp">회원정보등록</a>
	<a href="updateUser.jsp">회원정보수정</a>
	<a href="deleteUser.jsp">회원정보삭제</a>
	<a href="readUser.jsp">회원정보조회</a>
</body>
</html>
