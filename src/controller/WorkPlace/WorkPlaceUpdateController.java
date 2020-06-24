package controller.WorkPlace;

import controller.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WorkPlaceUpdateController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String newname = request.getParameter("newname");
		
		if(name.isEmpty()) {
			request.setAttribute("error", "모든 항목을 입력하세요");
			HttpUtil.forward(request, response, "/WorkPlaceInfoUpdate.jsp");
			return;
		}
		
		
		//Service 객체의 메소드 호출
		WorkPlaceService service = WorkPlaceService.getInstance();
		service.workplaceUpdate(name, newname);
		
		//OutView 이동
		request.setAttribute("name",  name);
		HttpUtil.forward(request, response, "/result/WorkPlaceUpdateOutput.jsp");
	}

}
