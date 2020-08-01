# Servlets-JSP
# Login Application - Session + Cookies

- Import LogoinModule as Web Dynamic project in eclipse. 
- Run login.jsp using tomcat server in eclipse itself.
- Provide correct credentils then you will redirect to welcome page and access other pages
- Press logout - user will redirect to login page.

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









