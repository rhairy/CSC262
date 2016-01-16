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
import java.util.*; // Get user input the only way I know how.

public class FileLineCount
{
	public static void main( String [] args )
	{
		// Ask for the name of a text file to open.
		try ( Scanner inScanner = new Scanner(System.in) ) {
			boolean keepGoing = false;
			do {

				System.out.print( "Please enter the name of the file to open: " );
				String fpath = "";
				if ( inScanner.hasNext() ) {
					fpath = inScanner.next();
				} else {
					fpath = "";
				}

				// Safely open the file for reading.
				File inFile = new File( fpath );

				int lineCount = 0;
				int charCount = 0;
				String lastLine = "";

				try ( Scanner fileScanner = new Scanner(inFile) ) {
					// Read file line by line and increment lineCount.
					while ( fileScanner.hasNextLine() ) {
						lastLine = fileScanner.nextLine();
						++lineCount;

						// For each line, count the chars and increment charCount.
						charCount += lastLine.length();
						
						// print out the first and second lines of the file.
						if ( lineCount <= 2 ) {
							System.out.printf( "Line %d: %s\n", lineCount, lastLine );
						} else {
							continue;
						}
					}
					// Print out the last line of the file.
					System.out.printf( "Last Line: %s\n", lastLine );	

					// At EOF, print the char and line counts.
					System.out.printf( "Program read %d lines and %d characters.\n", lineCount, charCount );

					// Ask the user if they want to go again?
					System.out.printf( "Would you like to count the words and characters in another file? (Y/n): " );
					String answer = inScanner.next();

					switch ( answer.toLowerCase() ) {
						case "y":
							keepGoing = true;
							break;
						case "n":
							keepGoing = false;
							break;
						default:
							keepGoing = false;
							System.out.println( "INVALID INPUT." );
							break;
					}

				} catch ( FileNotFoundException e ) {
					System.out.println( "Could not find the file!" );
				} catch ( NoSuchElementException e ) {
					System.out.println( "Scanner couldn't get any more input!" );
				} 
			} while ( keepGoing );
		} 
	}
}
///////////////////////////////////////////////////////////////////
//   End Of File						 //
///////////////////////////////////////////////////////////////////
