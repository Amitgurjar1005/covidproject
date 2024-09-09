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

@WebServlet("/stateadminservlet1")
public class stateadminservlet1 extends HttpServlet {
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
                out.println("<html><body>");
                out.println("JDBC Driver not found: " + e.getMessage());
                out.println("</body></html>");
                return;
            }

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
                out.println("<html><body>");
                out.println("Error: Missing parameters.");
                out.println("</body></html>");
                return;
            }

            // Database connection
            try (Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                 PreparedStatement pst = con.prepareStatement("INSERT INTO stateadmin (email, password, username, address, mobileno, userid, state) VALUES (?, ?, ?, ?, ?, ?, ?)")) {

                // Set parameters
                pst.setString(1, email);
                pst.setString(2, password);
                pst.setString(3, name);
                pst.setString(4, address);
                pst.setString(5, mobile);
                pst.setString(6, userid);
                pst.setString(7, state);

                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    out.println("<html><body>");
                    out.println("Registration successful!");
                    out.println("<a href='superadmindashboard.jsp'>Go to Dashboard</a>");
                    out.println("</body></html>");
                } else {
                    out.println("<html><body>");
                    out.println("Registration failed.");
                    out.println("</body></html>");
                }

            } catch (SQLException e) {
                out.println("<html><body>");
                e.printStackTrace(out);
                //out.println("Database error: " + e.getMessage());
                out.println("</body></html>");
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
