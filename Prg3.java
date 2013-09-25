public class Prg3 { 
	public static void main ( String args [] )
	{

		if ( args.length == 0 )
		{
			System.out.println ( "Need a parameter to calculate the sum" ) ;
			return ;
		}

		int n = Integer.parseInt ( args[0] ) ;
		
		int sum = 0 ;
		int i ;

		for ( i = 3 ; i <= n ; i *= 3 )
			sum += i ;
		for ( i = 5 ; i <= n ; i *= 5 )
			sum += i ;
		for ( i = 15 ; i <= n ; i *= 15 )
			sum += i ;

		System.out.println ( sum ) ;
	}
}