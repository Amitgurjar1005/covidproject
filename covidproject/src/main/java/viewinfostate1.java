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

@WebServlet("/viewinfostate1")
public class viewinfostate1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database connection parameters
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/covid";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    // Method to process requests
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            // Register JDBC driver (for older versions of JDBC driver)
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                out.println("<html>");
                out.println("<head><title>Error</title></head>");
                out.println("<body>");
                out.println("<h3>JDBC Driver not found: " + e.getMessage() + "</h3>");
                out.println("<a href='home.jsp'>Back to Home</a>");
                out.println("</body>");
                out.println("</html>");
                e.printStackTrace();
                return;
            }

            // Database connection
            try (Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                 PreparedStatement pst = con.prepareStatement("SELECT * FROM covidinfo");
                 ResultSet rs = pst.executeQuery()) {

                // Start HTML output
                out.println("<html>");
                out.println("<head><title>COVID-19 State Information</title></head>");
                out.println("<body>");
                out.println("<h3>COVID-19 Information</h3>");
                out.println("<p>Details about the state from the database:</p>");
                out.println("<table border='1' cellpadding='5' cellspacing='0'>");
                out.println("<tr>");
                out.println("<th>Serial No</th><th>Date</th><th>State</th><th>Total</th><th>Active</th><th>Deaths</th><th>State Code</th>");
                out.println("</tr>");

                // Iterate over result set and display data
                while (rs.next()) {
                    String serial = rs.getString(1);         // Use column names for better clarity
                    String date = rs.getString(2);
                    String state = rs.getString(3);
                    String total = rs.getString(4);
                    String active = rs.getString(5);
                    String deaths = rs.getString(6);
                    String stateCode = rs.getString(7);

                    out.println("<tr>");
                    out.println("<td>" + serial + "</td>");
                    out.println("<td>" + date + "</td>");
                    out.println("<td>" + state + "</td>");
                    out.println("<td>" + total + "</td>");
                    out.println("<td>" + active + "</td>");
                    out.println("<td>" + deaths + "</td>");
                    out.println("<td>" + stateCode + "</td>");
                    out.println("</tr>");
                }

                // End HTML output
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");

            } catch (SQLException e) {
                e.printStackTrace();
                out.println("<html>");
                out.println("<head><title>Error</title></head>");
                out.println("<body>");
                out.println("<h3>Database error: " + e.getMessage() + "</h3>");
                out.println("<a href='home.jsp'>Back to Home</a>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }
}
