<%-- 
    Document   : dashboard
    Created on : 20 Jan 2025, 18:12:58
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Dashboard</title>
    </head>
    <body>
        <h1>Welcome to Your Dashboard</h1>
        <%
            // Retrieve user details from session
            //HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("username") == null) {
        %>
            <p>You are not logged in. Please <a href="login.jsp">login</a>.</p>
        <%
            } else {
                String username = (String) session.getAttribute("username");
                String email = (String) session.getAttribute("email");
                String first_name = (String) session.getAttribute("first_name");
                String last_name = (String) session.getAttribute("last_name");
        %>
            <p><strong>Username:</strong> <%= username %></p>
            <p><strong>First Name:</strong> <%= first_name %></p>
            <p><strong>Last Name:</strong> <%= last_name %></p>
            <p><strong>Email:</strong> <%= email %></p>
            <p><a href="logout.jsp">Logout</a></p>
        <%
            }
        %>
    </body>
</html>
