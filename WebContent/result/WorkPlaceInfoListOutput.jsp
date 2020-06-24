<%@page import="model.WorkPlaceDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>사업장 속성 조회</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.sidenav {
	height: 100%;
	width: 0;
	position: fixed;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: #111;
	overflow-x: hidden;
	transition: 0.5s;
	padding-top: 60px;
}

.sidenav a {
	padding: 8px 8px 8px 32px;
	text-decoration: none;
	font-size: 25px;
	color: #818181;
	display: block;
	transition: 0.3s;
}

.sidenav a:hover {
	color: #f1f1f1;
}

.sidenav .closebtn {
	position: absolute;
	top: 0;
	right: 25px;
	font-size: 36px;
	margin-left: 50px;
}

#main {
	transition: margin-left .5s;
	padding: 16px;
}

@media screen and (max-height: 450px) {
	.sidenav {
		padding-top: 15px;
	}
	.sidenav a {
		font-size: 18px;
	}
}
</style>
</head>
<body>

	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<a href="WorkPlaceCreate.jsp">사업장 추가</a>
		<a href="workplaceUpdateList.do">사업장 수정</a> 
		<a href="workplaceDeleteList.do">사업장 삭제</a> 
		<a href="workplaceList.do">사업장 조회</a>
		<a href="workplaceInfoCreateList.do">사업장 속성 추가</a> 
		<a href="workplaceInfoUpdateList.do">사업장 속성 수정</a>
		<a href="workplaceInfoDeleteList.do">사업장 속성 삭제</a>
		<a href="workplaceInfoList.do">사업장 속성 조회</a>
	</div>
	<div id="main">
		<span style="font-size: 30px; cursor: pointer" onclick="openNav()">&#9776; open</span>
	</div>

	
	<%  ArrayList<WorkPlaceDTO> list = (ArrayList<WorkPlaceDTO>) request.getAttribute("list"); 
    if(!list.isEmpty()) {  %>
	   <table border="1">
	   	<thead>
			<tr>
				<td>사업장명</td>
				<td>상태</td>
				<td>전화번호</td>
				<td>관리자</td>
			</tr>
		</thead>
			
			<%   for(int i=0; i<list.size(); i++){   
				WorkPlaceDTO workplace = list.get(i);   %>
			       
			        <tr>
			        	<td><%=workplace.getName() %></td>
			            <td><%=workplace.getState() %></td>
			            <td><%=workplace.getTel() %></td>
			            <td><%=workplace.getAdmin() %></td>
			       </tr>
			       
			<%   }
       }else{
    	   out.print("<h3>등록된 사업장 속성 정보가 없습니다.</h3>");
       }
	%>
	  </table>

	<script>
		function openNav() {
			document.getElementById("mySidenav").style.width = "250px";
			document.getElementById("main").style.marginLeft = "250px";
		}

		function closeNav() {
			document.getElementById("mySidenav").style.width = "0";
			document.getElementById("main").style.marginLeft = "0";
		}
	</script>
	
</body>
</html>