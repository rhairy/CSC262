import com.rhairy.salesarrays.*;
import java.io.File;
import java.io.FileNotFoundException;
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
		try ( Scanner inputScanner = new Scanner(System.in) ) {
			System.out.print( "Enter the path to the inventory file (.csv): " );
			filePath = inputScanner.next();
		} 
		
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
	}
}