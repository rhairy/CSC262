/*
// Assignment :  Car
// by: Randall Harrison
// // Date: 2016-01-20
// // Description: Car class example.
 Notes: any special things you want me to consider.
// //***********************************************************
// //************************************************************
// If there are any questions that need to be answered put them here as comments
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Car
{
	// Private instance variables.
	private int year;
	private String make;
	private int speed;
	private String type;
	private int maxSpeed;
	private int minSpeed;

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

	public int getMaxSpeed()
	{
		return this.maxSpeed;
	}

	public int getMinSpeed()
	{
		return this.minSpeed;
	}

	// Public mutator methods.
	public void accelerate()
	{
		this.speed += 7;

		if ( this.speed > this.maxSpeed ) {
			this.maxSpeed = this.speed;
		}
	}
	
	public void brake()
	{
		if ( this.speed - 5 < 0 ) {
			this.speed = 0;
		} else {
			this.speed -= 5;
		}
	}

	public void setSpeed( int speed )
	{
		this.speed = speed;

		if ( this.speed > this.maxSpeed ) {
			this.maxSpeed = this.speed;
		}
	}

	public void auto()
	{
		// call accelerate 7 times and brake 5 times displaying the speed each time.
		for ( int i = 0; i < 7; i++ ) {
			this.accelerate();
			System.out.printf( "Your car's current speed is: %d.\n", this.speed );
		}
		for ( int i = 0; i < 5; i++ ) {
			this.brake();
			System.out.printf( "Your car's current speed is: %d.\n", this.speed );
		}
	}

	public void increase()
	{
		if ( this.speed > 0 ) {
			this.speed *= 6;
		} else {
			this.speed += 6;
		}

		if ( this.speed > this.maxSpeed ) {
			this.maxSpeed = this.speed;
		}
	}

	public void decrease()
	{
		// Decrease the speed by 4 times and print out the speed.
		if ( this.speed > 0 ) {
			this.speed /= 4;
		}
	}

	// Main routine to demonstrate usage of the class.
	public static void main( String [] args )
	{
		boolean isValid = false;
		Scanner inScanner = new Scanner( System.in );	
		String input = "";

		// Car variables.
		String i_type = "";
		String i_make = "";
		int i_year = 0;;
		int maxSpeed = 0;
		int minSpeed = 0;
		
		do {
			try {
				System.out.print( "Enter the type of car you own: " );
				i_type = inScanner.next();	
				isValid = true;
			} catch ( IllegalArgumentException e ) {
				System.out.println( "INVALID INPUT - Please try again." );
				inScanner.next();
			}
		} while ( !isValid );	

		isValid = false;
		do {
			try {
				System.out.print( "Enter the make of the car you own: " );
				i_make = inScanner.next();
				isValid = true;
			} catch ( IllegalArgumentException e ) {
				System.out.println( "INVALID INPUT - Please try again." );
				inScanner.next();
			}
		} while ( !isValid );
			
		isValid = false;
		do {
			try {
				System.out.print( "Enter the year of the car you own: " );
				i_year = inScanner.nextInt();
				isValid = true;
			} catch ( InputMismatchException e ) {
				System.out.println( "INVALID INPUT - You must enter an integer for this value." );
				inScanner.next();
			}
		} while ( !isValid );

		// Instantiate the Car object.
		Car myCar = new Car( i_year, i_make, i_type );

		// Ask for initial speed.
		isValid = false;
		do {
			System.out.print( "Enter the speed you would like to start at, or enter 'a' for automatic:" );
			input = inScanner.next();
			
			// Determine if input was "a" or "A".
			if ( input.equalsIgnoreCase("a") ) {
				myCar.auto();
				isValid = true;
			} else { 
				try {
					Integer.parseInt(input);
					isValid = true;
				} catch ( NumberFormatException e ) {
					System.out.println( "INVALID INPUT - You must enter 'a' or an integer." );
				}
			}
		} while ( !isValid );

		// Take input interactively.
		do {
			System.out.print( "Enter an option or press 'q' to quit: " );
			input = inScanner.next();

			switch ( input ) {
				case "a":
					myCar.auto();
					break;
				case "i":
					myCar.increase();
					System.out.printf( "Your car's current speed is: %d.\n", myCar.getSpeed() );
					break;
				case "d":
					if ( myCar.getSpeed() > 0 ) {
						myCar.decrease();
						System.out.printf( "Your car's current speed is: %d.\n", myCar.getSpeed() );
					} else {
						System.out.printf( "Your car is stopped.\n" );
					}
					break;
				case "q":
					break;
				default: 
					System.out.println( "INVALID INPUT." );
			}
		} while ( !input.equals("q") );
	
		System.out.printf( "Stopped. Your car's maxspeed was %d; minspeed was %d.\n" ,myCar.getMaxSpeed(), myCar.getMinSpeed() );
	}	
}
///////////////////////////////////////////////////////////////////
//   End Of File                                                 //
///////////////////////////////////////////////////////////////////

