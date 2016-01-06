/* Calculator Application. */

import java.util.Scanner;

public class Calculator
{
	/* Check if a string is a valid integer. */
	public static boolean isInt(String str)
	{
		boolean result = true;

		try {
			Integer.parseInt(str);
		} catch (NumberFormatException e) {
			result = false;
		}

		return result;
	}

	public static void main(String[] args)
	{
		/* Instantiate Scanner object to take standard input. */
		Scanner inStream = new Scanner(System.in);

		/* Define variables to hold input. */
		String input;
		String operator;
		int number1;
		int number2;

		System.out.println("Press q at any time to quit.");

		/* Get the first value. */
		System.out.print("Enter the first value: ");
		input = inStream.next();

		if (input.equalsIgnoreCase("q")) {
			return;	
		} else if (isInt(input)) {
			number1 = Integer.parseInt(input);
		} else {
			System.out.println("Invalid input.");
			return;
		}
		
		input = "";

		/* Get the operator. */
		System.out.println("Enter an operator: + - * /");
		input = inStream.next();

		/* Evaluate input here, maybe use a case statement? */
	}
}
