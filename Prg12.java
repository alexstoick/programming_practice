public class Prg12 {

	public static void main ( String args [] )
	{

		if ( args.length == 0 )
		{
			System.out.println ( "Not enough parameters" ) ;
			return ;
		}

		int n ;
		n = Integer.parseInt ( args[0] ) ;

		if ( n == 1 || n == 2 )
		{
			System.out.println ( "1" ) ;
			return ;
		}

		int a = 1 ;
		int b = 1 ;
		int c = 2 ;
		int count = 2 ;

		while ( count < n )
		{
			c = a + b ;
			a = b ;
			b = c ;
			System.out.println ( c ) ;
			++ count ;
		}
		
	}

}