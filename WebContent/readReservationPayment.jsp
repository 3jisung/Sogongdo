<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="common.PaymentDAO" %>
<%@page import="model.ReservationPayment" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>readReservationPayment</title>
</head>
<body>
<div>
    <h1>결제 내역 조회</h1>
    <button onclick="window.location.href='insertReservationID_P.jsp'">이전</button>
    <table width="700" border="3" bordercolor="lightgray" align="center">
        <thead>
        <tr>
            <td>아이디</td>
            <td>결제일</td>
            <td>예약 번호</td>
            <td>금액</td>
        </tr>
        </thead>
        <%
            PaymentDAO paymentDAO = new PaymentDAO();
            List<ReservationPayment> list = paymentDAO.readPayment();
            for (ReservationPayment reservationPayment : list) {
                pageContext.setAttribute("reservationPayment", reservationPayment);
        %>
        <tr>
            <td>${reservationPayment.getUser_id()}</td>
            <td>${reservationPayment.getSaleDate()}</td>
            <td>${reservationPayment.getReservation_id()}</td>
            <td>${reservationPayment.getFee()}</td>
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
</div>
</body>
</html>