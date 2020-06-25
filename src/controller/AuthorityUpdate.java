package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.AuthorityDAO;

@WebServlet("/updateAuthority")
public class AuthorityUpdate extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		PrintWriter out = resp.getWriter();
		int id = Integer.parseInt(req.getParameter("id"));
		String target = req.getParameter("target");
		String action = req.getParameter("action");
		
		out.printf("target: %s\n", target);
		out.printf("action: %s\n", action);
		AuthorityDAO.INSTANCE.updateAuthority(id, target, action);
		out.printf("done\n");
	}
}
