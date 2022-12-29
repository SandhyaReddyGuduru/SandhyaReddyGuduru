package com.fixitytech.ecart;

public class CartItem extends Item {
	
	int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalamount() {
		// TODO Auto-generated method stub
		return getQuantity()*getPrice();
	}
	
	

}
