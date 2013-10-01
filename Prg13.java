public class Prg13 {

	static int[] st = new int[10];

	//1 2 3 4 5 6 7 8 9 

	// 0 = nothing
	// 1 = plus
	// 2 = minus

	static void checkSolution () 
	{
		int i ;
		int sum = 0 ;
		int current_number = 0 ;

		if ( st[1] != 0 )
			sum = 1 ;
		else
			current_number = 1 ;

		int last_operator = -1 ;

		for ( i = 1 ; i < 9 ; ++ i )
		{
			switch ( st[i] )
			{
				case 0: 
					current_number = current_number * 10 + (i+1) ;
					//System.out.println ( current_number ) ;
					break;
				case 1:
					if ( last_operator == 1 )
						sum += current_number ;
					else
						if ( last_operator == 2 )
							sum -= current_number ;

					if ( last_operator == -1 )
						sum = sum + current_number ;

					last_operator = 1 ;
					current_number = (i+1) ;

					break;
				case 2:
					if ( last_operator == 1 )
						sum += current_number ;
					else
						if ( last_operator == 2 )
							sum -= current_number ;

					if ( last_operator == -1 )
						sum = sum - current_number ;

					last_operator = 2 ;
					current_number = (i+1) ;
					break ;
			}
		}
		if ( last_operator == 1 )
			sum += current_number ;
		else
			if ( last_operator == 2 )
				sum -= current_number ;
		//System.out.println ( sum ) ;
		if ( sum == 100 )
		{
			System.out.print ( "±±± " ) ;
			for ( i = 1 ; i < 9 ; ++ i )
				System.out.print ( st [ i ] ) ;
			System.out.print ( " ±±±" ) ;
			System.out.println ( ) ;
		}
	}

	//12 + 34 = 

	static void bkt ( int k )
	{

		if ( k == 9 )
		{
			checkSolution () ;
			return ;
		}

		for ( int i = 0 ; i < 3 ; ++ i )
		{
			st[k] = i ;	
			bkt ( k + 1 ) ;
		}

	}

	public static void main ( String[] args )
	{
		for ( int i = 0 ; i < 10 ; ++ i )
			st [ i ] = 0 ;
		bkt (1) ;
	}

}