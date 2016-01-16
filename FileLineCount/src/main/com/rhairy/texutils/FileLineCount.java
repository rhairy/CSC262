/*
// Assignment :  FileLineCount
// by: Randall Harrison
// // Date: 2016-01-20
// // Description: Count the number of chars and lines in a provided text file.
// //  Notes: any special things you want me to consider.
// //***********************************************************
// //************************************************************
// If there are any questions that need to be answered put them here as comments
*/

package com.rhairy.texutils;

import java.io.*;
import java.util.Scanner; // Get user input the only way I know how.

public class FileLineCount
{
	public static void main( String [] args )
	{
		// Ask for the name of a text file to open.
		Scanner inScanner = new Scanner( System.in );
		System.out.print( "Please enter the name of file to open: " );
		String fpath = inScanner.next();

		// Safely open the file for reading.
		File inFile = new File( fpath );

		try ( Scanner fileScanner = new Scanner(inFile) ) {

		} catch ( FileNotFoundException e ) {
			System.out.println( "Could not find the file!" );
		}  

		// Read file line by line and increment lineCount.
		
			// For each line, count the chars and increment charCount.
			
		// At EOF, print the char and line counts.

		// Ask the user if they want to go again?
	}
}
 					
///////////////////////////////////////////////////////////////////
//   End Of File						 //
///////////////////////////////////////////////////////////////////
