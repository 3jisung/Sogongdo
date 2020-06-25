package controller.WorkPlace;

import controller.*;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import model.WorkPlaceDTO;

public class WorkPlaceInfoCreateController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//파라미터 추출
		String name = request.getParameter("name");
		String state = request.getParameter("state");
		String tel = request.getParameter("tel");
		String admin_id = request.getParameter("admin_id");

		//유효성체크
		if(name.isEmpty() || state.isEmpty() || tel.isEmpty()|| admin_id.isEmpty()) {
			request.setAttribute("error", "모든 항목을 입력하시오");
			HttpUtil.forward(request, response, "/WorkPlaceInfoCreate.jsp");
			return;
		}

		//VO 객체에 데이터 바인딩
		WorkPlaceDTO workplaceDto = new WorkPlaceDTO();
		workplaceDto.setName(name);
		workplaceDto.setState(state);
		workplaceDto.setTel(tel);
		workplaceDto.setAdmin(admin_id);

		//service 객체의 메소드 호출
		WorkPlaceService service = WorkPlaceService.getInstance();
		try {
			service.workplaceInfoCreate(workplaceDto);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//Out view 페이지로 이동
		request.setAttribute("name",name);
		HttpUtil.forward(request, response, "/result/WorkPlaceInfoCreateOutput.jsp");
	}

}
