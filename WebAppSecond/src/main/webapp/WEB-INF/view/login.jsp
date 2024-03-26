<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h1>Login</h1>
    <form method="POST" action="LoginServlet">
        <label for="userid">UserID:</label>
        <input type="text" id="userid" name="userid"><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br>
        <input type="submit" value="Login">
    </form>
    
    <% 
		String errorMsg = (String)request.getAttribute("errorMsg");
		if (errorMsg != null) {
	%>
			<p><%= errorMsg %></p>
	<%
		} 
	%>

    <p>or <a href="NewuserServlet">Create User</a></p>
    
</body>
</html>