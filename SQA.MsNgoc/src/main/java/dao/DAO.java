package dao;
 

import java.sql.Connection;
import java.sql.DriverManager;


 
public class DAO {
    public static Connection con;

	public DAO() {
		if(con==null) {
			String dbUrl = "jdbc:mysql://localhost:3306/sqa2022?autoReconnect=true&useSSL=false";
	        String dbClass = "com.mysql.jdbc.Driver";

	        try {
	            Class.forName(dbClass);
	            con = DriverManager.getConnection (dbUrl, "root", "nhuphuoc0704");
	        }catch(Exception e) {
	            e.printStackTrace();
	        }
		}
		
	}
    
}