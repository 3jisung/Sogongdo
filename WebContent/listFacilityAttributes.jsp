<%@page import="model.FacilityDAO"%>
<%@page import="model.FacilityDTO"%>
<%@page import="java.util.List"%>
<%@ page import = "java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>

<%
	String c=request.getParameter("ffid1");
System.out.println(c);
	FacilityDAO flist = FacilityDAO.getInstance();
	FacilityDTO data = new FacilityDTO();
	List<FacilityDTO> list =flist.readFacilityAttributes(c);
%>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<table  border="1" style=" margin-left:15px;" >
			<tr>
				<th>시설번호</th>
				<th>시설명</th>
				<th>사업장</th>
				<th>시설분류</th>
				<th>시설상태</th>
				<th>관리자</th>
				<th>전화번호</th>
				<th>가격</th>
				<th>사업명</th>
			</tr>
			<%
			if (!list.isEmpty()){
				
			
				for (int i=0; i<list.size(); i++) {
					data = list.get(i);
				%>
			<tr>
			 
				<td><%=(String)data.getFacilityID() %></td>
				<td><%=(String)data.getName() %></td>
				<td><%=(String)data.getWorkplace() %></td>
				<td><%=(String)data.getClassification() %></td>
				<td><%=(String)data.getState() %></td>
				<td><%=(String)data.getManager_id() %></td>
				<td><%=(String)data.getPhone() %></td>
				<td><%=(int)data.getCost() %></td>
				<td><%=(String)data.getBusiness_name()%></td>
			</tr> 
			<%		
				} // for문 종료
			}
		%>
			

			</tbody>
		</table>

</body>
</html>