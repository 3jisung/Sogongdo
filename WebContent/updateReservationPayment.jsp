<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>updateReservationPayment</title>

    <style>
        form > div {
            margin-bottom: 30px;
        }
    </style>
</head>
<body>
<h1>결제 내역 수정/삭제</h1>
<form method="GET" action="PaymentControl" name="updatePayment">
    <input type='hidden' name="paymentMenu" value="3">
    <%--     	<% Payment payment = (Payment) request.getAttribute("payment");
            pageContext.setAttribute("id", payment.getUserID());

            String type = payment.getType();

            if(type.equals("현금"))
                pageContext.setAttribute("type", 0);
            else if(type.equals("카드"))
                pageContext.setAttribute("type", 1);
            else if(type.equals("계좌이체"))
                pageContext.setAttribute("type", 2);

            pageContext.setAttribute("price", payment.getPrice());
            pageContext.setAttribute("paymentID", payment.getPaymentID());
            %> --%>
    <%
        String reservationID = (String) request.getAttribute("reservation");
        pageContext.setAttribute("reservationID", reservationID);
        int fee = (int) request.getAttribute("fee");
        pageContext.setAttribute("fee", fee);
    %>
    <input type='hidden' name="reservationID" value='${reservationID}'>
    <div>
        <label>결제 금액 : </label>
        <input type="text" name="fee" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"
               value='${fee}' required/>
        <!-- <input type="text" name="account" required> -->
    </div>
    <div>
        <input type="button" value="수정" onclick="update()">
        <input type="button" value="취소" onclick="location.href='/insertReservationID_P.jsp'">
    </div>
</form>
<script>
    function update() {
        var f = document.updatePayment;

        if (f.fee.value == '') {
            alert("결제금액을 입력하세요!!");
            f.price.focus();
        } else {
            f.submit();
        }
    }
</script>
</body>
</html>