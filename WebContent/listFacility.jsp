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
				<th>�ü���ȣ</th>
				<th>�ü���</th>
				<th>�����</th>
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
		} // for�� ����
		%>
			

			</tbody>
		</table>

</body>
</html>