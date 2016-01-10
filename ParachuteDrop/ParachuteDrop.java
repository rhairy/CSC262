// Assignment :  <name of assignment>
// // by: Randall Harrison
// // Date: 2016-01-11
// // Description: Calculate speed of a parachuting object.
// //  Notes: any special things you want me to consider.
// If there are any questions that need to be answered put them here as comments
//
import java.util.Scanner;
import java.lang.Math;

public class ParachuteDrop
{
	public static double parachuteDiameter(double mass, double velocity)
	{
		return Math.sqrt( 8 * mass * 9.8 / (3.14 * 1.22 * 1.5 * velocity * velocity) );	
	}

	public static double fpsToMps(double fps)
	{
		return fps * .3048;
	}

	public static double mpsToFps(double mps)
	{
		return mps * 3.28084;
	}

	public static double metersToInches(double meters)
	{
		return meters * 39.3701;
	}

	public static double metersToFeet(double meters)
	{
		return meters * 3.2808;
	}

	public static double poundsToKilos(double ibs)
	{
		return ibs * 0.453592;
	}

	public static void main(String[] args)
	{
		/* Define default variables. */
		double velocity = 3;
		double mass = 0;

		/* Get input. */
		Scanner inStream = new Scanner(System.in);
		String input;

		System.out.printf("Is an impact speed of %f ft/s acceptable? (y/n)", mpsToFps(3.0));
		input = inStream.next();
		
		switch (input) {
			case "y":
				break;
			case "n":
				System.out.print("Enter an acceptable speed in ft/s: ");
				velocity = fpsToMps(inStream.nextDouble());
				break;
			default:
				System.out.println("INVALID INPUT.");
				break;
		}	

		System.out.print("Enter the weight of your object in ibs: ");
		mass = inStream.nextDouble();
		mass = poundsToKilos(mass);

		/* Perform Calculation. */
		double chuteDiameter = parachuteDiameter(mass, velocity);
	
		System.out.printf("For a payload of %f ibs.\n", mass);

		System.out.printf("Your chute will need a chute of at least %f ft or %f inches.\n", metersToFeet(chuteDiameter), metersToInches(chuteDiameter));
		System.out.printf("The payload will hit the ground at %f ft/s.\n", mpsToFps(velocity));
	}
}
// 	   ///////////////////////////////////////////////////////////////////
// 	   ///   End Of File
// 	   ///////////////////////////////////////////////////////////////////
