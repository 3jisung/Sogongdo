package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import common.RefundDAO;
import model.*;

@WebServlet("/RefundControl")

public class RefundControl extends HttpServlet {
	private RefundDAO refundDAO = new RefundDAO();
	private RequestDispatcher dispatcher;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int refundMenu = Integer.parseInt(req.getParameter("refundMenu"));
		
		switch(refundMenu)
		{
		case 1:		//예약 번호 검색
			searchReservationID(req, resp);
			break;			
			
		default:
			System.out.println("error");
		}
	}
	
	public void searchReservationID(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String reservationID = req.getParameter("reservationID");
		if(refundDAO.searchReservation(reservationID) == false)
		{
			req.setAttribute("text", "\"해당하는 예약번호가 없습니다.\"");
			req.setAttribute("link", "/insertReservationID_R.jsp");
			dispatcher = req.getRequestDispatcher("/alert.jsp");
			dispatcher.forward(req, resp);
		}
		else
		{
			int nextMenu = Integer.parseInt(req.getParameter("nextMenu"));
			switch(nextMenu)
			{
			case 1:		//예약 번호 검색
				if(refundDAO.searchPayment(reservationID) == -1)
				{
					req.setAttribute("text", "\"등록된 결제내역이 없습니다.\"");
				}
					
				else
				{
					if(refundDAO.searchRefund(reservationID) != true)
					{
						refundDAO.createRefund(reservationID);
						req.setAttribute("text", "\"환불내역을 정상적으로 등록하였습니다.\"");
					}
					else
						req.setAttribute("text", "\"이미 환불내역이 등록된 예약 번호 입니다.\"");
				}				
				req.setAttribute("link", "/insertReservationID_R.jsp");
				dispatcher = req.getRequestDispatcher("/alert.jsp");
				dispatcher.forward(req, resp);
				break;
					
			case 2:		//환불내역 수정
				updateRefund(req, resp, reservationID);
				break;
				
			case 3:		//환불내역 삭제
				deleteRefund(req, resp, reservationID);
				break;		
				
			default:
				System.out.println("error");
			}
		}
	}
	
	
	public void updateRefund(HttpServletRequest req, HttpServletResponse resp, String reservationID) throws ServletException, IOException
	{
		if(refundDAO.searchPayment(reservationID) == -1)
		{
			req.setAttribute("text", "\"등록된 결제내역이 없습니다.\"");
		}
			
		else
		{
			if(refundDAO.searchRefund(reservationID) == true)
			{
				refundDAO.updateRefund(reservationID);
				req.setAttribute("text", "\"환불내역을 정상적으로 수정하였습니다.\"");
			}
			else
				req.setAttribute("text", "\"환불내역이 등록되지 않은 예약 번호 입니다.\"");
		}				
		req.setAttribute("link", "/insertReservationID_R.jsp");
		dispatcher = req.getRequestDispatcher("/alert.jsp");
		dispatcher.forward(req, resp);
	}
	

	public void deleteRefund(HttpServletRequest req, HttpServletResponse resp, String reservationID) throws ServletException, IOException
	{
		if(refundDAO.searchPayment(reservationID) == -1)
		{
			req.setAttribute("text", "\"등록된 결제내역이 없습니다.\"");
		}
			
		else
		{
			if(refundDAO.searchRefund(reservationID) == true)
			{
				refundDAO.deleteRefund(reservationID);
				req.setAttribute("text", "\"환불내역을 정상적으로 삭제하였습니다.\"");
			}
			else
				req.setAttribute("text", "\"환불내역이 등록되지 않은 예약 번호 입니다.\"");
		}				
		req.setAttribute("link", "/insertReservationID_R.jsp");
		dispatcher = req.getRequestDispatcher("/alert.jsp");
		dispatcher.forward(req, resp);
	}
}