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

		System.out.print("Enter the weight of your object in ibs: ");
		mass = inStream.nextDouble();
		mass = poundsToKilos(mass);

		System.out.print("Enter the speed that your object needs to land at in ft/s: ");
		velocity = inStream.nextDouble();
		velocity = fpsToMps(velocity);

		/* Perform Calculation. */
		double chuteDiameter = parachuteDiameter(mass, velocity);

		System.out.printf("Your chute will need to be %f feet.\n", metersToFeet(chuteDiameter));
	}

}

// 	   ///////////////////////////////////////////////////////////////////
// 	   ///   End Of File
// 	   ///////////////////////////////////////////////////////////////////
