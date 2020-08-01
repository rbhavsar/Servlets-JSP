<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>

<!-- Step 1: Create HTML form -->
<form action="todo-demo.jsp">
	Add new item: <input type="text" name="theItem" />
	
	<input type="submit" value="Submit" />
</form>

<!-- Step 2: Add new item to "To Do" list -->
<%
	// get the TO DO items from the session
	List<String> items = (List<String>) session.getAttribute("myToDoList");
	System.out.println("items: "+items);
	// if the TO DO items doesn't exist, then create a new one
	if (items == null) {
		System.out.println("items are null "+items);
		items = new ArrayList<String>();
		session.setAttribute("myToDoList", items);
	}
	
	// see if there is form data to add
	String theItem = request.getParameter("theItem");
	if (theItem != null) {
		items.add(theItem);
	}
%>

<!-- Step 3: Display all "To Do" item from session -->
<hr>
<b>To List Items:</b> <br/>

<ol>
<%
	for (String temp : items) {
		out.println("<li>" + temp + "</li>");
	}
%>
</ol>

</body>

</html>

	
	
<!-- 
Another usecase for cookies

- Do flight search in expedia then expedia gives cookies to client for seach and that will store in client browser
- When customer revisit the site then that search will populate 
- Browser will send only expedia cookies to server when we visit expedia.com


 -->	
	



</body>
</html>