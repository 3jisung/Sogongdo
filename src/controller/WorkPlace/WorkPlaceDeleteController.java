package controller.WorkPlace;

import controller.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WorkPlaceDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		WorkPlaceService service = WorkPlaceService.getInstance();
		service.workplaceDelete(name);
		
		HttpUtil.forward(request, response, "/result/WorkPlaceDeleteOutput.jsp");
		
	}

}
