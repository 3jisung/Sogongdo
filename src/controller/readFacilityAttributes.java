package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FacilityDTO;

/**
 * Servlet implementation class readFacilityAttributes
 */
@WebServlet("/readFacilityAttributes")
public class readFacilityAttributes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public readFacilityAttributes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		FacilityDTO data = new FacilityDTO();
		String f_id = request.getParameter("ffid1");
		
		if (f_id==null) {
			System.out.println("시설 번호 입력 후 조회를 눌러주세요");
		} else {
			data.setFacilityID(f_id);
			request.setAttribute("fID", f_id);
			
			ServletContext context=getServletContext();
	        RequestDispatcher dispatcher = context.getRequestDispatcher("/listFacilityAttributes.jsp"); //넘길 페이지 주소
	        dispatcher.forward(request, response);
		}
		
        
	}

}
