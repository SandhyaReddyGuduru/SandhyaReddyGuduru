package com.fixitytech.ecart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class AdminDAO {
	public List<User> getAllUsers()
	  {
		List<User> users=new Vector<User>();
		  try {
		    	Connection con=DbConnection.getConnection();
				 PreparedStatement st1 = con.prepareStatement("select * from users");
				 ResultSet rs=st1.executeQuery();
				while(rs.next())
				{
					User user=new User();
					user.setUsername(rs.getString(1));
					user.setEmail(rs.getString(4));
					user.setMobile(rs.getString(5));
					users.add(user);
				}
		  }
		  catch(Exception e) {
	    		e.printStackTrace();
	    	}
		  return users;
	  }
	
  public List<Order> getAllOrders(String username){

  		List<Order> orders=new Vector<Order>();

  		try
  		{
  			
  			Connection con=DbConnection.getConnection();
  			
  			PreparedStatement pst=con.prepareStatement("select * from orders");
  			PreparedStatement pst1=con.prepareStatement("select * from orderItems where orderId=?");
  			
  			
  			ResultSet rs=pst.executeQuery();
  					while(rs.next())
  					{
  						
  						Order or=new Order();
  						or.setOrderid(rs.getInt(1));
  						or.setUserId(rs.getString(3));
  						or.setTotalamount(rs.getDouble(2));    						
  						pst1.setInt(1, or.getOrderid());
  						
  						ResultSet rs1=pst1.executeQuery();
  						List<OrderItem> oitems=new Vector<OrderItem>();
  						while(rs1.next())
  						{
  							OrderItem orderItem=new OrderItem();
  							orderItem.setId(rs1.getInt(2));
  							orderItem.setName(rs1.getString(3));
  							orderItem.setPrice(rs1.getDouble(4));
  							orderItem.setQuantity(rs1.getInt(5));
  							oitems.add(orderItem);  							
  						}   	
  						or.setOrderItems(oitems);
  						orders.add(or);   						
  					}   			
  		}
  		catch (Exception e) {
  			e.printStackTrace();
			}
  		
  		
  		return orders;
  	
  	
  }
  public List<User> getallusers(String username){

		List<User> users=new Vector<User>();

		try {
				           
			Connection con = DbConnection.getConnection();
		    PreparedStatement st = con.prepareStatement("select * from users ");
		    ResultSet rs = st.executeQuery();
		    while(rs.next())
			{
		    	User user = new User();
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
			    user.setFullname(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setMobile(rs.getString(5));
				users.add(user);
						
		    }}
		
		    catch (Exception e) {
			  e.printStackTrace();
			}
		
		
		    return users;
	
	
}

  public int setStatus(int status,int orderId)
  {
		try
		{	
			Connection con=DbConnection.getConnection();		
			PreparedStatement ps=con.prepareStatement("update orders set status=? where orderId=?");
			ps.setInt(1, status);
			ps.setInt(2, orderId);
			ps.executeUpdate();	
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
		return orderId;
  }
  
  public void addItem(int id,String name,double price)
  {
		Connection con=DbConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("insert into items (id,name,price) value (?,?,?)");
			ps.setInt(1,id);
			ps.setString(2, name);
			ps.setDouble(3, price);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
  	
  }
}

