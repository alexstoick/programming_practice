public class Prg7 {

	public static void main ( String args[])
	{

		FileInputStream instream = null ;
		try {
			instream = new FileInputStream ("date.in") ;
		} catch ( Exception e )		{
			System.out.println ( e ) ;
		}
		
		System.setIn(instream); 
		
		Scanner scanner = new Scanner ( System.in ) ;
		String x ;
		
		int[] weight , value ;

		x = scanner.nextLine ( ) ;
		n = Integer.parseInt ( x ) ;

		weight = new int[n] ;
		value = new int[n] ;

		int i  ;
		for ( i = 0 ; i < n ; ++ i  )
		{
			weight[i] = scanner.nextInt ( ) ;
			value[i] = scanner.nextInt ( ) ;
		}

		piggy_bank = scanner.nextInt ( ) ;

		int[] x = new int[piggy_bank] ;

		boolean updated = true ;

		while ( updated )
		{

			updated = false ;

		}

		

	}

}