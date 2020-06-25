<%@page import="model.FacilityDAO"%>
<%@page import="model.FacilityDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>

<%
	String c=request.getParameter("ffid");
	FacilityDAO flist = FacilityDAO.getInstance();
	FacilityDTO data = new FacilityDTO();
	List<FacilityDTO> list =flist.readFacility(c);
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
			</tr>
			<%
			for (int i=0; i<list.size(); i++) {
				data = list.get(i);
		%>
		<tr>
		 
			<td><%=(String)data.getFacilityID() %></td>
			<td><%=(String)data.getName() %></td>
			<td><%=(String)data.getWorkplace() %></td>
		</tr> 
		<%		
		} // for문 종료
		%>
			

			</tbody>
		</table>

</body>
</html>