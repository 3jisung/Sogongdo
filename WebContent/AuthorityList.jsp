<%--
  Created by IntelliJ IDEA.
  User: 차예승
  Date: 2020-06-26
  Time: 오전 4:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>AuthorityList</title>
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
            <th>Target</th>
            <th> <span id="ReservationID">${param.target}</span> </th>
        </tr>
        <tr>
            <th>Action</th>
            <th> <input type="text" id="userID" value="${param.action}"></th>
        </tr>
    </table>
    <br>
    <button onclick="updateAuthority()">Edit</button>
    <button onclick="deleteAuthority()">Delete</button>
    <script type="text/javascript">
        String reservationID = (String) document.getElementById("ReservationID").innerHTML;
        pageContext.setAttribute("reservationID", reservationID);

        function updateAuthority(){
            String target = document.getElementById("target").value;
            String action = document.getElementById("action").value;
            AuthorityDAO.INSTANCE.updateAuthority(target, action);
        }
        function deleteAuthority(){
            String target = document.getElementById("target").value;
            String action = document.getElementById("action").value;
            AuthorityDAO.INSTANCE.deleteAuthority(target, action);
            location.herf("/Authority.jsp");
        }
    </script>
</div>
</body>
</html>
