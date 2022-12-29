package com.fixitytech.ecart;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnection {
	static Connection con;
	public static Connection getConnection()
	{
		if(con==null)
		{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecartdb","root","Root");		    
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		}
		return con;
	}
}
	
	
		