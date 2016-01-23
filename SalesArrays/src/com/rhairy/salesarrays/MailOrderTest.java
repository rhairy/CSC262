import com.rhairy.salesarrays.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MailOrderTest
{
	// Tests a string to determine if it is a valid integer.
	public static boolean isInt( String arg )
	{
		boolean result = false;
		try {
			Integer.parseInt( arg );
			result = true;
		} catch ( NumberFormatException e ) {
			result = false;
		}
		
		return result;
	}
	
	// Tests a string to determine if it is a valid double.
	public static boolean isDouble( String arg )
	{
		boolean result = false;
		try {
			Double.parseDouble(arg);
			result = true;
		} catch ( NumberFormatException e ) {
			result = false;
		}
		return result;
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
			
			// Get ProductNum input.
			do {
				try {
					System.out.print( "Enter a product number or -99 to quit: ");
					ProductNumAnswer = inputScanner.nextInt();
					isValid = true;
				} catch ( InputMismatchException e ) {
					isValid = false;
					System.out.println( "Invalid Input - You must enter an integer." );
					System.out.println( "" );
					inputScanner.next();
				}
			} while ( !isValid );
			
			if ( ProductNumAnswer == -99 ) {
				break;
			}
		
			// Check if the ProductNum is in the inventory.
			MyInventory product = new MyInventory();
			product = myOrder.getInventoryItem(ProductNumAnswer);
				
			if ( product != null ) {
				// Display the unit price and quantity available.
				if ( product.getQty() > 0 ) {
					System.out.printf( "Unit Price: %f \n", product.getPrice() );
					System.out.printf( "Quantity Available: %d \n", product.getQty() );
					System.out.println( "" );
					
					// Ask for an amount to order.
					// This could be turned into a method.
					isValid = true;
					do {
						try {
							System.out.print( "Enter quantity ordered: ");
							quantity = inputScanner.nextInt();
							isValid = true;
						} catch ( InputMismatchException e ) {
							isValid = false;
							System.out.println( "Invalid Input - You must enter an integer." );
							System.out.println( "" );
							inputScanner.next();
						}
					} while ( !isValid );
					// This could be turned into a method.
					
					// If the quantity requested is greater than the quantity available, give them the quantity available.
					if ( quantity > product.getQty() ) {
						quantity = product.getQty();
					}
					
					// Update the quantity of the item.
					product.UpdateQty( product.getQty() - quantity );
					
					// Print out the quantity sold.
					System.out.printf( "Quantity Sold: %d \n", quantity );
					
					// Update itemAmount and print it to the screen.
					itemAmount = quantity * product.getPrice();
					System.out.printf( "Item Amount: $%f\n", itemAmount );
					
					// Update the orderAmount.
					orderAmount += itemAmount;

				} else {
					System.out.println( "That item is out of stock. Please pick another one." );
				}
			} else {
				System.out.println( "Could not find the product" );
			}
		}
		// Display order total and say goodbye.
		System.out.println( "***" );
		System.out.printf ( "Order Total Amount: $%f \n", orderAmount );
		System.out.println( "***" );
		System.out.println( "Goodbye" );
	}
}