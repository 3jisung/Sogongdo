<%@page import="model.FacilityDAO"%>
<%@page import="model.FacilityDTO"%>
<%@page import="java.util.List"%>
<%@ page import = "java.sql.*" %>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="EUC-KR">
<title>시설 속성 관리</title>
</head>
<body>
	<div style="width:1200px; height:80px; border:1px; float:left; margin-bottom:10px; margin-right:150px; letter-spacing:-2px">
			<font size="4">소공도 관광지</font>
			<font size="20">통합관리시스템</font>	
	</div>

	<br>
	<div style="width:120px; height:70px;border:1px solid GRAY; float:left; text-align:center;margin-top:-15px;">
		<br>
		<font size="5"><b>시설관리</b></font>
		<br><br>

		<input type="button"  style="width:91pt; height:60pt; font-size:15px" value="시설관리"  onclick="location.href='Facility.jsp'">
		<input type="button" style="width:91pt; height:60pt; font-size:15px" value="시설속성관리">
		<br>
	</div>
	<form action="readFacilityAttributes" method="post" >
		<div style="width:350px; height:320px; border:1px; float:left; border-right-style:solid; border-right-width:0.1em; border-right-color:black;">
			시설번호<input type="text" name="ffid1">
			<input type="submit" style="height:20pt;" value="조회">
		</div>
	</form>
	
	<form method="post" name="frm" target="ifrm">
		<div style="width:300px; height:200px; border:1px;  float:left; margin-left:10px">
			<br><font size="2" style="margin-right:27px; margin-bottom:10px;">시설번호 :	</font><input name="fid" type="text">
			<br><font size="2" style="margin-right:27px; margin-bottom:10px;">시설분류 :	</font>  
				<select name="fclassify" style="width:153px;" >
					<option value="일반시설">일반시설</option>
					<option value="숙박시설">숙박시설</option>
					<option value="체험시설">체험시설</option>
				</select>
			<br><font size="2" style="margin-right:27px; margin-bottom:10px;">시설상태 :	</font>  <input name="fstate" type="text">
			<br><font size="2" style="margin-right:40px; margin-bottom:10px;">관리자 :	</font>  <input name="fmanager" type="text">
			<br><font size="2" style="margin-right:27px; margin-bottom:10px;">전화번호 :	</font>  <input name="fphone" type="text">
			<br><font size="2" style="margin-right:53px; margin-bottom:10px;">요금 :	</font>  <input name="fcost" type="text">
			<br><font size="2" style="margin-right:40px; margin-top:10px;">사업명 :	</font>  <input name="fbusinessname" type="text">
			
			
			<br>
			<input type="submit" style="margin-top:30px; margin-left:10px; width:40pt; height:20pt;" value="등록" formaction="createFacilityAttributes" >
			<input type="submit" style="margin-top:30px; margin-left:30px; width:40pt; height:20pt;" value="수정" formaction="updateFacilityAttributes">		
			<input type="submit" style="margin-top:30px; margin-left:30px; width:40pt; height:20pt;" value="삭제" formaction="deleteFacilityAttributes">		

			
			
		</div>
	</form>
	
	<iframe name="ifrm" style="display:none"></iframe>
	
</body>
</html>