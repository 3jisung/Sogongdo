<%@page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Reservation"%>
<%@page import="common.*"%>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Reservation</title>
</head>

<body>
<%
	String userID = request.getParameter("userID");
	String facilityID = request.getParameter("facility");
	String startDate = request.getParameter("startDate");
	String endDate = request.getParameter("endDate");
	String people = request.getParameter("people");
	String payment = request.getParameter("payment");
	if(userID.equals("") || facilityID.equals("") || startDate.equals("") || endDate.equals("") || people.equals("")){
%>
	<c:redirect url="/reservation">
		<c:param name="message" value="Plese check your inputs"/>
	</c:redirect>
<%
	}
	else{

		// 결제 페이지 이동
		
		// if 결제 성공시 
		String paymentID = "";
		ReservationDAO rd = new ReservationDAO();
		rd.createReservation(new Reservation("", userID, facilityID, paymentID, startDate, endDate, people, startDate, ""));
	}
%>
	<c:redirect url="/reservation"/>
</body>