/**********************************************************/
// Assignment :  GuessaTron
// by: Randall Harrison
// // Date: 2016-01-11
// // Description: Program to guess a number from 1 to 100.
// //  Notes: any special things you want me to consider.
// //***********************************************************
// //************************************************************
// If there are any questions that need to be answered put them here as comments
// */

import java.util.Scanner;

public class GuessaTron 
{
	public static boolean isValid(String command)
	{
		boolean result = false;

		switch (command) {
			case "H":
				result = true;
				break;
			case "L":
				result = true;
				break;
			case "Q":
				result = true;
				break;
			case "C":
				result = true;
				break;
			default:
				System.out.printf("ERROR - %s is an invalid command.\n", command);
				result = false;
				break;
		}
		return result;
	}

	public static void main(String[] args)
	{
		int upper = 100;
		int lower = 1;
		int offer = 50;
		
		String input;

		Scanner inStream = new Scanner(System.in);
		
		System.out.println("Welcome to GuessaTron the smartest computer program in the world.");
		System.out.println("I am going to guess the number you chose as long as it is between 1 and 100.");
		System.out.println("You will think I am reading your mind.");
		
		do {
			System.out.printf("Computer says %d. Is your number higher or lower?\n", offer);
                        input = inStream.next();

			switch (input) {
				case "C":
					System.out.println("RECORD TIME!");
					break;
				case "L": 
					upper = offer;
					offer = (upper + lower) / 2;
					break;
				case "H":
					lower = offer;
					offer = (upper + lower) / 2;
					break;
				case "Q":
					System.out.println("YOU QUIT - Thanks for playing!");
					return;
				default:
					System.out.println("INVALID COMMAND - Try again.");
					break;
			}
			} while (!input.equals("C"));

		System.out.printf("Your number was: %d\n", offer);	
	}
}
 								   

 								   	   
 								   	   	   
 								   	   	  

///////////////////////////////////////////////////////////////////
///   End Of File
///////////////////////////////////////////////////////////////////
