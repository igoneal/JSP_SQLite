/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.applogin;
/**
 *
 * @author Godwin Idoje
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = {"/Registration"})


public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        try {
            // Load SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");
            System.out.println("JDBC Driver loaded successfully.");
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String firstname = request.getParameter("first_name");
            String lastname = request.getParameter("last_name");
            String email = request.getParameter("email");
            // SQLite database connection setup
            String dbURL = "jdbc:sqlite:C:/Users/user1/OneDrive/Documents/NetBeansProjects/sqlite3/gm1.db"; // Adjust path if needed
            try (Connection connection = DriverManager.getConnection(dbURL)) {
                
                // SQL query to insert data
                String sql = "INSERT INTO register (username,password,first_name, last_name,email) VALUES (?, ?,?,?,?)";
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                pstmt.setString(3, firstname);
                pstmt.setString(4, lastname);
                pstmt.setString(5, email);
                int result = pstmt.executeUpdate(); // Execute the query

                // Send response to the client
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                if (result > 0) {
                    out.println("<h3>You have successfully registered!</h3>");
                    response.sendRedirect("login.jsp");
                } else {
                    out.println("<h3>Error: Your registration was not successful.</h3>");
                }
                out.println("</body></html>");
            }

        } catch (SQLException e) {
            // Log the error for debugging (do not show SQL errors to the user)
            System.err.println("Error: Database operation failed. " + e.getMessage());
            response.getWriter().write("An error occurred while processing your request. Please try again later.");
        } catch (ClassNotFoundException e) {
            System.err.println("SQLite JDBC Driver not found!");
            response.getWriter().write("An error occurred while processing your request. Please try again later.");
        }
    }
    
}
