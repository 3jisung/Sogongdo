<%@ page import="common.SettlementDAO" %>
<%@ page import="model.Settlement" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>정산관리</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <td>시설</td>
        <td>정산일</td>
        <td>정산자</td>
        <td>정산 시간</td>
    </tr>
    </thead>
    <%
        String workplace = null;
        List<Settlement> list = SettlementDAO.INSTANCE.selectSettlements(workplace, null, null);
        for (Settlement item : list) {
        }
    %>
</table>
</body>
</html>
