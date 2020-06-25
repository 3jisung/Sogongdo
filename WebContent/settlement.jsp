<%@page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Reservation</title>
</head>

<style>
    a {
        text-decoration: none;
    }

    li {
        list-style: none;
    }

    input {
        text-align: center;
    }

    button {
        min-width: 60px
    }

    table td {
        min-width: 120px;
        text-align: center;
    }

    table th {
        min-width: 100px;
        text-align: left;
    }
</style>

<body>
<div align="center">
    <h1 style="margin-bottom: -0.04rem;"> SoGongDo Management System </h1>
    <small>COPYRIGHT(C) Kumoh National Institute of Technology. All Rights Reserved. TEL : (054) 478-7540 FAX : (054)
        478-7319</small>
</div>

<hr width="80%" color="lightgray" noshade/>

<div align="center">
    <h2 style="margin-bottom: -0.05rem;">Settlement Management 정산 관리</h2>
    <small>정산설명 블라블라</small>

    <!-- 결제화면으로 넘어가야 한다 -->
    <form method="post" action="createSettlement.jsp">
        <table style="margin-top: 10px;">
            <tr>
                <th>ID</th>
                <th><input type="text" id="userID"></input></th>
            </tr>
            <tr>
                <th>시설</th>
                <th>
                    <select name="facility">
                        <option>여기서 시설 select 해서 이름 가져와야함</option>
                    </select>
                </th>
            </tr>
            <tr>
                <th>정산일</th>
                <th><input type="date" name="settlement_date"></th>
            </tr>
            <tr>
                <th>정산시간</th>
                <th>
                    <input type="date" name="processed_date">
                    <input type="time" name="processed_time">
                </th>
            </tr>
        </table>
        <br>
        <button>정산</button>
        <button>정산 조회</button>
        <p> ${param.message} </p>
    </form>
</div>

<hr width="80%" color="lightgray" noshade/>

<div align="center">
    <h2 align="center" style="margin-bottom: -0.05rem;">정산 목록</h2>
    <small align="center">id를 클릭해 상세 내역 조회, 수정, 삭제 가능</small>
    <table border="3" bordercolor="lightgray" style="margin-bottom: 100px;">
        <thead>
        <tr>
            <td>시설(사업장)</td>
            <td>정산자</td>
            <td>정산일</td>
            <td>정산시간</td>
        </tr>
        </thead>
        <c:forEach var="dto" items="${reservationList}">
            <c:url value="/readSettlement.jsp" var="url">
                <c:param name="workplace" value="${dto.workplace}"/>
                <c:param name="admin_id" value="${dto.admin_id}"/>
                <c:param name="date" value="${dto.settlement_date}"/>
                <c:param name="time" value="${dto.processed_time}"/>
            </c:url>
            <tr>
                <td onclick="location.href='${url}'" style="cursor:pointer">
                        ${dto.id}
                </td>
                <td>${dto.workplace}</td>
                <td>${dto.admin_id}</td>
                <td>${dto.settlement_date}</td>
                <td>${dto.processed_time}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>