public class Prg16 {

	static int persistance = 0 ;

	static int digitalSignature ( int n )
	{
		int sum = 0 ;
		while ( n > 9 )
		{
			sum = 0 ;
			persistance ++ ;
			while ( n > 0 )
			{
				sum += n%10 ;
				n /= 10 ;
			}
			n = sum ;
		}
		return n ;
	}

	public static void main ( String args[] )
	{

		if ( args.length == 0 )
		{
			System.out.println ( "Not enough parameters" ) ;
			return ;
		}

		int n = Integer.parseInt ( args[0] ) ;

		int result ;

		result = digitalSignature ( n ) ;

		System.out.println ( result + " " + persistance ) ;

	}

}