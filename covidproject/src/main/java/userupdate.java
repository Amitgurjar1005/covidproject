import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/userupdate")
public class userupdate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database connection parameters
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/covid";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    // Method to process requests
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            // Get parameters from request
            String userid = request.getParameter("userid");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String mobile = request.getParameter("mobile");

            // Validate input data
            if (userid == null || password == null || name == null || address == null || email == null || mobile == null) {
                out.println("<html><body><h3>Error: Missing parameters.</h3></body></html>");
                return;
            }

            // Database connection
            try (Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                 PreparedStatement pst = con.prepareStatement("UPDATE stateadmin SET email=?, mobileno=?, address=?, password=?, username=? WHERE userid=?")) {
                  
                // Set parameters
                pst.setString(1, email);
                pst.setString(2, mobile);
                pst.setString(3, address);
                pst.setString(4, password);
                pst.setString(5, name);
                pst.setString(6, userid);

                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    out.println("<html><body><h3>Profile updated successfully!</h3></body></html>");
                } else {
                    out.println("<html><body><h3>Update failed: No user found with the given userid.</h3></body></html>");
                }

            } catch (SQLException e) {
                // Log the exception (use a logging framework in production)
                e.printStackTrace();
                out.println("<html><body><h3>Database error: " + e.getMessage() + "</h3></body></html>");
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
