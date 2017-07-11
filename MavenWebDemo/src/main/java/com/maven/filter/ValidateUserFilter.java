package com.maven.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateUserFilter implements Filter {

	// similar to servlet, Filter will be created once only
	
	@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {    
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        HttpSession session = request1.getSession(false);
        
        String loginURI = request1.getContextPath() + "/login.jsp";
        String validateURI = request1.getContextPath() + "/ValidateUser";

        boolean loggedIn = session != null && session.getAttribute("name") != null;
        boolean loginRequest = request1.getRequestURI().equals(loginURI) || request1.getRequestURI().equals(validateURI);

        // remove all data, records     
        
        // before we do filter,we visit an old page
        // it redicrects to it even after we loged out
        
        // but after filter,
        // we could not get into the inner page/old page
        // after we loged out
        
        // thats how filter works.
        
        if (loggedIn || loginRequest) {
            chain.doFilter(request1, response1);
        } else {
        	// no data, back to login page
            response1.sendRedirect(loginURI);
        }
    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
