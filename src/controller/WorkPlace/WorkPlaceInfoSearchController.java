package controller.WorkPlace;

import controller.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WorkPlaceInfoSearchController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Parameter 추출
//				String name = request.getParameter("name");
//				
//				//유효성 체크
//				if(name.isEmpty()) {
//					request.setAttribute("error", "ID 입력하시오");
//					HttpUtil.forward(request, response, path);
//					return;
//				}
//				
//				//Service 객체의 메소드 호
//				MemberService service = MemberService.getInstance();
//				MemberDto member = service.memberSearch(id);
//				
//				//Output페이지 이동
//				if(member==null) request.setAttribute("result", "검색된 정보 없음");
//				request.setAttribute("member",  member);
//				if(job.equals("search")) path = "/result/memberSearchOutput.jsp";
//				HttpUtil.forward(request, response, path);
		
	}

}
