package amit;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class verifyusers
 */
public class verifyusers1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verifyusers1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    private Connection con;
    private PreparedStatement psl,psm;
    public void init() {
    	try {
    		con=utility.connect();
    		psl=con.prepareStatement("Select *from users where userid=? and password=?");
    		psm=con.prepareStatement("Select *from stateadmin where userid=? and password=?");
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
    	 }
    		 
    	 
    	 else if(users.equals("STATE-ADMIN")) {
    		
    		 
    		 
    		 try {
        		 psm.setString(1, userid);
        		 psm.setString(2, password);
        	   
        		 ResultSet rs=psm.executeQuery();
        	    
        	    boolean found=rs.next();
        	    if(found){
        	    	String r=rs.getString("userid");
        	    	
        	    	out.println("welcome state admin");
        	    	response.sendRedirect("stateadmindashboard.jsp");
        	    	
        	    	
        	    	
        	    	
        	    }  	    		
        	    else
        	    {
        	    	out.println("invalid password");
        	    }
        	 }catch(Exception e) {
        		 e.printStackTrace();
    		 
    		 
    		 }
    		 	 
    	 }else if(users.equals("USERS"))
    	 try {
    		 psl.setString(1, userid);
    		 psl.setString(2, password);
    	    ResultSet rs=psl.executeQuery();
    	    boolean found=rs.next();
    	    if(found){
    	    	response.sendRedirect("userdashboard.jsp");
    	    }    	    		
    	    else
    	    {
    	    	out.println("invalid password");
    	    }
    	 }catch(Exception e) {
    		 e.printStackTrace();}
    	 }


    
    
    
    
	private void resendRedirect(String string) {
		// TODO Auto-generated method stub
		
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