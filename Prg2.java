public class Prg2 {

	public static void main ( String args[] )
	{

		//have to read from keyboard
		if ( args.length == 0 )
		{
			System.out.println ( "Need a parameter to calculate the sum" ) ;
			return ;
		}

		int n = Integer.parseInt ( args[0] ) ;
		//formula n*(n+1)/2
		System.out.println ( n*(n+1) / 2 ) ;
	}

}