package controller;

import controller.WorkPlace.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class FrontController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	String charset = null;
	HashMap<String, Controller> list = null;
	
	@Override
	public void init(ServletConfig config)throws ServletException{
		charset = config.getInitParameter("charset");
		list = new HashMap<String, Controller>();
		list.put("/workplaceCreate.do",  new WorkPlaceCreateController());
		list.put("/workplaceList.do", new WorkPlaceListController());
		list.put("/workplaceUpdate.do",  new WorkPlaceUpdateController());
		list.put("/workplaceUpdateList.do",  new WorkPlaceUpdateListController());
		list.put("/workplaceDelete.do",  new WorkPlaceDeleteController());
		list.put("/workplaceDeleteList.do",  new WorkPlaceDeleteListController());
		list.put("/workplaceRead.do",  new WorkPlaceReadController());
		list.put("/workplaceInfoCreate.do",  new WorkPlaceInfoCreateController());
		list.put("/workplaceInfoCreateList.do",  new WorkPlaceInfoCreateListController());
		list.put("/workplaceInfoList.do", new WorkPlaceInfoListController());
		list.put("/workplaceInfoUpdate.do",  new WorkPlaceInfoUpdateController());
		list.put("/workplaceInfoUpdateList.do",  new WorkPlaceInfoUpdateListController());
		list.put("/workplaceInfoDelete.do",  new WorkPlaceInfoDeleteController());
		list.put("/workplaceInfoDeleteList.do",  new WorkPlaceInfoDeleteListController());
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		request.setCharacterEncoding(charset);
		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = url.substring(contextPath.length());
		
		Controller subController = list.get(path);
		subController.execute(request, response);
	}
}
