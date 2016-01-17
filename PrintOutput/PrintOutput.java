/**********************************************************/
  // Assignment :  PrintOutput
  // by: Randall Harrison
  // // Date: 2016-01-11
  // // Description: Program to print out text identical to the spec.
  // //  Notes: any special things you want me to consider.
  // //***********************************************************
  // //************************************************************
  // If there are any questions that need to be answered put them here as comments
  // */

public class PrintOutput
{
	public static void main( String [] args )
	{
		String s1 = "*";
		String s2 = "**";
		String s3 = "***";
		String s5 = "*****";
		String s9 = "*********";
		
		System.out.printf( "%s%8s%8s%8s\n", s9, s3, s1, s1 );
		System.out.printf( "%s%8s%4s%6s%7s%6s%2s\n", s1, s1, s1, s1, s3, s1, s1 );
		System.out.printf( "%s%8s%3s%8s%7s%4s%4s\n", s1, s1, s1, s1, s5, s1, s1 );
		System.out.printf( "%s%8s%3s%8s%5s%5s%6s\n", s1, s1, s1, s1, s1, s1, s1 );
		System.out.printf( "%s%8s%3s%8s%5s%4s%8s\n", s1, s1, s1, s1, s1, s1, s1 );
		System.out.printf( "%s%8s%3s%8s%5s%5s%6s\n", s1, s1, s1, s1, s1, s1, s1 );
		System.out.printf( "%s%8s%3s%8s%5s%6s%4s\n", s1, s1, s1, s1, s1, s1, s1 );
		System.out.printf( "%s%8s%4s%6s%6s%7s%2s\n", s1, s1, s1, s1, s1, s1, s1 );
		System.out.printf( "%s%8s%8s%8s\n", s9, s3, s1, s1 );
	}
}

///////////////////////////////////////////////////////////////////
/////   End Of File
/////////////////////////////////////////////////////////////////////
//
