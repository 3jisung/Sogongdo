package controller;

import model.FacilityDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class readFacility
 */
@WebServlet("/readFacility")
public class readFacility extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public String data=null;	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public readFacility() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		request.setCharacterEncoding("utf-8");
		FacilityDTO data = new FacilityDTO();
		String f_id = request.getParameter("ffid");
		
		if (f_id==null) {
			System.out.println("시설 번호 입력 후 조회를 눌러주세요");
		} else {
			data.setFacilityID(f_id);
			request.setAttribute("fID", f_id);
			
			
			ServletContext context=getServletContext();
	        RequestDispatcher dispatcher = context.getRequestDispatcher("/listFacility.jsp"); //넘길 페이지 주소
	        dispatcher.forward(request, response);
		}
		
        
		
        
	}

}





