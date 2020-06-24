package controller.WorkPlace;

import controller.*;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import model.WorkPlaceDTO;


public class WorkPlaceInfoUpdateController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		//Parameter 추출
		String name = request.getParameter("name");
		String state = request.getParameter("state");
		String tel = request.getParameter("tel");
		String admin_id = request.getParameter("admin_id");
		
		if(name.isEmpty() || state.isEmpty() || tel.isEmpty()|| admin_id.isEmpty()) {
			request.setAttribute("error", "모든 항목을 입력하세요");

			HttpUtil.forward(request, response, "/WorkPlaceInfoUpdate.jsp");
			return;
		}
		
		WorkPlaceDTO workplace = new WorkPlaceDTO();
		workplace.setName(name);
		workplace.setState(state);
		workplace.setTel(tel);
		workplace.setAdmin(admin_id);
		
		//Service 객체의 메소드 호출
		WorkPlaceService service = WorkPlaceService.getInstance();
		service.workplaceInfoUpdate(workplace);
		
		//OutView 이동
		request.setAttribute("name",  name);
		HttpUtil.forward(request, response, "/result/WorkPlaceInfoUpdateOutput.jsp");
	}
}