<%@page import="com.sun.webkit.ContextMenu.ShowContext"%>
<%@page import="com.sun.xml.internal.bind.v2.runtime.Location"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@ page import = "java.sql.Statement" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>



<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8">
	<title>시설 관리</title>

</head>

<body>

		<div style="width:1200px; height:80px; border:1px; float:left; margin-right:150px; letter-spacing:-2px">
			<font size="4">소공도 관광지</font>
			<font size="20">통합관리시스템</font>	
		</div>
		
	<br>
	<div style="width:120px; height:70px; border:1px solid GRAY; float:left; text-align:center;">
		<br>
		<font size="5"><b>시설관리</b></font>
		<br><br>

		<input type="button"  style="width:91pt; height:60pt; font-size:15px" value="시설관리">
		<input type="button" style="width:91pt; height:60pt; font-size:15px" value="시설속성관리" onclick="location.href='FacilityAttributes.jsp'">
		<br>
	</div>
	
	<form action="readFacility" method="post" >
		<div style="width:300px;  height:500px; border:1px;  float:left; margin-left:10px">
			시설번호<input type="text" name="ffid">
			<input type="submit" style="height:20pt;" value="조회">
			
			<br><br><br><br>
			 빈 칸을 조회 하시면 전체 조회가 됩니다.
		</div>
	</form>
	
	
	<form method="post" name="frm" target="ifrm">

		<div style="width:300px; height:100px; border:1px;  float:left; margin-left:10px">
		<br>
			<font size="2" style="margin-right:40px;">시설 번호 :</font>  
			<input name="fid" type="text" style="margin-left:-18px" >
			
			<br>
			
			<font size="2" style="margin-right:40px;">사업장 : </font>
			<select name="fworkplace" style="width:153px; height:20px;  margin-top:20px;" >	
		<%
		String DB_URL = "jdbc:mysql://m72e.iptime.org:33061/db?serverTimezone=UTC";
			String DB_USER = "root";
			String DB_PASSWORD= "0OSE!";
			
			Connection conn;
			Statement stmt;
			ResultSet rs = null;
			String query = "select * from WorkPlace";
	
			
			try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
			
			  conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			  stmt = conn.createStatement();
			  rs = stmt.executeQuery(query);
	  	
				while(rs.next() ) {
		 %>
				 	<option value=<%=rs.getString(1)%>><%=rs.getString(1)%></option>
		<%
				}
		  
				rs.close();
				stmt.close();
				conn.close();
			}
		 	catch(Exception e){
				out.print("Exception Error...");
				out.print(e.toString());
		 	}
		 	finally {}
		%>
			</select>
			
			
			<br><br>
			<font size="2" style="margin-right:40px; ">시설명 :	</font>  <input name="fname" type="text"  >
			
			<br>
			<input type="submit" style="margin-top:30px; margin-left:10px; width:40pt; height:20pt;" value="등록" formaction="createFacility" >
			<input type="submit" style="margin-top:30px; margin-left:30px; width:40pt; height:20pt;" value="수정" formaction="updateFacility">		
			<input type="submit" style="margin-top:30px; margin-left:30px; width:40pt; height:20pt;" value="삭제" formaction="deleteFacility">
		</div>
	</form>
	
		<iframe name="ifrm" style="display:none"></iframe>
	
</body>
</html>