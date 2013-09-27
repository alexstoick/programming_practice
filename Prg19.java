public class Prg19 { 

	static void prime_factors ( int n )
	{

		int d = 2 ;

		while ( n > 1 )
		{
			while ( n % d == 0 )
			{
				System.out.print ( d + " " ) ;
				n /= d ;
			}
			++ d ;
		}
	}

	public static void main ( String args[] )
	{

		if ( args.length == 0 )
		{
			System.out.println ( "Not enough parameters" ) ;
			return ;
		}

		int n ;
		n = Integer.parseInt ( args[0] ) ;

		prime_factors ( n ) ;
		System.out.println ( ) ;
	}
}