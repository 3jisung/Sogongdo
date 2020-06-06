
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

<body>
<%
	String workplace = request.getParameter("workplace");
	String facility = request.getParameter("facility");
	String date = request.getParameter("date");
	String people = request.getParameter("people");
	String payment = request.getParameter("payment");
	if(workplace.equals("") || facility.equals("") || date.equals("") || people.equals("")){
		request.setAttribute("errMsg", "Please write all the input");
		//RequestDispatcher rd = request.getRequestDispatcher("reservation");
		//rd.forward(request, response);
		
		pageContext.forward("reservation");
		
		//response.sendRedirect("reservation");
	}
	else
		pageContext.forward("reservationDetail.jsp");
%>
</body>