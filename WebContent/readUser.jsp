<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ���� ��ȸ</title>
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
	font-family: "���� ���", "����";
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
    display: inline-block;
}

#readLabels, #readFields {
    display: inline-block;
}

#inputContainer {
    padding: 60px;
}

#resultContainer {
    padding: 60px;
}

#readLabels {
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

#resultTable {
    border: 2px solid rgba(0, 0, 0, 0.8);
}

#readButtons {
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

th {
    width: 150px;
}
</style>
</head>
<body>
    <h1>ȸ��������ȸ</h1>
    <form action="UserControl" method="get" autocomplete="off">
        <div id="inputContainer">
            <div id="readLabels">
                <label for="readId">ID</label>
            </div>
            <div id="readFields">
                <input type="text" name="readId" id="readId" class="fields" autofocus>
            </div>
            <div id="readButtons">
                <button class="button" name="btn" value="readBtn">��ȸ</button>
                <button class="button" type="button" onclick="location.href='index.jsp';">���</button>
            </div>
        </div>
    </form>
	<div id="resultContainer">
    	<table border="1">
        	<tr>
               	<th>ID</th>
               	<th>��й�ȣ</th>
                <th>�̸�</th>
                <th>�ּ�</th>
                <th>�������</th>
                <th>�������</th>
                <th>��ȭ��ȣ</th>
                <th>�̸���</th>
            </tr>
            <c:forEach var="list" items="${readList}">
            <tr>
            	<td>${list.getId()}</td>
            	<td>${list.getPassword()}</td>
            	<td>${list.getName()}</td>
            	<td>${list.getAddress()}</td>
            	<td>${list.getBirth()}</td>
            	<td>${list.getRegistryDate()}</td>
            	<td>${list.getPhoneNumber()}</td>
            	<td>${list.geteMail()}</td>
            </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>