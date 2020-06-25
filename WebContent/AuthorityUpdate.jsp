<%@ page import="common.AuthorityDAO" %>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: 차예승
  Date: 2020-06-26
  Time: 오전 5:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>updateAuthority</title>
</head>
<body>
<%
    String originTarget = request.getParameter("originTarget");
    String originAction = request.getParameter("originAction");
    String target = request.getParameter("target");
    String action = request.getParameter("action");
    if(target.equals("") || action.equals("") || originTarget.equals("") || originAction.equals("")){
%>
<c:redirect url="/Authority.jsp">
    <c:param name="message" value="Plese check your inputs"/>
</c:redirect>
<%
    }
    else{
        AuthorityDAO.INSTANCE.updateAuthority(originTarget, originAction, target, action);
    }
%>
<c:redirect url="/Authority.jsp"/>
</body>
</html>
