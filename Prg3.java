public class Prg3 { 
	public static void main ( String args [] )
	{

		if ( args.length == 0 )
		{
			System.out.println ( "Need a parameter to calculate the sum" ) ;
			return ;
		}

		int n = Integer.parseInt ( args[0] ) ;
		//only considering multiples of 3 and 5
		int number_of_three_multiples = n / 3 ;
		int number_of_five_multiples = n / 5 ;
		int number_of_fifteen_multiples = n / 15 ;

		number_of_three_multiples * 
	}
}