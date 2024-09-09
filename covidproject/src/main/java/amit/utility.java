package amit;
import java.sql.*;
public class utility {
	private static Connection con;
	public static Connection connect() {
		  
			try {Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/covid","root","root");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
	return con;	
	}
}
