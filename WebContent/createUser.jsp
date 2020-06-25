<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
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

#createLabels, #createFields {
    display: inline-block;
}

#createLabels {
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
    height: 27px;
    border: 2px solid rgba(0, 0, 0, 0.8);
}

textarea {
    resize: none;
    border: 2px solid rgba(0, 0, 0, 0.8);
}

#createButtons {
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
<title>회원 정보 등록</title>
</head>
<body>
	<c:if test="${createResult eq false}">
		<script>
 			alert("ID가 중복됩니다.");
	    </script>
	</c:if>
    <h1>회원 정보 등록</h1>
    <form action="UserControl" method="post" autocomplete="off">
        <div id="createLabels">
            <label for="createId">ID</label><br><br>
            <label for="createPwd">비밀번호</label><br><br>
            <label for="createName">이름</label><br><br>
            <label for="createAddress">주소</label><br><br>
            <label for="createBirth">생년월일</label><br><br>
            <label for="createPhone">휴대전화번호</label><br><br>
            <label for="createEmail">이메일</label>
        </div>
        <div id="createFields">
            <input type="text" name="createId" id="createId" class="fields" autofocus required><br><br>
            <input type="password" name="createPwd" id="createPwd" class="fields" required><br><br>
            <input type="text" name="createName" id="createName" class="fields" required><br><br>
            <textarea name="createAddress" id="createAddress" cols="30" rows="2" required></textarea><br><br>
            <input type="date" name="createBirth" id="createBirth" class="fields" required><br><br>
            <input type="tel" pattern="[0]{1}[1]{1}[0]{1}-[0-9]{4}-[0-9]{4}" name="createPhone" id="createPhone" class="fields" placeholder="010-XXXX-XXXX"><br><br>
            <input type="email" name="createEmail" id="createEmail" class="fields">
        </div>
        <div id="createButtons">
            <button class="button" name="btn" value="createBtn">등록</button>
            <button class="button" type="button" onclick="location.href='index.jsp';">취소</button>
        </div>
    </form>
</body>
</html>