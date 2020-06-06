
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Reservation"%>

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
				<th>MY ID</th>
				<th> <span id="userID">20160375</span> </th>
			</tr>
			<tr>
				<th>Reservation ID</th>
				<th> <span id="userID">11112222</span> </th>
			</tr>
			<tr>
				<th>workplace</th>
				<th><input type="text" id="workplace"></th>
			</tr>
			<tr>
				<th>facility</th>
				<th><input type="text" id="facility"></th>
			</tr>
			<tr>
				<th>date</th>
				<th><input type="text id="date""></th>
			</tr>
			<tr>
				<th>people</th>
				<th><input type="text id="people""></th>
			</tr>
			<tr>
				<th>payment</th>
				<th><input type="text" value="0" readonly style="text-align: center;" id="payment"></th>
			</tr>
		</table>
		<br>
		<button>edit</button>
		<button>cancel the reservation</button>
	</div>
	
	<hr width="80%" color="lightgray" noshade style="margin-top: 2rem"/>
	
	<div align="center">
		<h2 align="center" style="margin-bottom: -0.05rem;">Reservation Histroy</h2>
		<small align="center">You can click the ID to cancel and edit the Registaration</small>
	</div>
	
	<table border="3" bordercolor="lightgray" align="center" style="margin-bottom: 100px;">
		<thead>
			<tr>
				<td>registerID</td>
				<td>register date</td>
				<td>cancel date</td>
			</tr>
		</thead>
		<%
			if(request.getAttribute("reservationList") == null){
				out.println("데이터 request 오류");
				return;
			}
			ArrayList<ReservationDTO> list = (ArrayList<ReservationDTO>) request.getAttribute("reservationList");
			for (ReservationDTO dto : list) {
				pageContext.setAttribute("dto", dto);			
		%>
			<tr>
				<td >${dto.id}</td>
				<td>${dto.userID}</td>
				<td>${dto.workplaceID}</td>
				<td>${dto.facilityID}</td>
				<td>${dto.date}</td>
				<td>${dto.people}</td>
				<td>${dto.payment}</td>
				<td>${dto.cancelDate}</td>
			</tr>
		<%}%>
	</table>
	
</body>

</html>