package com.fixitytech.ecart;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.Vector;

public class ItemDAO {

	//boolean validate(String username,String password) 
	
	
		public List<Item> getItems()
		{
			List<Item> items=new Vector<Item>();
		    try {
			Connection con=DbConnection.getConnection();
			PreparedStatement pst=con.prepareStatement("select * from items");
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
		    Item it=new Item();
			
			it.setId(rs.getInt(1));
			it.setName(rs.getString(2));
			it.setPrice(rs.getDouble(3));

	        items.add(it);
	        }
			}
	        
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	     return items;
	}
		public static Item getItem(String itemId)
		{

		    try {
			Connection con=DbConnection.getConnection();
			PreparedStatement pst=con.prepareStatement("select * from items where id=?");
			pst.setString(1,itemId);
			//pst=setString(2,name);
			//pst=setString(3,price);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
		    Item it=new Item();
			
			it.setId(rs.getInt(1));
			it.setName(rs.getString(2));
			it.setPrice(rs.getDouble(3));
			
			return it;
		    }
			
		    }
			
			catch(Exception e) {
			   e.printStackTrace();
		    }
		return null;
		}
		public  boolean additem(int id,String name,double price)
		{
			Connection con=DbConnection.getConnection();
			int n=0;
			try {
				
				PreparedStatement st;
				st=con.prepareStatement("insert into items(id,name,price) values(?,?,?)");
				st.setInt(1,id);
				st.setString(2,name);
				st.setDouble(3,price);
			
				
		    n=st.executeUpdate();
						return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return false;
			}
}
		

	
		
		
		
/*			Blob blob=rs.getBlob(4);
			if(blob!=null)
	        {
	        InputStream inputStream = blob.getBinaryStream();
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        byte[] buffer = new byte[4096];
	        int bytesRead = -1;

	        try {
	            while ((bytesRead = inputStream.read(buffer)) != -1) {
	                outputStream.write(buffer, 0, bytesRead);                  
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        byte[] imageBytes = outputStream.toByteArray();
	        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	        it.setBase64Image(base64Image);


	        try {
	            inputStream.close();
	            outputStream.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        }*/
			
		