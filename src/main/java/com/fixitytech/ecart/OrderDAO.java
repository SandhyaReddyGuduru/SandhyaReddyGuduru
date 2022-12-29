package com.fixitytech.ecart;


	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
import java.util.List;
import java.util.Vector;



	public class OrderDAO {
	    
	    public static int saveOrder(Order o)
	    {
	        
	        Connection con=DbConnection.getConnection();	        
	        try
	        {
	            con.setAutoCommit(false);
	            PreparedStatement ps=con.prepareStatement("insert into orders(Totalamount,Userid)values (?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
	            ps.setDouble(1,o.getTotalamount());
	            ps.setString(2,o.getUserId());
	          int n=ps.executeUpdate();
	            if(n>0)
	            {
	            ResultSet rs=ps.getGeneratedKeys();
	            rs.next();
	            int orderId=rs.getInt(1);
	            PreparedStatement pst=con.prepareStatement("insert into orderitems(Itemid,Itemname,Itemprice,Itemquantity,orderid)values (?,?,?,?,?)");
	            
	            for(OrderItem orderItem:o.getOrderItems())
	            {
	                pst.setInt(1, orderItem.getId());
	                pst.setString(2, orderItem.getName());
	                pst.setDouble(3, orderItem.getPrice());
	                pst.setInt(4, orderItem.getQuantity());
	                pst.setInt(5,orderId);
	                pst.executeUpdate();
	            }
	            
	            con.commit();
	            return orderId;    
	            }    
	            }
	        catch(Exception e)
	        {

	           try {
	                con.rollback();
	            } catch (SQLException e1) {
	                
	                e1.printStackTrace();
	            }
	            
	            e.printStackTrace();
	        }
	        return  -1;
	    }
	   
	    
	        List<Order> getMyOrders(String username)
	    	{
	    		List<Order> orders=new Vector<Order>();
	    		
	    		try
	    		{
	    			
	    			Connection con=DbConnection.getConnection();
	    			
	    			PreparedStatement pst=con.prepareStatement("select * from orders where Userid=?");
	    			PreparedStatement pst1=con.prepareStatement("select * from orderitems where orderid=?");	    			
	    			pst.setString(1, username);	    			
	    			ResultSet rs=pst.executeQuery();
	    					while(rs.next())
	    					{
	    						
	    						Order or=new Order();
	    						or.setOrderid(rs.getInt(1));
	    						or.setUserId(rs.getString(3));
	    						or.setTotalamount(rs.getDouble(2));
	                            
	    						pst1.setInt(1,or.getOrderid());
	    						
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
					// TODO: handle exception
	    			e.printStackTrace();
				}
	    		
	    		
	    		return orders;
	    	}


			public int changeStatus(int orderId, int status) 
			{

				 Connection con=DbConnection.getConnection();
				 try {
					PreparedStatement pst=con.prepareStatement("update orders set status=? where Orderid=?");
					pst.setInt(1, status);
					pst.setInt(2, orderId);
					pst.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				return orderId;
			}
			
//-------------------------------------------------------------------------------------------
			 List<Order> getAllOrders()
		    	{
				 List<Order> orders=new Vector<Order>();
				 
				 try
				 {
					 Connection con=DbConnection.getConnection();
					 
					 
					 PreparedStatement pst=con.prepareStatement("select * from orders");
					 ResultSet rs=pst.executeQuery();
					 while(rs.next())
					 {
						Order order=new Order();
						order.setOrderid(rs.getInt(1));
						order.setTotalamount(rs.getDouble(2));
						order.setUserId(rs.getString(3));
						orders.add(order);
					 }
					 
					 
				 }
				 catch(Exception e)
				 {
					 
				 }
				 return orders;
		    	}
//-------------------------------------------------------------------------------------------
	    		
	    	}
	    
	    	
	        