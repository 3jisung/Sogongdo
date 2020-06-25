<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인</title>
<style>
html, body, div, span, applet, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
a, abbr, acronym, address, big, cite, code,
del, dfn, em, img, ins, kbd, q, s, samp,
small, strike, strong, sub, sup, tt, var,
b, u, i, center,
dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
caption, article, aside, canvas, details, embed, 
figure, figcaption, footer, header, hgroup, 
menu, nav, output, ruby, section, summary,
time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline;
}
	
/* HTML5 display-role reset for older browsers */
article, aside, details, figcaption, figure, 
footer, header, hgroup, menu, nav, section {
	display: block;
}

body {
	font-family: "맑은 고딕", "돋움";
    text-align: center;
	line-height: 1;
}
	
h1 {
    margin: 50px;
    font-size: 70px;
    font-weight: bold;
}
	
ol, ul {
	list-style: none;
}

blockquote, q {
	quotes: none;
}

blockquote:before, blockquote:after,
q:before, q:after {
	content: '';
	content: none;
}

table {
    border-collapse: collapse;
    border-spacing: 0;
}

#logInLabels, #logInFields {
    display: inline-block;
}
	
#logInLabels {
    text-align: center;
    font-size: 24px;
    font-weight: bold;
    margin-bottom: 45px;
}
	
label {
    padding: 0 20px;
}
	
.fields {
    all: unset;
    width: 200px;
    height: 30px;
    border: 2px solid rgba(0, 0, 0, 0.8);
}
	
/* LogIn, Cancel button CSS */

#logInbuttons {
    margin: 15px;
    text-align: center;
}
	
.button {
    all:unset;
    cursor: pointer;
    padding: 5px;
    border: 2px solid rgba(0, 0, 0, 0.8);
    border-radius: 4px;
    font-size: 20px;
    font-weight: bold;
    width: 70px;
    text-align: center;
}
	
.button:active {
    transform: scale(0.98);
}
</style>
</head>
<body>
 	<c:if test="${sessionId ne null}">
 		<script>
 			alert("이미 로그인 중입니다.");
	    	location.href='index.jsp';
	    </script>
	</c:if>
	<c:if test="${logInResult eq false}">
		<script>
 			alert("ID 또는 비밀번호가 다릅니다.");
	    </script>
	</c:if>
	<h1>로그인</h1>
    <form action="UserControl" method="post" autocomplete="off">
    	<div id="logInLabels">
            <label for="logInId">ID</label><br><br>
            <label for="logInPwd">비밀번호</label>
        </div>
        <div id="logInFields">
            <input type="text" name="logInId" id="logInId" class="fields" autofocus required><br><br>
            <input type="password" name="logInPwd" id="logInPwd" class="fields" required>
        </div>
        <div id="logInbuttons">
          <button class="button" name="btn" value="logInBtn">로그인</button>
          <button class="button" type="button" onclick="location.href='index.jsp';">취소</button>
        </div>
    </form>
</body>
</html>