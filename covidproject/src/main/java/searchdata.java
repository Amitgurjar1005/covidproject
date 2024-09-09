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
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/searchdata")
public class searchdata extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database connection parameters
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/covid";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    // Method to process requests
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String state = request.getParameter("state");

            if (state == null || state.trim().isEmpty()) {
                out.println("<html>");
                out.println("<body>");
                out.println("<h3>No state found in the request.</h3>");
                out.println("<a href='home.jsp'>Back to Home</a>");
                out.println("</body>");
                out.println("</html>");
                return;
            }

            try {
                // Explicitly load the MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // Database connection
                try (Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                     PreparedStatement pst = con.prepareStatement("SELECT *FROM covidinfo WHERE state = ?")) {

                    // Set parameters
                    pst.setString(1, state);
                    try (ResultSet rs = pst.executeQuery()) {
                        if (rs.next()) {
                            out.println("<html>");
                            out.println("<body>");
                            out.println("<h3>Information for state: " + state + "</h3>");
                            out.println("<table border='1' cellspacing='0' cellpadding='5'>");
                            out.println("<tr>");
                            out.println("<th>Serial No</th><th>Date</th><th>State</th><th>Total</th><th>Active</th><th>Deaths</th><th>Pincode</th>");
                            out.println("</tr>");

                            do {
                                String serial = rs.getString("serial"); // Adjust column names as per your table schema
                                String date = rs.getString(1);
                                String state1 = rs.getString(2);
                                String total = rs.getString(3);
                                String active = rs.getString(4);
                                String deaths = rs.getString(5);
                                String pincode = rs.getString(6);

                                out.println("<tr>");
                                out.println("<td>" + serial + "</td>");
                                out.println("<td>" + date + "</td>");
                                out.println("<td>" + state1 + "</td>");
                                out.println("<td>" + total + "</td>");
                                out.println("<td>" + active + "</td>");
                                out.println("<td>" + deaths + "</td>");
                                out.println("<td>" + pincode + "</td>");
                                out.println("</tr>");
                                
                            } while (rs.next());

                            out.println("</table>");
                            out.println("<a href='userdashboard.jsp'>Back to Home</a>");
                            out.println("</body>");
                            out.println("</html>");
                        } else {
                            out.println("<html>");
                            out.println("<body>");
                            out.println("<h3>No information found for the state: " + state + "</h3>");
                            out.println("<a href='userdashboard.jsp'>Back to Home</a>");
                            out.println("</body>");
                            out.println("</html>");
                        }
                    }

                } catch (SQLException e) {
                    e.printStackTrace(); // Log the exception
                    out.println("<html>");
                    out.println("<body>");
                    out.println("<h3>Database error: " + e.getMessage() + "</h3>");
                    out.println("<a href='home.jsp'>Back to Home</a>");
                    out.println("</body>");
                    out.println("</html>");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace(); // Log the exception
                out.println("<html>");
                out.println("<body>");
                out.println("<h3>JDBC Driver not found: " + e.getMessage() + "</h3>");
                out.println("<a href='home.jsp'>Back to Home</a>");
                out.println("</body>");
                out.println("</html>");
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
