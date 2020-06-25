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
 * Servlet implementation class deleteFacilityAttributes
 */
@WebServlet("/deleteFacilityAttributes")
public class deleteFacilityAttributes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteFacilityAttributes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String f_id = request.getParameter("fid");
		
		if (f_id=="") {
			 System.out.println("시설 번호 입력 후 삭제를 눌러주세요");
		} else {
			FacilityDTO data = new FacilityDTO();
			data.setFacilityID(f_id);
			
			FacilityDAO facility = FacilityDAO.getInstance();
			facility.deleteFacilityAttributes(data);
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
