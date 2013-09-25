public class Prg1 {

	public static void main ( String args[] )
	{

		//FizzBuzz
		int i ;

		for ( i = 1 ; i <= 100 ; ++ i )
		{
			boolean printed = false ;
			if ( i % 3 == 0 )
			{
				System.out.print ( "Fizz" ) ;
				printed = true ;
			}
			if ( i % 5 == 0 )
			{

				System.out.print ( "Buzz" ) ;
				printed = true ;
			}
			if ( ! printed )
				System.out.print ( i ) ;
			System.out.println () ;
		}

	}
	
}