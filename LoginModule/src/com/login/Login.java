package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname"); // refer login.jsp
		String pass = request.getParameter("pass");
		
		if(uname.equals("ravi") && pass.equals("ravi")) {
			System.out.println("correct username and password..");
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			// send back cookie in response when user make first login request. we can validate it for welcome page when browser send cookies 
			// in subsequent call
			// on logout just invalidate these cookies..
			Cookie cookie = new Cookie("username",uname);
			response.addCookie(cookie);
			response.sendRedirect("welcome.jsp");
		}else {
			System.out.println("incorrect username and password, redirect to login page..");
			response.sendRedirect("login.jsp");
		}
		
		
		
		
	}
	
	
	
	

	

}
