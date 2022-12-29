package com.fixitytech.ecart;

import java.util.List;

public class Order {
    public int orderid;
    public double totalamount;
    public String userId;
    
    List<OrderItem> orderItems;
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
    public int getOrderid() {
        return orderid;
    }
    public void setOrderid(int orderid) {
    	
        this.orderid = orderid;
    }
    public double getTotalamount() {
        return totalamount;
    }
    public void setTotalamount(double totalamount) {
        this.totalamount = totalamount;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
	 

