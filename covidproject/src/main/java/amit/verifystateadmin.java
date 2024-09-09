package amit;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import amit.utility;

/**
 * Servlet implementation class verifyusers
 */
public class verifystateadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verifystateadmin () {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    private Connection con;
    private PreparedStatement psl;
    public void init() {
    	try {
    		con=utility.connect();
    		psl=con.prepareStatement("Select *from stateadmin where userid=? and password=?");

    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
   public void destroy() {
	   try {
   		con.close();
   	}catch(Exception e){
   		e.printStackTrace();
   	}
	   
   }
    
    
    
    
    
    
    protected void processrequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
    	 String userid = request.getParameter("userid");
         String password = request.getParameter("password");
        String users = request.getParameter("users");
    	 if(users.equals("SUPER-ADMIN"))
    	 { if(userid.equals("AMIT200")&&password.equals("4567"))
    	 {
    		 response.sendRedirect("superadmindashboard.jsp");
    	 }else
    	 {
    		 out.print("<html>");
    		 out.print("<body>");
    		 out.print("<h3>INVALID PASSWORD<h3>");
    		 out.print("<h1><a href=\"home.jsp\">home</a></h1>");
    		 out.print("<html>");
    		 out.print("<body>");
    	 }	 
    	 }else if(users.equals("STATE-ADMIN")) {
    		 out.println("WELCOME ");
    	 }
    	 try {
    		 psl.setString(1, userid);
    		 psl.setString(2, password);
    	    ResultSet rs=psl.executeQuery();
    	    boolean found=rs.next();
    	    if(found){
    	    	out.println("welcome stateadmin");
    	    }    	    		
    	    else
    	    {
    	    	out.println("invalid password");
    	    }
    	 }catch(Exception e) {
    		 e.printStackTrace();}
    	 }


    
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processrequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		processrequest(request,response);
	}

}
