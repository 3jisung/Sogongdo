package controller;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.*;

@WebServlet("/productPackageController")
public class productPackageController extends HttpServlet{
	private ProductPackageDAO productpackageDAO = new ProductPackageDAO();
	private ProductPaymentDAO productpaymentDAO = new ProductPaymentDAO();
	private RequestDispatcher dispatcher;
	private String user_id = "test";	//구매자 (테스트, 임시)
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int menu = Integer.parseInt(req.getParameter("menu"));	//메뉴번호
		
		switch(menu)
		{
		case 1: //상품패키지 등록
			try {
				createProductPackage(req,resp);
			} catch (SQLException e) {e.printStackTrace();}
			break;
		case 2: //상품패키지 수정
			try {
				updateProductPackage(req,resp);
			} catch (SQLException e) {e.printStackTrace();}
			break;
		case 3:	//상품패키지 삭제 
			try {
				deleteProductPackage(req,resp);
			} catch (SQLException e) {e.printStackTrace();}
			break;
		case 4 : //상품구매
			try {
				createProductPayment(req,resp);
			} catch (SQLException e) {e.printStackTrace();}
			break;
		default :
			System.out.println("error");
		}
	}
	
	public void createProductPackage(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
		String name = req.getParameter("name");	//이름 가져옴
		int price = Integer.parseInt(req.getParameter("price"));
		productpackageDAO.createProductPackage(name, price);
		dispatcher = req.getRequestDispatcher("/readProductPackage.jsp");
		dispatcher.forward(req, resp);
	}
	
	public void updateProductPackage(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
		String name = req.getParameter("name");
		String newname = req.getParameter("newname");
		int newprice = Integer.parseInt(req.getParameter("newprice"));
		productpackageDAO.updateProductPackage(name,newname,newprice);
		dispatcher = req.getRequestDispatcher("/readProductPackage.jsp");
		dispatcher.forward(req, resp);
	}
	
	public void deleteProductPackage(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
		String name = req.getParameter("pname");
		productpackageDAO.deleteProductPackage(name);
		dispatcher = req.getRequestDispatcher("/readProductPackage.jsp");
		dispatcher.forward(req, resp);
	}
	
	public void createProductPayment(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
		String name = req.getParameter("pname");
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		productpaymentDAO.createProductPayment(name, user_id, quantity);
		dispatcher = req.getRequestDispatcher("/readProductPackage.jsp");
		dispatcher.forward(req, resp);
	}
	
	
}
