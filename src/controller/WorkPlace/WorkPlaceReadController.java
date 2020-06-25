package controller.WorkPlace;

import controller.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.WorkPlaceDTO;

public class WorkPlaceReadController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Parameter 추출
		String name = request.getParameter("name");
		String job = request.getParameter("job");
		String path = null;
		if(job.equals("search")) {
			path = "/memberSearch.jsp";
		}else if(job.equals("update")) {
			path = "/memberUpdate.jsp";
		}else if(job.equals("delete")) {
			path="/memberDelete.jsp";
		}
		
		//유효성 체크
		if(name.isEmpty()) {
			request.setAttribute("error", "ID 입력하시오");
			HttpUtil.forward(request, response, path);
			return;
		}
		
		//Service 객체의 메소드 호
		WorkPlaceService service = WorkPlaceService.getInstance();
		WorkPlaceDTO workplace = service.workplaceRead(name);
		
		//Output페이지 이동
		if(workplace==null) request.setAttribute("result", "검색된 정보 없음");
		request.setAttribute("workplace",  workplace);
		if(job.equals("search")) path = "/result/memberReadOutput.jsp";
		HttpUtil.forward(request, response, path);
		
	}

}
