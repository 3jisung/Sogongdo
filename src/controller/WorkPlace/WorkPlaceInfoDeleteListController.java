package controller.WorkPlace;

import controller.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.WorkPlaceDTO;

public class WorkPlaceInfoDeleteListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WorkPlaceService service = WorkPlaceService.getInstance();
		ArrayList<WorkPlaceDTO> list = service.workplaceInfoList();

		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "/WorkPlaceInfoDelete.jsp");
		
	}

}
