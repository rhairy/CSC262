/***********************************************************/
// Assignment :  Calculator
// // by: Randall Harrison
// // Date: 2016-01-11
// // Description: Calculate integers.
// //  Notes: any special things you want me to consider.
// /***********************************************************/
// /***********************************************************/
// /*
// If there are any questions that need to be answered put them here as comments
// */	   
//
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
		String operator = "";
		int number1;
		int number2;
		int result = 0;

		System.out.println("This is Randy's calculator for Molly to do her math here at National University.");
		System.out.println("This program is written by Randy Harrison.");
		System.out.println("This calculator program does Addition, Subtraction, Multiplication, and Division.");

		/* Get the first value. */
		System.out.print("Enter your first value: ");
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
		System.out.print("Enter your operator \"+ - * /\": ");
		input = inStream.next();

		/* Evaluate input here, maybe use a case statement? */
		if (input.equalsIgnoreCase("q")) {
			return;
		} else if (input.equalsIgnoreCase("+") || input.equalsIgnoreCase("-") || input.equalsIgnoreCase("*") || input.equalsIgnoreCase("/")) {
			operator = input;
		} else {
			System.out.println("ERROR - Invalid Operator.");
			return;
		}

		/* Get the second value. */
		System.out.print("Enter your second value: ");
                input = inStream.next();
 
                if (input.equalsIgnoreCase("q")) {
                        return;
                } else if (isInt(input)) {
                        number2 = Integer.parseInt(input);
                } else {
                        System.out.println("Invalid input.");
                        return;
                }

		/* Perform the calculation. */
		switch (operator) {
			case "+": result = number1 + number2;
				break;
			case "-": result = number1 - number2;
				break;
			case "*": result = number1 * number2;
				break;
			case "/": result = number1 / number2;
				break;
			default: System.out.println("ERROR - Could not calculate.");
				break;
		}
		
		System.out.printf("Your total of %d %s %d is %d.\n", number1, operator, number2, result);
	}
}
///////////////////////////////////////////////////////////////////
/////   End Of File
/////////////////////////////////////////////////////////////////////
