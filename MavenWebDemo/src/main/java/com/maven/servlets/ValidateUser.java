package com.maven.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.maven.dao.UserDetailDao;
import com.maven.pojo.UserDetail;

/**
 * Servlet implementation class ValidateUser
 */
@WebServlet("/ValidateUser")
public class ValidateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// variables + methods	
/**	private String projectName = "Maven";
	
	public boolean validateUser(String username, String password){
		// connect db here		
		new Date();		
		return true;
	}
*/
	private UserDetailDao udd = new UserDetailDao();
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//	PrintWriter out = response.getWriter();	
		// name from html form, get the according data from the form
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try{
		UserDetail ud = udd.validateUser(username, password);
		
		if(ud != null){
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);		
			HttpSession session = request.getSession();
		// session will stay in memory until you logout
		
		// parameter: value-->pair
		// for the user loged in, we save its name for
		// future use until logout happens
			System.out.println(ud.getName());
			request.setAttribute("name", ud.getName());
				
			// multiple requests: session ramind
			// here to show the same user name
			
			// you can use request to save some data too
		session.setAttribute("name", ud.getName());
		
		// but request's data only exist on one page,
		//if request another page/url, data gone
		// while session remain data for multiple page		
		}else{
			response.sendRedirect("login.jsp?msg=invalid");
		}}catch(Exception e){
			response.sendRedirect(("login.jsp?msg=excp"));
		}
		
		// what if we are connecting to db now.
	//	if(username.equals("root") && password.equals("root")){
			//out.println("Login Success!");			
			// redirect to dashboard.html		
			// request dispatcher/response can redirect to other web page
			
			//user login request in browser; 
			//request goes to serverlt1: modify request object in servlet1; 
			//forward the request to another servlet: in another serlvet, you got a 
			// modified request
			
			// 1 request only, modifed request continues
			// chaining..among servlets
	//		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	//	}else{
			//out.println("Login Failed!");
			
			//user login request in browser; 
			//request goes to servlet1:request sent back immediately
			// user issue a new request: directly goes to servlet2
			
			// so 2 requests in total
			// no chain, 
			
			//add to url, and pass this to server
		//	response.sendRedirect("login.jsp?msg=invalid");
			//response.sendRedirect("login.html?msg=invalid");
			
			//use jsp to print message, better than html
			// now lets change all .html files to .jsp files
	//	}
		
	}
	
	// use get method: data in form are sent through url
	// not safe
	// use post method: data passed, but did not show on url
	// so how data went to server?
	
	// data added to the request and sent to server
	// post is better
	
		// session: maintain some serrions: maintain chaining:
	// thats why request.dispatcher is better
	
	//if login failed,
	// we use sendRedirect to cut the chain
	// return back to original level
}
