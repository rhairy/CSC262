// Car.java; My car class!

import java.util.InputMismatchException;
import java.util.Scanner;

public class Car
{
	// Private instance variables.
	private int year;
	private String make;
	private int speed;
	private String type;

	// Constructor.
	Car( int year, String make, String type )
	{
		this.year = year;
		this.make = make;
		this.type = type;
		this.speed = 0;
	}

	// Public accessor methods.
	public int getYear()
	{
		return this.year;
	}

	public String getMake()
	{
		return this.make;
	}

	public String getType()
	{
		return this.type;
	}

	public int getSpeed()
	{
		return this.speed;
	}

	// Public mutator methods.
	public void accelerate()
	{
		this.speed += 7;
	}
	
	public void brake()
	{
		if ( this.speed - 5 < 0 ) {
			this.speed = 0;
		} else {
			this.speed -= 5;
		}
	}

	// Main routine to demonstrate usage of the class.
	public static void main( String [] args )
	{
		boolean isValid = false;
		Scanner inScanner = new Scanner( System.in );	

		// Car variables.
		String type;
		String model;
		int year;
		
		do {
			try {
				System.out.print( "Enter the type of car you own: " );
				type = inScanner.next();	
				isValid = false;
			} catch ( IllegalArgumentException e ) {
				System.out.println( "INVALID INPUT - Please try again." );
			}
		} while ( isValid );	

		do {
			try {
				System.out.print( "Enter the model of the car you own: " );
				model = inScanner.next();
				isValid = false;
			} catch ( IllegalArgumentException e ) {
				System.out.println( "INVALID INPUT - Please try again." );
			}
		} while ( isValid );
			
		do {
			try {
				System.out.print( "Enter the year of the car you own: " );
				year = inScanner.nextInt();
				isValid = true;
			} catch ( InputMismatchException e ) {
				System.out.println( "INVALID INPUT - You must enter an integer for this value." );
				inScanner.next();
			}
		} while ( !isValid );
	}	
}
