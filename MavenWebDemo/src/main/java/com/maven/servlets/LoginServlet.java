package com.maven.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */

// no need to configure in web.xml, 
//just use one annotation, thats all.
// you can add servelt, servlet mapping in web.xml, which is the same
// as here
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String projectName;
	
	public LoginServlet(){
		System.out.println("LoginServlet obj created.");
	}
	
	// this is not accepted by servers,
	// so only default constructor
	// and init() method will be called, which contains some value
	// can be passed
	public LoginServlet(String s){
		System.out.println("LoginServlet obj created.");
	}
		
	// same as constructor, first called, once for all
	// whenever object first created
	@Override
	public void init(ServletConfig config) throws ServletException{
		System.out.println("servlet config");
	//	projectName = config.getInitParameter("proName");
		
		ServletContext context = config.getServletContext();
		projectName = context.getInitParameter("proName");
	}
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello servlet");
		// generate html code from servlet
		
		PrintWriter out = response.getWriter();
	//	out.println("hello1");			
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello Servlet!</h1>" + new Date() + projectName);
		out.println("</body>");
		out.println("</html>");
		out.close();	
		// not this way, we only get request and send response
		// better just use html file to get data		
	}

}
