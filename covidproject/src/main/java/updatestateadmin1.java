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

@WebServlet("/updatestateadmin1 ")
public class updatestateadmin1 extends HttpServlet {
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
            String state = request.getParameter("state");

            // Validate input data
            if (userid == null || password == null || name == null || address == null || email == null || mobile == null || state == null) {
                out.println("Error: Missing parameters.");
                return;
            }

            // Database connection
            try (Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                 PreparedStatement pst = con.prepareStatement("UPDATE stateadmin SET email=?, password=?, username=?, address=?, mobileno=?, state=? WHERE userid=?")) {

                // Set parameters
                pst.setString(1, email);
                pst.setString(2, password);
                pst.setString(3, name);
                pst.setString(4, address);
                pst.setString(5, mobile);
                pst.setString(6, state);
                pst.setString(7, userid);

                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    out.println("Profile updated successfully!");
                    out.println("<html>");
                    out.println("<body>");
                  
                    out.println("</body>");
                    out.println("</html>");
                } else {
                    out.println("Update failed: No user found with the given userid.");
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
