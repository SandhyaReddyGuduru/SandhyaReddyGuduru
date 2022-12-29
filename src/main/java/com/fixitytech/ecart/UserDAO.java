package com.fixitytech.ecart;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

public class UserDAO {
	
		
		public List<User> getUsers()
		{
        List<User> users=new Vector<User>();
		try {
			Connection con=DbConnection.getConnection();
			PreparedStatement pst=con.prepareStatement("select * from users where username=?,password=?");
			//pst=setString(1,username);
			//pst=setString(2,password);
			
			ResultSet rs=pst.executeQuery();
			
			if(rs.next()) {
			User user=new User();
			
			user.setUsername(rs.getString(1));
			user.setPassword(rs.getString(2));
			user.setFullname(rs.getString(3));
			user.setEmail(rs.getString(4));
			user.setMobile(rs.getString(5));
			
		     users.add(user);
		   }}
			catch(Exception e) {
			   e.printStackTrace();
		    }
		    return users;
	}
	private PreparedStatement setString(int i, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecartdb","root","Root");
		    return con;
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}
	
	public boolean save(User user)
	{
		try
		{
		Connection con=DbConnection.getConnection();
		PreparedStatement pst=con.prepareStatement("insert into users values(?,?,?,?,?)");
		
		pst.setString(1, user.getUsername());
		pst.setString(2, user.getPassword());
		pst.setString(3, user.getFullname());
		pst.setString(4, user.getEmail());
		pst.setString(5, user.getMobile());
		
		
		int n=pst.executeUpdate();
		if(n>0)
			return true;
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return false;
	    
	}
	public static User  getUser(String username)
	{
		try
		{

			Connection con=DbConnection.getConnection();
			PreparedStatement pst=con.prepareStatement("select * from users where username=?");
			pst.setString(1,username);
			
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				User u=new User();
			u.setUsername(rs.getString(1));
			u.setPassword(rs.getString(2));
			u.setFullname(rs.getString(3));
		    u.setEmail(rs.getString(4));
			u.setMobile(rs.getString(5));
				
				return u;
			}
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return null;
		}
	
	public boolean validate(String username, String password) {
		try
		{
			Connection con=DbConnection.getConnection();
			PreparedStatement pst=con.prepareStatement("select * from users where username=? and password=?");
			pst.setString(1,username);
			pst.setString(2,password);
			//pst.setString(3,fullname);
			//pst.setString(4,email);
			//pst.setString(5,mobile);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getString(1));
				return true;
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return false;
	}
	
	}

