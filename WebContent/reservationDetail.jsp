<%@page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Reservation Detail</title>
</head>

<style>
a{
    text-decoration: none;
}
li{
    list-style: none;
}
input{
	text-align: center;
}
button{
	min-width: 60px
}
table td{
    min-width: 120px;
    text-align: center;
}
table th{
    min-width: 150px;
    text-align: left;
}
</style>


<body>
	<div align="center">
		<h1 style="margin-bottom: -0.04rem;"> SoGongDo Management System </h1>
		<small>COPYRIGHT(C) Kumoh National Institute of Technology. All Rights Reserved. TEL : (054) 478-7540  FAX : (054) 478-7319</small>
	</div>
	
	<hr width="80%" color="lightgray" noshade />
	
	<div align="center">
		<h2>Reservation State</h2>
		<table>
			<tr>
				<th>Reservation ID</th>
				<th> <span id="ReservationID">${param.id}</span> </th>
			</tr>
			<tr>
				<th>User ID</th>
				<th> <input type="text" id="userID" value="${param.userID}"></th>
			</tr>
			<tr>
				<th>Facility ID</th>
				<th><input type="text" id="facility" value="${param.facilityID}"></th>
			</tr>
			<tr>
				<th>Payment ID</th>
				<th><input type="text" readonly style="text-align: center;" id="paymentID" value="${param.paymentID}"></th>
			</tr>
			<tr>
				<th>Start date</th>
				<th><input type="date" id="startDate" value="${param.startDate}"></th>
			</tr>
			<tr>
				<th>End date</th>
				<th><input type="date" id="endDate" value="${param.endDate}"></th>
			</tr>
			<tr>
				<th>People</th>
				<th><input type="number" id="people" value="${param.people}"></th>
			</tr>
			<tr>
				<th>Register date</th>
				<th><input type="date" id="registDate" value="${param.registerDate}" readonly></th>
			</tr>
			<tr>
				<th>Cancel date</th>
				<th><input type="date" value="${param.cancelDate}" readonly></th>
			</tr>
		</table>		
		<br>
		<button onclick="updateReservation()">Edit</button>
		<button onclick="deleteReservation()">Delete</button>
		<script type="text/javascript">
			String reservationID = (String) document.getElementById("ReservationID").innerHTML;
			pageContext.setAttribute("reservationID", reservationID);
			
			function updateReservation(){
				String startDate = document.getElementById("startDate").value;
				String endDate = document.getElementById("endDate").value;
				String people = document.getElementById("people").value;
				String registDate = document.getElementById("registDate").value;
				ReservationDAO rd = new ReservationDAO();
				rd.updateReservation(reservationID, startDate, endDate, people, registDate);
			}
			function deleteReservation(){
				ReservationDAO rd = new ReservationDAO();
				rd.deleteReservation(reservationID);
				location.herf("/reservation");
			}
		</script>
	</div>
	
	<hr width="80%" color="lightgray" noshade style="margin-top: 2rem"/>
	
	<div align="center" style="margin-bottom: 100px;">
		<h2 align="center" style="margin-bottom: -0.05rem;">Cancel Reservation</h2>
		<small>If the reservation is not canceled, the cancel date value is empty</small>
		<table style="margin-top: 1rem">
			<tr>
				<th>Cancel date</th>
				<th><input type="date" id="cancelDate" value="${param.cancelDate}"></th>
			</tr>
		</table>
		<br>
		<tr>
			<button onclick="updateCancel()">Edit the cancel</button>
			<button onclick="cancelCancel()">Cancel the cancel</button>
			<button onclick="deleteCancel()">Delete the cancel</button>
		</tr>
		<script type="text/javascript">
			function updateCancel(){
				String cancelDate = document.getElementById("cancelDate").value;
				ReservationDAO rd = new ReservationDAO();
				rd.updateReservationCancel(reservationID, cancelDate);
			}
			function cancelCancel(){
				deleteCancel();
				document.getElementById("cancelDate").value = "";
			}
			function deleteCancel(){
				ReservationDAO rd = new ReservationDAO();
				rd.deleteReservationCancel(reservationID);
				document.getElementById("cancelDate").value = "";
			}
		</script>
		<br> Cancel the cancel and Delete the cancel mean make cancelDate column empty
	</div>
</body>
</html>