<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 정보 수정</title>
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

#idCheckLabels, #updateLabels, #idCheckFields, #updateFields {
    display: inline-block;
}

#inputContainer, #resultContainer {
    padding: 60px;
}

#idCheckLabels, #updateLabels {
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

textarea {
    resize: none;
    border: 2px solid rgba(0, 0, 0, 0.8);
}


#idCheckButtons, #updateButtons {
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

:disabled {
    background-color: #DCDCDC;
}
</style>
</head>
<body>
    <h1>회원정보수정</h1>
    <form action="UserControl" method="post" autocomplete="off">
        <div id="inputContainer">
            <div id="idCheckLabels">
                <label for="updateTargetId">ID</label>
            </div>
            <div id="idCheckFields">
                <input type="text" name="updateTargetId" id="updateTargetId" class="fields" autofocus>
            </div>
            <div id="idCheckButtons">
                <button class="button" name="btn" value="idCheckBtn">확인</button>
                <button class="button" type="button" onclick="location.href='index.jsp';">취소</button>
            </div>
        </div>
        <c:forEach var="list" items="${updateList}">
        <div id="resultContainer">
            <div id="updateLabels">
                <label for="updateId">ID</label><br><br>
                <label for="updatePwd">비밀번호</label><br><br>
                <label for="updateName">이름</label><br><br>
                <label for="updateAddress">주소</label><br><br>
                <label for="updateBirth">생년월일</label><br><br>
                <label for="updatePhone">휴대전화번호</label><br><br>
                <label for="updateEmail">이메일</label>
            </div>
            <div id="updateFields">
                <input type="text" name="updateId" id="updateId" class="fields" value="${list.getId()}" readonly><br><br>
                <input type="password" name="updatePwd" id="updatePwd" class="fields" value="${list.getPassword()}" required><br><br>
                <input type="text" name="updateName" id="updateName" class="fields" value="${list.getName()}" disabled><br><br>
                <textarea name="updateAddress" id="updateAddress" cols="30" rows="2" required>${list.getAddress()}</textarea><br><br>
                <input type="date" name="updateBirth" id="updateBirth" class="fields" value="${list.getBirth()}" disabled><br><br>
                <input type="tel" pattern="[0]{1}[1]{1}[0]{1}-[0-9]{4}-[0-9]{4}" name="updatePhone" id="updatePhone" class="fields" placeholder="010-XXXX-XXXX" value="${list.getPhoneNumber()}"><br><br>
                <input type="email" name="updateEmail" id="updateEmail" class="fields" value="${list.geteMail()}">
            </div>
            <div id="updateButtons">
                <button class="button" name="btn" value="updateBtn">수정</button>
            </div>
        </div>
        </c:forEach>
    </form>
</body>
</html>