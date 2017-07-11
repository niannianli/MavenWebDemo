package com.maven.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet{
	
	// will be called when logout is clicked
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		// expire session
		session.invalidate();
		
		// back to login page
		response.sendRedirect("login.jsp");
		
		// even after logout, we can access dashboard.jsp
		// manually
		
		// we need to define criteria to avoid this		
		// session management		
	}

}
