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

@WebServlet("/Registration")
public class Registration extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String userid2 = request.getParameter("userid");
            String password1 = request.getParameter("password");
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String mobile = request.getParameter("mobile");

            // Validate input data
            if (userid2 == null || password1 == null || name == null || address == null || email == null || mobile == null) {
                out.println("Error: Missing parameters.");
                return;
            }

            // Database connection
            String jdbcURL = "jdbc:mysql://localhost:3306/covid";
            String dbUser = "root";
            String dbPassword = "root";

            try (Connection con = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
                 PreparedStatement pst = con.prepareStatement("INSERT INTO users (email, password, name, address, mobile, userid) VALUES (?, ?, ?, ?, ?, ?)")) {

                // Set parameters
                pst.setString(1, email);
                pst.setString(2, password1);
                pst.setString(3, name);
                pst.setString(4, address);
                pst.setString(5, mobile);
                pst.setString(6, userid2);

                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    out.println("Registration successful!");
                } else {
                    out.println("Registration failed.");
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
