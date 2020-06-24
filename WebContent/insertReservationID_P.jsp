<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>insertReservationID</title>

    <style>
        form > div {
            margin-bottom: 30px;
        }
    </style>
</head>
<body>
<h1>결제 관리</h1>
<form method="GET" action="PaymentControl" name="insertReservationID">
    <input type='hidden' name="paymentMenu" value="1">
    <input type='hidden' name="nextMenu" id="nextMenu">
    <div>
        <label>예약 번호 : </label>
        <input type="text" name="reservationID" required>
    </div>
    <div>
        <input type="button" value="결제 등록" onclick="createPayment()">
        <input type="button" value="결제 수정" onclick="updatePayment()">
        <input type="button" value="결제 삭제" onclick="deletePayment()">
        <input type="button" value="취소" onclick="location.href=''">
    </div>
</form>
<script>
    function createPayment() {
        var f = document.insertReservationID;

        if (f.reservationID.value == '') {
            alert("결제번호를 입력하세요!!");
            f.reservationID.focus();
        } else {
            document.getElementById("nextMenu").value = "1";
            f.submit();
        }
    }

    function updatePayment() {
        var f = document.insertReservationID;

        if (f.reservationID.value == '') {
            alert("결제번호를 입력하세요!!");
            f.reservationID.focus();
        } else {
            document.getElementById("nextMenu").value = "2";
            f.submit();
        }
    }

    function deletePayment() {
        var f = document.insertReservationID;

        if (f.reservationID.value == '') {
            alert("결제번호를 입력하세요!!");
            f.reservationID.focus();
        } else {
            document.getElementById("nextMenu").value = "3";
            f.submit();
        }
    }
</script>
</body>
</html>