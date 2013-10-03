import java.io.FileInputStream;
import java.util.Scanner;

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
		int n = Integer.parseInt ( x ) ;

		weight = new int[n] ;
		value = new int[n] ;

		int i  ;
		for ( i = 0 ; i < n ; ++ i  )
		{
			weight[i] = scanner.nextInt ( ) ;
			value[i] = scanner.nextInt ( ) ;
		}

		int piggy_bank = scanner.nextInt ( ) ;

		int[] v = new int[piggy_bank+5] ;

		boolean updated = true ;
		int coin_counter ;

		//piggy_bank ;

		for ( i = 0 ; i < piggy_bank ; ++ i )
			v[i] = 0 ;

		while ( updated )
		{

			updated = false ;

			for ( coin_counter = 0 ; coin_counter < n ; ++ coin_counter )
			{

				int current_weight = weight [ coin_counter ] ;
				int current_value = value [ coin_counter ] ;
				for ( i = piggy_bank - current_weight ; i >= 0 ; -- i )
					if ( v[i] > 0 )
					{
						int tmp = i + current_weight ; 
						if ( v [ tmp ] > v[i] + current_value || v[ i + current_weight ] == 0)
						{
							v [ tmp ] = v[i] + current_value ;
							updated = true ;
						}
					}	

				if ( v[current_weight] > current_value || v[current_weight] == 0 )
				{
					v[current_weight] = current_value ;
					updated = true ;
				}
			}
			for ( i = 1 ; i <= piggy_bank ; ++ i )
				System.out.print ( i + " " ) ;	
			System.out.println ( ) ;			
			for ( i = 1 ; i <= piggy_bank ; ++ i )
				System.out.print ( v[i] + " " ) ;	

			System.out.println ( ) ;
			System.out.println ( ) ;
		
		}

		for ( i = 0 ; i < piggy_bank ; ++ i )
			System.out.println ( v[i] ) ;	
		

	}

}