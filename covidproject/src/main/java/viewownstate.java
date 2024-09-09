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
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/ viewownstate")
public class viewownstate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database connection parameters
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/covid";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    // Method to process requests
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String state = (String) session.getAttribute("state");
          

            if (state == null || state.isEmpty()) {
                out.println("<html>");
                out.println("<body>");
                out.println("<h3>No state found in session.</h3>");
                out.println("<a href='stateadmindashboard.jsp'>Back to Home</a>");
                out.println("</body>");
                out.println("</html>");
                return;
            }

            // Database connection
            try (Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                 PreparedStatement pst = con.prepareStatement("SELECT * FROM covidinfo WHERE state = ?")) {

                // Set parameters
                pst.setString(1, state);
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        out.println("<html>");
                        out.println("<body>");
                        out.println("<h3>Information for state: " + state + "</h3>");
                        out.println("<p>Details about the state from the database.</p>");
                        out.println("<table border=2px solid black>");
                        out.println("<tr>");
                        out.println("<th>Serial.no</th><th>Date</th><th>State</th><th>ToTal</th><th>Active</th><th>Deathes</th><th>pincode</th>");
                        out.println("</tr>");
                    
                       while(rs.next()) {
                        String  serial=rs.getString(1);
                        String  ideate=rs.getString(2);
                        String  state1=rs.getString(3);
                        String  total=rs.getString(4);
                        String  active=rs.getString(5);
                        String  deathes =rs.getString(6);
                        String  statecode =rs.getString(7);
                        out.println("<tr>");
                        out.println("<td>"+serial+"</td>");
                        out.println("<td>"+ideate+"</td>");
                        out.println("<td>"+state1+"</td>");
                        out.println("<td>"+total+"</td>");
                        out.println("<td>"+active+"</td>");
                        out.println("<td>"+deathes+"</td>");
                        out.println("<td>"+statecode+"</td>");
                        out.println("</tr>"); 
                       }
                       out.println("</table>");
                        out.println("</body>");
                        out.println("</html>");
                    } else {
                        out.println("<html>");
                        out.println("<body>");
                        out.println("<h3>No information found for the state: " + state + "</h3>");
                        out.println("<a href='stateadmindashboard.jsp'>Back to Home</a>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
                out.println("<html>");
                out.println("<body>");
                out.println("<h3>Database error: " + e.getMessage() + "</h3>");
                out.println("<a href='stateadmindashboard.jsp'>Back to Home</a>");
                out.println("</body>");
                out.println("</html>");
            }
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

