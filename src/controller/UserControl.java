package controller;

import common.UserDAO;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/UserControl")
public class UserControl extends HttpServlet {
	RequestDispatcher rd = null;
	UserDAO uDao = new UserDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//어떤 id를 지닌 버튼을 클릭했느냐에 따라 작동 구분.
		if (req.getParameter("btn").equals("logInBtn")) {
			logIn(req, resp);
		} else if (req.getParameter("btn").equals("logOutBtn")) {
			logOut(req, resp);
		} else if (req.getParameter("btn").equals("createBtn")) {
			createUser(req, resp);
		} else if (req.getParameter("btn").equals("updateBtn")) {
			updateUser(req, resp);
		} else if (req.getParameter("btn").equals("deleteBtn")) {
			deleteUser(req, resp);
		} else if (req.getParameter("btn").equals("readBtn")) {
			readUser(req, resp);
		} else if (req.getParameter("btn").equals("idCheckBtn")) {
			idCheck(req, resp);
		}
	}
	
	//회원 정보 등록
	public void createUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("createId");
		String pw = req.getParameter("createPwd");
		String name = req.getParameter("createName");
		String address = req.getParameter("createAddress");
		LocalDate birthDate = LocalDate.parse(req.getParameter("createBirth"), DateTimeFormatter.ISO_DATE);
		String phone = req.getParameter("createPhone");
		String eMail = req.getParameter("createEmail");
		LocalDateTime current = LocalDateTime.now();
		
		User User = new User(id, pw, name, address, birthDate, current, phone, eMail);
		
		boolean createResult = uDao.createUser(User);
		
		req.setAttribute("createResult", createResult);
		
		if (createResult == true) {
			rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		} else {
			rd = req.getRequestDispatcher("createUser.jsp");
			rd.forward(req, resp);
		}
	}
	
	//회원 정보 수정 전 id 확인
	public void idCheck(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("updateTargetId");
		req.setAttribute("updateList", uDao.idCheck(id));
		rd = req.getRequestDispatcher("updateUser.jsp");
		rd.forward(req, resp);
	}
	
	//회원 정보 수정
	public void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("updateId");
		String password = req.getParameter("updatePwd");
		String address = req.getParameter("updateAddress");
		String phone = req.getParameter("updatePhone");
		String eMail = req.getParameter("updateEmail");
		
		boolean updateResult = uDao.updateUser(id, password, address, phone, eMail);
		req.setAttribute("updateResult", updateResult);
		
		if (updateResult == true) {
			rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		} else {
			rd = req.getRequestDispatcher("updateUser.jsp");
			rd.forward(req, resp);
		}
	}
	
	//회원 정보 삭제
	public void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("deleteId");
		boolean deleteResult = uDao.deleteUser(id);
		
		if (deleteResult == true) {
			req.setAttribute("deleteResult", deleteResult);
			rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		} else {
			req.setAttribute("deleteResult", deleteResult);
			rd = req.getRequestDispatcher("deleteUser.jsp");
			rd.forward(req, resp);
		}
	}
	
	//회원 정보 조회
	public void readUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("readId");
		req.setAttribute("readList", uDao.readUser(id));
		rd = req.getRequestDispatcher("readUser.jsp");
		rd.forward(req, resp);
	}
	
	//로그인
	public void logIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("logInId");
		String pw = req.getParameter("logInPwd");
		boolean logInResult = uDao.logIn(id, pw);
		
		if (logInResult == true) {
			req.setAttribute("logInResult", logInResult);
			HttpSession session = req.getSession();
			session.setAttribute("sessionId", id);
			rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		} else {
			req.setAttribute("logInResult", logInResult);
			rd = req.getRequestDispatcher("logIn.jsp");
			rd.forward(req, resp);
		}
	}
	
	//로그아웃
	public void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		
		rd = req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
	}
}
