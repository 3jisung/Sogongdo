<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<script>
    <% String text = (String)request.getAttribute("text"); %>
    alert(<%=text %>);

    <% String link = (String)request.getAttribute("link"); %>
    /* location.href='/HelloServlet/createPayment.jsp'; */
    location.href = '<%=link%>';
</script>
</body>
</html>