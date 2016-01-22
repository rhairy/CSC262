import com.rhairy.salesarrays.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MailOrderTest
{
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
			String [] lineSplits;
			
			while ( inventoryScanner.hasNextLine() ) {
				++lineCount;
				if ( lineCount == 1 ) {
					continue;
				} else {
					line = inventoryScanner.nextLine();
					lineSplits = line.split(",");
					System.out.printf( "Line %d contains: %s, %s, %s\n", lineCount, lineSplits[0], lineSplits[1], lineSplits[2] );
				}
			}
		} catch ( FileNotFoundException e) {
			System.out.printf( "Could not find file: %s\n", filePath );
		}
	}
}