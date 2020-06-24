
<%@page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Reservation"%>
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
	String workplace = request.getParameter("facility");
	String facility = request.getParameter("startDate");
	String date = request.getParameter("endDate");
	String people = request.getParameter("people");
	String payment = request.getParameter("payment");
	if(workplace.equals("") || facility.equals("") || date.equals("") || people.equals("")){
%>
	<c:redirect url="/reservation">
		<c:param name="message" value="Plese check your inputs"/>
	</c:redirect>
<%
	}
	else{
		ReservationDTO dto = new ReservationDTO();

		// 결제 페이지 
		pageContext.forward("reservationDetail.jsp");
	}
%>

</body>