package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.AuthorityDAO;
import model.Authority;


@WebServlet("/readAuthority")
public class AuthorityRead extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String target = req.getParameter("target");
		
		out.printf("target: %s\n", target);
		
		ArrayList<Authority> authorities = new ArrayList<>();
		if(target.equals(""))
			authorities = AuthorityDAO.INSTANCE.readAllAuthorities();
		else
			authorities = AuthorityDAO.INSTANCE.readSpecificAuthority(target);
		
		out.printf("done\n");
	}
}
