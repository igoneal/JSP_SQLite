/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.applogin;
/**
 * @author Godwin Idoje
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // Debug: Log the input
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            out.write("<h3>Error: Missing username or password.</h3>");
            return;
        }
        try {
            // Load SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");
            System.out.println("JDBC Driver loaded successfully.");
            // Database connection
            String dbURL = "jdbc:sqlite:C:/Users/user1/OneDrive/Documents/NetBeansProjects/sqlite3/gm1.db";
            try (Connection connection = DriverManager.getConnection(dbURL)) {
                // Query to validate login credentials
                String sql = "SELECT * FROM register WHERE username = ? AND password = ?";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    out.println("<h1>Welcome, " + username + "!</h1>");
                     //HttpSession session = request.getSession();
                     // Redirect to dashboard on successful login
                    response.sendRedirect("dashboard.jsp");
                } else {
                    out.println("<h1>Invalid username or password.</h1>");
                      // Set error message and forward back to login page
                    request.setAttribute("errorMessage", "Invalid username or password.");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.println("<h3>Error: JDBC Driver not found.</h3>");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<h3>Error: Database operation failed. " + e.getMessage() + "</h3>");
        }
    }
}
