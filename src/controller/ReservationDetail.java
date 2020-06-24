package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ReservationDAO;

@WebServlet("/reservationDetail/*")
public class ReservationDetail extends HttpServlet {
	private ReservationDAO dao = new ReservationDAO();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setAttribute("reservationList", dao.select());
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/reservationDetail.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String userID = req.getParameter("user");
//		String workplaceID = req.getParameter("wrok");
//		String facilityID = req.getParameter("fac");
//		String date = req.getParameter("date");
//		String people = req.getParameter("peo");
//		String payment = req.getParameter("pay");
		
	}
}