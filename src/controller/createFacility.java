package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FacilityDAO;
import model.FacilityDTO;

/**
 * Servlet implementation class FacilityController
 */
@WebServlet("/createFacility")
public class createFacility extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createFacility() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("utf-8");

		String f_workplace = request.getParameter("fworkplace");
		String f_name = request.getParameter("fname");
		String f_id = request.getParameter("fid");
		
		if (f_id=="" || f_name=="" || f_workplace=="" ){
			System.out.println("빈 칸이 존재합니다.\n모두 입력 후 등록을 눌러주세요!");
		} else {
			FacilityDTO data = new FacilityDTO();
			data.setFacilityID(f_id);
			data.setName(f_name);
			data.setWorkplace(f_workplace);
			
			FacilityDAO facility = FacilityDAO.getInstance();
			facility.createFacility(data);
		}
		
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
