<%@ page import="java.util.List" %>
<%@ page import="model.FacilityDTO" %>
<%@ page import="model.FacilityDAO" %>
<%@ page import="model.WorkPlaceDTO" %>
<%@ page import="common.WorkPlaceDAO" %>
<%@ page import="model.Settlement" %>
<%@ page import="common.SettlementDAO" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.sql.Timestamp" %>
<%@page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Reservation</title>
</head>

<style>
    a {
        text-decoration: none;
    }

    li {
        list-style: none;
    }

    input {
        text-align: center;
    }

    button {
        min-width: 60px
    }

    table td {
        min-width: 120px;
        text-align: center;
    }

    table th {
        min-width: 100px;
        text-align: left;
    }
</style>

<body>
<div align="center">
    <h1 style="margin-bottom: -0.04rem;"> SoGongDo Management System </h1>
    <small>COPYRIGHT(C) Kumoh National Institute of Technology. All Rights Reserved. TEL : (054) 478-7540 FAX : (054)
        478-7319</small>
</div>

<hr width="80%" color="lightgray" noshade/>

<div align="center">
    <h2 style="margin-bottom: -0.05rem;">정산</h2>
    <!--<small>정산설명 블라블라</small>-->

    <form method="post" action="createSettlement.jsp">
        <table style="margin-top: 10px;">
            <tr>
                <th>ID</th>
                <th><input type="text" id="userID"/></th>
            </tr>
            <tr>
                <th>시설</th>
                <th>
                    <select name="facility">
                        <%
                            List<WorkPlaceDTO> workplace_list = WorkPlaceDAO.getInstance().workplaceList();
                            for (WorkPlaceDTO workplace : workplace_list
                                 ) {
                                out.println("<option>" + workplace.getName() + "</option>");
                            }
                        %>
                    </select>
                </th>
            </tr>
            <tr>
                <th>정산일</th>
                <th><input type="date" name="settlement_date"></th>
            </tr>
            <tr>
                <th>정산시간</th>
                <th>
                    <input type="date" name="processed_date">
                    <input type="time" name="processed_time">
                </th>
            </tr>
        </table>
        <br>
        <button>정산</button>
        <p> ${param.message} </p>
    </form>
    <br>
    <h2 style="margin-bottom: -0.05rem;">정산 조회</h2>
    <form method="post" action="settlement.jsp">
        <table style="margin-top: 10px;">
            <tr>
                <th>시설</th>
                <th>
                    <select name="facility">
                        <%
                            //List<WorkPlaceDTO> workplace_list = WorkPlaceDAO.getInstance().workplaceList();
                            for (WorkPlaceDTO workplace : workplace_list
                            ) {
                                out.println("<option>" + workplace.getName() + "</option>");
                            }
                        %>
                    </select>
                </th>
            </tr>
            <tr>
                <th>정산일 범위</th>
                <th>
                    <input type="date" name="settlement_date_start"> ~ <input type="date" name="settlement_date_end">
                </th>
            </tr>
        </table>
        <br>
        <button>정산 조회</button>
        <p> ${param.message} </p>
    </form>
</div>

<hr width="80%" color="lightgray" noshade/>

<div align="center">
    <h2 align="center" style="margin-bottom: -0.05rem;">정산 목록</h2>
    <small align="center">id를 클릭해 상세 내역 조회, 수정, 삭제 가능</small>
    <table border="3" bordercolor="lightgray" style="margin-bottom: 100px;">
        <thead>
        <tr>
            <td>시설(사업장)</td>
            <td>정산자</td>
            <td>정산일</td>
            <td>정산시간</td>
        </tr>
        </thead>
        <!--
        <%/*
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            request.setCharacterEncoding("UTF-8");
            String facility = request.getParameter("facility") == null ? workplace_list.get(0).getName() : request.getParameter("facility");
            String start = request.getParameter("settlement_date_start") == null ? sdf.format(new java.util.Date(System.currentTimeMillis() - 7L * 24 * 3600 * 1000)) : request.getParameter("settlement_date_start");
            String end = request.getParameter("settlement_date_end") == null ? sdf.format(new java.util.Date()) : request.getParameter("settlement_date_end");

            List<Settlement> list = SettlementDAO.INSTANCE.selectSettlements(facility, Date.valueOf(start), Date.valueOf(end));
            for (Settlement s : list) {
                pageContext.setAttribute("item", s);
        */%>
        <tr>
            <td>${item.workplace}</td>
            <td>${item.admin_id}</td>
            <td>${item.settlement_date}</td>
            <td>${item.processed_time}</td>
        </tr>
        <%
        //}
        %>
        -->
    </table>
</div>
</body>
</html>