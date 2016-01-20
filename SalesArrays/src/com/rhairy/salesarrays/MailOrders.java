package com.rhairy.salesarrays;

import java.util.ArrayList;

public class MailOrders
{
	// Private Instance Variables.
	private ArrayList<MyInventory> inventory = new ArrayList<MyInventory>();
	
	// Public Methods.
	
	// Populates the ArrayList with MyInventory objects.
	public void FillInventory( int ProductNum, double Price, int Qty )
	{
		// Instantiate a MyInventory object with the supplied parameters, and add it to the ArrayList.
		MyInventory temp = new MyInventory();
		
		temp.setInventory( ProductNum, Price, Qty );
		
		inventory.add( temp );
	}
	
	public MyInventory ProcessOrder( int ProductNum, int Qty )
	{
		return null;
	}
	
	// Iterate through the ArrayList and return the MyInventory object with the provided ProductNum.
	public MyInventory getInventoryItem( int ProductNum )
	{
		for ( MyInventory i : inventory ) {
			if ( i.getProductNum() == ProductNum ) {
				return i;
			} else {
				continue;
			}
		}
		return null;
	}
}