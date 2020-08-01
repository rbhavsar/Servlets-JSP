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
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		Cookie cookies[]= request.getCookies();
		String username = null;
		String sessionID = null;
		for(Cookie cookie:cookies) {
			if(cookie.getName().equals("username")) {
				username = cookie.getValue();
				System.out.println("cookie username="+username);
			}
			else if(cookie.getName().equals("JSESSIONID")) {
				sessionID = cookie.getValue();
				System.out.println("sessionID will be end="+sessionID);
			}
		}
		
		Cookie cookie = new Cookie("username",null);
		cookie.setHttpOnly(true);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		session.invalidate();
		response.sendRedirect("login.jsp");
	}

	

}
