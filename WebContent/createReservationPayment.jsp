<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>createReservationPayment</title>

    <style>
        form > div {
            margin-bottom: 30px;
        }
    </style>
</head>
<body>
<h1>결제 내역 등록</h1>
<form method="GET" action="PaymentControl" name="createPayment">
    <input type='hidden' name="paymentMenu" value="2">
    <%
        String reservationID = (String) request.getAttribute("reservationID");
        pageContext.setAttribute("reservationID", reservationID);
    %>
    <input type='hidden' name="reservationID" value='${reservationID}'>
    <div>
        <label>결제 금액 : </label>
        <input type="text" name="fee" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" required/>
        <!-- <input type="text" name="account" required> -->
    </div>
    <div>
        <input type="button" value="등록" onclick="create()">
        <input type="button" value="취소" onclick="location.href='/insertReservationID_P.jsp'">
    </div>
</form>
<script>
    function create() {
        var f = document.createPayment;

        if (f.fee.value == '') {
            alert("결제금액을 입력하세요!!");
            f.price.focus();
        } else if (f.fee.value == 0) {
            alert("0 보다 큰 값을 입력하세요!!");
            f.price.focus();
        } else {
            f.submit();
        }
    }
</script>
</body>
</html>