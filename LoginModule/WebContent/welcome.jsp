<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	if(session.getAttribute("username") == null){
		response.sendRedirect("login.jsp");
	}

	Cookie cookies[]= request.getCookies();
	String sessionID = null;
	for(Cookie cookie:cookies) {
		if(cookie.getName().equals("JSESSIONID")) {
			sessionID = cookie.getValue();
			System.out.println("sessionID="+sessionID);
		}
	}
	pageContext.setAttribute("sessionID", sessionID);
%>



 Welcome ${username} 
 and here is your ${sessionID}

	<a href="videos.jsp">Videos here..</a>
	
	<form action="Logout">
		<input type="submit" value="Logout">
	</form>

</body>
</html>