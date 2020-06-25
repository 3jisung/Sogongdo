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
 * Servlet implementation class createFacilityAttributes
 */
@WebServlet("/createFacilityAttributes")
public class createFacilityAttributes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createFacilityAttributes() {
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

		String f_name = request.getParameter("fname");
		String f_id = request.getParameter("fid");
		String f_classification = request.getParameter("fclassify");
		String f_state = request.getParameter("fstate");
		String f_manager = request.getParameter("fmanager");
		String f_phone = request.getParameter("fphone");
		String f_cost = request.getParameter("fcost");
		String f_businessname = request.getParameter("fbusinessname");
		
		if (f_classification=="" || f_state=="" || f_manager=="" || f_phone=="" || f_cost=="" || f_businessname=="" ){
			System.out.println("빈 칸이 존재합니다.\n모두 입력 후 등록을 눌러주세요!");
		} else {
			FacilityDTO data = new FacilityDTO();
			data.setFacilityID(f_id);
			data.setName(f_name);
			data.setClassification(f_classification);
			data.setState(f_state);
			data.setManager_id(f_manager);
			data.setPhone(f_phone);
			data.setCost(Integer.parseInt(f_cost));
			data.setBusiness_name(f_businessname);
			
			FacilityDAO facility = FacilityDAO.getInstance();
			facility.createFacilityAttributes(data);	
			
						
			
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
