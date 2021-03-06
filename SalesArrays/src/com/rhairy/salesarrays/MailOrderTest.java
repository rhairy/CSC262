/***********************************************************
// Assignment :  SalesArray
// by: Randall Harrison
// Date: 2016-01-25
// Description: Reads an inventory from a csv file and allows the user to make purchases.
//  Notes: any special things you want me to consider.
//***********************************************************
//************************************************************
If there are any questions that need to be answered put them here as comments
*/

import com.rhairy.salesarrays.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MailOrderTest
{
	// Gets an integer input.
	public static int getIntRepeat( String promptMsg, String errorMsg )
	{	
		Scanner inputScanner = new Scanner(System.in);
		int result = 0;
		boolean valid = true;
			
		do {
			
			try {
				
			System.out.printf( "%s", promptMsg );
			result = inputScanner.nextInt();
			valid = true;
			
			} catch ( InputMismatchException e ) {
				
				valid = false;
				System.out.printf( "%s\n", errorMsg );
				inputScanner.next();			
			}
			
		} while ( !valid );
		
		return result;
	}
	
	// Prompt the user to press enter to continue.
	public static void pressEnter()
	{
		Scanner inputScanner = new Scanner(System.in);
		
		System.out.print( "Press enter to Continue...");
		inputScanner.nextLine();
	}
	
	public static void main( String [] args )
	{
		// Introduce program.
		System.out.println( "Welcome to the MailOrderTest program." );
		System.out.println( "This program read an inventory list from a csv and simulate the purchasing of one item." );
		
		String filePath = "";
		
		// Get the file path from the user and instantiate a File object.
		Scanner inputScanner = new Scanner(System.in);
		System.out.print( "Enter the path to the inventory file (.csv): " );
		filePath = inputScanner.next();
		
		File inventoryFile = new File(filePath);
		
		// Instantiate MailOrders Object.
		MailOrders myOrder = new MailOrders();
		
		// Open csv file and add it to the MailOrder object as a MyInventory object.
		try ( Scanner inventoryScanner = new Scanner(inventoryFile);) {
			int lineCount = 0;
			String line = "";
			String [] lineSplit;
			int ProductNum = 0;
			double Price = 0;
			int Qty = 0;
			boolean lineValid;
			
			while ( inventoryScanner.hasNextLine() ) {
				++lineCount;
				
				// Split up data delimited by comma.
				line = inventoryScanner.nextLine();
				lineSplit = line.split(",");
				
				// Check if supplied input was valid.
				try {
					ProductNum = Integer.parseInt(lineSplit[0]);
					Price = Double.parseDouble(lineSplit[1].replace('$',' '));
					Qty = Integer.parseInt(lineSplit[2]);
					lineValid = true;
				} catch ( NumberFormatException e ) {
					lineValid = false;
				}
				
				if ( lineValid ) {
					// Fill out MailOrders object with good input.
					myOrder.FillInventory( ProductNum, Price, Qty );
				}
				else {
					// Skip the bad input.
					continue;
				}		
			}
		} catch ( FileNotFoundException e) {
			System.out.printf( "Could not find file: %s\n", filePath );
		}
		
		// Ask user to enter a product number or -99 to quit; prompt them until they do.
		boolean isValid = true;
		int ProductNumAnswer = 0;
		int quantity = 0;
		double orderAmount = 0;
		double itemAmount = 0;
		
		while ( true ) {
			
			// Print Inventory List.
			myOrder.displayInventory();
			pressEnter();
			
			// Get ProductNum.
			ProductNumAnswer = getIntRepeat( "Enter a product number or -99 to quit: ", "Invalid Input - You must enter an integer." );
			
			if ( ProductNumAnswer == -99 ) {
				break;
			}
		
			// Check if the ProductNum is in the inventory.
			if ( myOrder.doesProductExist(ProductNumAnswer) ) {
				
				// Display the unit price and quantity available.
				if ( myOrder.getProductQty( ProductNumAnswer ) > 0 ) {
					System.out.printf( "Unit Price: %f \n",  myOrder.getProductPrice(ProductNumAnswer) );
					System.out.printf( "Quantity Available: %d \n", myOrder.getProductQty(ProductNumAnswer) );
					System.out.println( "" );
					
					// Ask for an amount to order.
					quantity = getIntRepeat( "Enter a quantity ordered: ", "Invalid Input - You must enter an integer." );
					
					// If the quantity requested is greater than the quantity available, give them the quantity available.
					if ( quantity > myOrder.getProductQty(ProductNumAnswer) ) {
						quantity = myOrder.getProductQty(ProductNumAnswer);
					}
					
					// Update the quantity of the item.
					myOrder.ProcessOrder( ProductNumAnswer, quantity );
					
					// Print out the quantity sold.
					System.out.printf( "Quantity Sold: %d \n", quantity );
					
					// Update itemAmount and print it to the screen.
					itemAmount = quantity * myOrder.getProductPrice(ProductNumAnswer);
					System.out.printf( "Item Amount: $%f\n", itemAmount );
					
					// Update the orderAmount.
					orderAmount += itemAmount;
					
					pressEnter();

				} else {
					System.out.println( "That item is out of stock. Please pick another one." );
					pressEnter();
				}
			} else {
				System.out.println( "Could not find the product" );
				pressEnter();
			}
			
		}
		// Display order total and say goodbye.
		System.out.println( "***" );
		System.out.printf ( "Order Total Amount: $%f \n", orderAmount );
		System.out.println( "***" );
		System.out.println( "Goodbye" );
	}
}

///////////////////////////////////////////////////////////////////
///   End Of File												///
///////////////////////////////////////////////////////////////////