<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그아웃</title>
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

#logOutbuttons {
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
    width: 90px;
    text-align: center;
}

.button:active {
    transform: scale(0.98);
}
</style>
</head>
<body>
 	<c:if test="${sessionId eq null}">
 		<script>
 			alert("로그인 하십시오.");
	    	location.href='index.jsp';
	    </script>
	</c:if>
	<h1>로그아웃 하시겠습니까?</h1>
    <form action="UserControl" method="post">
        <div id="logOutbuttons">
          <button class="button" name="btn" value="logOutBtn">로그아웃</button>
          <button class="button" type="button" onclick="location.href='index.jsp';">취소</button>
        </div>
    </form>
</body>
</html>