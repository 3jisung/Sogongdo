<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 정보 삭제</title>
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

#deleteLabels, #deleteFields {
    display: inline-block;
}

#deleteLabels {
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

#deleteButtons {
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
	<c:if test="${deleteResult eq false}">
		<script>
 			alert("존재하지 않는 ID입니다.");
	    </script>
	</c:if>
    <h1>회원정보삭제</h1>
    <form action="UserControl" method="post" autocomplete="off">
        <div id="deleteLabels">
            <label for="deleteId">ID</label>
        </div>
        <div id="deleteFields">
            <input type="text" name="deleteId" id="deleteId" class="fields" autofocus required>
        </div>
        <div id="deleteButtons">
            <button class="button" name="btn" value="deleteBtn">삭제</button>
            <button class="button" type="button" onclick="location.href='index.jsp';">취소</button>
          </div>
    </form>
</body>
</html>