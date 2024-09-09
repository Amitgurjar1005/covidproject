import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/covidinfoservlet1  ")
public class covidinfoservlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Database connection parameters
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/covid";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    // Method to process requests
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            // Load JDBC driver (not always needed if using recent JDBC versions)
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                out.println("JDBC Driver not found: " + e.getMessage());
                return;
            }

            // Get parameters from request
           
            
          String userid = request.getParameter("userid");
            String password = request.getParameter("state");
            String name = request.getParameter("total");
            String address = request.getParameter("cases");
            String email = request.getParameter("deathes");
            String statecode = request.getParameter("statecode");
            
            HttpSession session=request.getSession();
            session.setAttribute("state",password);
            
            
            java.util.Date dt=new java.util.Date();
            long val=dt.getTime();
            java.sql.Date idate=new  java.sql.Date(val);

            // Validate input data
            if (userid == null || password == null || name == null || address == null || email == null ) {
                out.println("Error: Missing parameters.");
                return;
            }

            // Database connection
            try (Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                 PreparedStatement pst = con.prepareStatement("INSERT INTO covidinfo (idate, state,total,active,deathes, userid,statecode) VALUES (?, ?, ?, ?, ?, ?,?)")) {
              
            	
            	
            	
              // Set parameters
                pst.setDate(1,idate);
                pst.setString(2, password);
                pst.setString(3, name);
                pst.setString(4, address);
                pst.setString(5,email);
                pst.setString(6,userid);
                pst.setString(7,statecode);
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    out.println("information submit successful!");
          out.println("<html>");
          out.println("<body>");
          out.println("<a href='stateadmindashboard.jsp'>dashboard</a>");
          out.println("<body>");
          out.println("<html>");
          
          
         
          
                } else {
                    out.println("information submit not successful!");
                }

            } catch (SQLException e) {
                e.printStackTrace();
                out.println("Database error: " + e.getMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}