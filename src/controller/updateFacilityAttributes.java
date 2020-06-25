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
 * Servlet implementation class updateFacilityAttributes
 */
@WebServlet("/updateFacilityAttributes")
public class updateFacilityAttributes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateFacilityAttributes() {
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
		
		String f_id = request.getParameter("fid");
		
		if (f_id=="") {
			System.out.println("시설 번호를 입력 후 수정 해주세요");
		} else {
			FacilityDTO data = new FacilityDTO();
			data.setFacilityID(f_id);
			FacilityDAO facility = FacilityDAO.getInstance();
			facility.updateFacilityAttributes(data);
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
