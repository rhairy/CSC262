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
	
	// No need to be implented due to the spec requiring getInventoryItem to return a reference to a MyInventory object.
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
	
	// Print inventory items to the screen.
	public void displayInventory()
	{
		for ( MyInventory i : inventory ) {
			System.out.println( "***" );
			System.out.printf( "Product Number: %d \n", i.getProductNum() );
			System.out.printf( "Price: $%f \n", i.getPrice() );
			System.out.printf( "Quantity: %d \n", i.getQty() );
		}
	}
}