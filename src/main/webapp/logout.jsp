<%-- 
    Document   : logout
    Created on : 20 Jan 2025, 18:17:20
    Author     : user1
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Logout</title>
    </head>
    <body>
        <%
            // Invalidate the session
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
        %>
        <h1>You have successfully logged out.</h1>
        <p><a href="login.jsp">Login Again</a></p>
    </body>
</html>

