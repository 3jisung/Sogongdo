package controller.WorkPlace;

import controller.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.HttpUtil;
import common.WorkPlaceDAO;
import model.WorkPlaceDTO;

//@WebServlet("/WorkPlaceInfoRead/*")
public class WorkPlaceInfoListController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WorkPlaceService service = WorkPlaceService.getInstance();
		ArrayList<WorkPlaceDTO> list = service.workplaceInfoList();

		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "/result/WorkPlaceInfoListOutput.jsp");
	}
}


