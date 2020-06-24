package controller;

import common.PaymentDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PaymentControl")

public class PaymentControl extends HttpServlet {
	private PaymentDAO paymentDAO = new PaymentDAO();
	private RequestDispatcher dispatcher;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int paymentMenu = Integer.parseInt(req.getParameter("paymentMenu"));
		
		switch(paymentMenu)
		{
		case 1:		//예약 번호 검색.
			searchReservationID(req, resp);
			break;
		case 2:		//결제내역 등록
			createPayment(req, resp);
			break;
		
		case 3:		//결제내역 수정
			updatePayment(req, resp);
			break;
				
			
		default:
			System.out.println("error");
		}
	}
	
	public void searchReservationID(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String reservationID = req.getParameter("reservationID");
		if(paymentDAO.searchReservation(reservationID) == false)
		{
			req.setAttribute("text", "\"해당하는 예약번호가 없습니다.\"");
			req.setAttribute("link", "/insertReservationID_P.jsp");
			dispatcher = req.getRequestDispatcher("/alert.jsp");
			dispatcher.forward(req, resp);
		}
		else
		{
			int nextMenu = Integer.parseInt(req.getParameter("nextMenu"));
			switch(nextMenu)
			{
			case 1:		//예약 번호 검색
				if(paymentDAO.searchPayment(reservationID) == -1)
				{
					req.setAttribute("reservationID", reservationID);
					dispatcher = req.getRequestDispatcher("/createReservationPayment.jsp");
				}
				else
				{
					req.setAttribute("text", "\"이미 결제내역이 등록된 예약 번호 입니다.\"");
					req.setAttribute("link", "/insertReservationID_P.jsp");
					dispatcher = req.getRequestDispatcher("/alert.jsp");
				}				
				dispatcher.forward(req, resp);
				break;
			case 2:		//해당 결제내역 값 호출
				callPayment(req, resp, reservationID);
				break;
					
			case 3:		//결제내역 삭제
				deletePayment(req, resp, reservationID);
				break;		
				
			default:
				System.out.println("error");
			}
		}
	}
	
	public void callPayment(HttpServletRequest req, HttpServletResponse resp, String reservationID) throws ServletException, IOException
	{
		int fee = paymentDAO.searchPayment(reservationID);
		if(fee != -1)
		{
			req.setAttribute("fee", fee);
			req.setAttribute("reservationID", reservationID);
			dispatcher = req.getRequestDispatcher("/updateReservationPayment.jsp");
		}
		
		else
		{
			req.setAttribute("text", "\"오류 발생\"");
			req.setAttribute("link", "/insertReservationID_P.jsp");
			dispatcher = req.getRequestDispatcher("/alert.jsp");
		}	
		dispatcher.forward(req, resp);
	}

	public void createPayment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String reservationID = req.getParameter("reservationID");
		int fee = Integer.parseInt(req.getParameter("fee"));

		paymentDAO.createPayment(reservationID, fee);
		req.setAttribute("text", "\"결제내역이 등록되었습니다.\"");			
		req.setAttribute("link", "/insertReservationID_P.jsp");
		dispatcher = req.getRequestDispatcher("/alert.jsp");
		dispatcher.forward(req, resp);
	}

	
	public void updatePayment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String reservationID = req.getParameter("reservationID");
		int fee = Integer.parseInt(req.getParameter("fee"));
		
		paymentDAO.updatePayment(reservationID, fee);
		
		req.setAttribute("text", "\"결제내역이 수정되었습니다.\"");		

		req.setAttribute("link", "/insertReservationID_P.jsp");
		dispatcher = req.getRequestDispatcher("/alert.jsp");
		dispatcher.forward(req, resp);
	}
	

	public void deletePayment(HttpServletRequest req, HttpServletResponse resp, String reservationID) throws ServletException, IOException
	{
		paymentDAO.deletePayment(reservationID);
		
		req.setAttribute("text", "\"결제내역이 삭제되었습니다.\"");	
		req.setAttribute("link", "/insertReservationID_P.jsp");
		dispatcher = req.getRequestDispatcher("/alert.jsp");
		dispatcher.forward(req, resp);
	}
}