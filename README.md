# Servlets-JSP
# Login Application - Session + Cookies

- Import LogoinModule as Web Dynamic project in eclipse. 
- Run login.jsp using tomcat server in eclipse itself.
- Provide correct credentils then you will redirect to welcome page and access other pages
- Press logout - user will redirect to login page.

![](/screenshots/Loginflow.jpg)

# Cookies and Session

- Cookies and session both store information about the user (to make the HTTP request stateful) but the difference is that cookies store information on the client-side (browser) and sessions store information on the server-side
- HTTP protocol is stateless, and so maintaining state across requests is a must. So, Need to use the cookie and the session to store user data between subsequent requests to the server
- Session : When user sends login request then create session at server side and store information as below and then we can access this information other pages too
```
Login
HttpSession session = request.getSession();
session.setAttribute("username", uname);

Welcome
if(session.getAttribute("username") == null){
 		response.sendRedirect("login.jsp");
}
```

Cookies : Application code create/send cookies on first login attempt as response header and client (Broweser) send that cookies in request header for subsequent call and application code validate it.

```
Login
Cookie cookie = new Cookie("username",uname);
response.addCookie(cookie);

Welcome
Cookie cookies[]= request.getCookies();
 	String username = null;
 	for(Cookie cookie:cookies) {
 		username = cookie.getValue();
 		System.out.println("cookie username="+username); //Just validate username Assert
}
```

- Logout + Session : Remove session attribute and invalidate session 
- Logout+Cookie : Set null value for given name param , set Max age = 0 and send back in response header to client

```
HttpSession session = request.getSession();
session.removeAttribute("username”);
session.invalidate();


Cookie cookie = new Cookie("username",null);
cookie.setHttpOnly(true);
cookie.setMaxAge(0);
response.addCookie(cookie);
```

- Another use of cookies we can see in flight booking / e commerce website where user search is preserve in terms of cookies in brwoser. So, when user revisit the browser
then user can see the past search items again 


# Persist info in session-cookie + Display on page.
- Run todo-demo.jsp on tomcat
- Run cookies-personalize-form 

# ServletDemo

- MvcDemoServlet.java - > student list will be displayed on view_students.jsp..Used RequestDispatcher to forward request to jsp
- Run student-form.html -> enter student detail - > It will hit the StudentServlet and diplay the entered information.

![](/screenshots/doGet.jpg)
![](/screenshots/doGet_1.jpg)
![](/screenshots/doPost.jpg)
![](/screenshots/doPost_1.jpg)


# ServeletConfig & ServeletContext
- parse & read WEB-INF/web.xml configuration 
- Extend Servlet with HttpServlet and we can do below
- ServletContext context = getServletContext() , ServletConfig config = getServletConfig()



# JSESSIONID 

When we create new session HttpServletRequest getSession() , it creates the new HttpSession object and also add a Cookie to the response object with name JSESSIONID
Observe JSESSIONID for login flow 

![](/nginx/screenshots/open_login_page.png)
![](/nginx/screenshots/land-welcome.png)
![](/nginx/screenshots/logout-redirect-to-login.png)








