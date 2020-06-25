package controller.WorkPlace;

import controller.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.WorkPlaceDTO;

public class WorkPlaceCreateController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");

		//유효성체크
		if(name.isEmpty()) {
			request.setAttribute("error", "사업장명을 입력하시오");
			HttpUtil.forward(request, response, "/WorkPlaceCreate.jsp");
			return;
		}
		
		WorkPlaceDTO workplaceDto = new WorkPlaceDTO();
		workplaceDto.setName(name);

		//service 객체의 메소드 호출
		WorkPlaceService service = WorkPlaceService.getInstance();
		
		service.workplaceCreate(workplaceDto);


		//Out view 페이지로 이동
		request.setAttribute("name",name);
		HttpUtil.forward(request, response, "/result/WorkPlaceCreateOutput.jsp");
	}

}
