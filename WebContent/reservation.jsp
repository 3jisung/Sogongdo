<%@page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Reservation</title>
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
    min-width: 100px;
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
		<h2 style="margin-bottom: -0.05rem;">Accommodation Reservation Registration</h2>
		<small>click the submit then you can pay the payment and finally register</small>
		
		<!-- 결제화면으로 넘어가야 한다 -->
		<form method="post" action="reservationRegister.jsp">
			<table style="margin-top: 10px;">
				<tr>
					<th>MY ID</th>
					<th><input type="text" id="userID"></input> </th>
				</tr>
				<tr>
					<th>facility</th>
					<th><input type="text" name="facility"></th>
				</tr>
				<tr>
					<th>start date</th>
					<th><input type="date" name="startDate"></th>
				</tr>
				<tr>
					<th>end date</th>
					<th><input type="date" name="endDate"></th>
				</tr>
				<tr>
					<th>people</th>
					<th><input type="num" name="people"></th>
				</tr>
				<tr>
					<th>payment</th>
					<th><input type="text" value="0" readonly style="text-align: center;" id="payment"></th>
				</tr>
			</table>
			<br>
			<button>pay</button>
			<p> ${param.message} </p>
		</form>
	</div>
	
	<hr width="80%" color="lightgray" noshade/>

	<div align="center">
		<h2 align="center" style="margin-bottom: -0.05rem;">Reservation List</h2>
		<small align="center">You can click the ID to cancel and edit the Registaration and also you can see the reservation histroy</small>
		<table border="3" bordercolor="lightgray" style="margin-bottom: 100px;">
			<thead>
				<tr>
					<td>registerID</td>
					<td>userID</td>
					<td>facilityID</td>
					<td>paymentID</td>
					<td>start date</td>
					<td>end date</td>
					<td>people</td>
					<td>register date</td>
					<td>cancel date</td>
				</tr>
			</thead>
			<c:forEach var="dto" items="${reservationList}">
				<c:url value="/reservationDetail.jsp" var="url">
				 		<c:param name="id" value="${dto.id}" />
				 		<c:param name="userID" value="${dto.userID}" />
				 		<c:param name="facilityID" value="${dto.facilityID}" />
				 		<c:param name="paymentID" value="${dto.paymentID}" />
				 		<c:param name="startDate" value="${dto.startDate}" />
				 		<c:param name="endDate" value="${dto.endDate}" />
				 		<c:param name="people" value="${dto.people}" />
				 		<c:param name="registerDate" value="${dto.registerDate}" />
				 		<c:param name="cancelDate" value="${dto.cancelDate}" />
				</c:url>
				<tr>
					<td onclick="location.href='${url}'" style="cursor:pointer">
						${dto.id}
					</td>
					<td>${dto.userID}</td>
					<td>${dto.facilityID}</td>
					<td>${dto.paymentID}</td>
					<td>${dto.startDate}</td>
					<td>${dto.endDate}</td>
					<td>${dto.people}</td>
					<td>${dto.registerDate}</td>
					<td>${dto.cancelDate}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>