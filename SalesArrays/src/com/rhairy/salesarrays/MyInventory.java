package com.rhairy.salesarrays;

public class MyInventory
{
	// Private instance variables.
	private int ProductNum;
	private double Price;
	private int Qty;
	
	// Public Methods.
	
	// Set the ProductNum, Price, and Qty for a MyInventory object.
	public void setInventory( int ProductNum, double Price, int Qty )
	{
		this.ProductNum = ProductNum;
		this.Price = Price;
		this.Qty = Qty;
	}
	
	// Accessor: Return the ProductNum.
	public int getProductNum()
	{
		return this.ProductNum;
	}
	
	// Accessor: Return the Price.
	public double getPrice()
	{
		return this.Price;
	}
	
	// Accessor: Return the qty.
	public int getQty()
	{
		return this.Qty;
	}
	
	// Mutator: Change the qty of the object.
	public void UpdateQty( int num )
	{
		this.Qty = num;
	}
}