
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Reservation"%>

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

<%
	String errMsg = (String)request.getAttribute("errMsg");
	if(errMsg == null)
		errMsg="";
%>

<body>
	<div align="center">
		<h1 style="margin-bottom: -0.04rem;"> SoGongDo Management System </h1>
		<small>COPYRIGHT(C) Kumoh National Institute of Technology. All Rights Reserved. TEL : (054) 478-7540  FAX : (054) 478-7319</small>
	</div>
	
	<hr width="80%" color="lightgray" noshade />
	
	<div align="center">
		<h2 style="margin-bottom: -0.05rem;">Accommodation Reservation Registration</h2>
		<small>click the submit then you can pay the payment and finally register</small>
		
		<form method="post" action="reservationRegister.jsp">
			<table style="margin-top: 10px;">
				<tr>
					<th>MY ID</th>
					<th> <span id="userID">20160375</span> </th>
				</tr>
				<tr>
					<th>workplace</th>
					<th><input type="text" name="workplace"></th>
				</tr>
				<tr>
					<th>facility</th>
					<th><input type="text" name="facility"></th>
				</tr>
				<tr>
					<th>date</th>
					<th><input type="text" name="date"></th>
				</tr>
				<tr>
					<th>people</th>
					<th><input type="text" name="people"></th>
				</tr>
				<tr>
					<th>payment</th>
					<th><input type="text" value="0" readonly style="text-align: center;" id="payment"></th>
				</tr>
			</table>
			<br>
			<button>submit</button>
			<p> <%=errMsg %> </p>
		</form>
	</div>
	
	<hr width="80%" color="lightgray" noshade/>
	
	<div align="center">
		<h2 align="center" style="margin-bottom: -0.05rem;">Reservation List</h2>
		<small align="center">You can click the ID to cancel and edit the Registaration and also you can see the reservation histroy</small>
	</div>
	<br>
	<table border="3" bordercolor="lightgray" align="center" style="margin-bottom: 100px;">
		<thead>
			<tr>
				<td>registerID</td>
				<td>userID</td>
				<td>workplaceID</td>
				<td>facilityID</td>
				<td>date</td>
				<td>people</td>
				<td>payment</td>
				<td>cancelDate</td>
			</tr>
		</thead>
		<%
			if(request.getAttribute("reservationList") == null){
				out.println("DB request ½ÇÆÐ");
				return;
			}
			ArrayList<Reservation> list = (ArrayList<Reservation>) request.getAttribute("reservationList");
			for (Reservation dto : list) {
				pageContext.setAttribute("dto", dto);			
		%>
			<tr>
				<td onclick="location.href='reservationDetail.jsp'"> 
					<span style="cursor: pointer">${dto.id}</span>
				</td>
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