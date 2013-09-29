import java.util.ArrayList;
public class Prg15 {
	
	public static void main ( String args [] )
	{
		
		if ( args.length < 2 )
		{
			System.out.println ( "Not enough parameters" ) ;
			return ;
		}
		
		int n = Integer.parseInt ( args[0] ) ;
		
		ArrayList<Integer> sum = new ArrayList<Integer>();
		
		int current_sum = 0 ;
		int i ;
		for ( i = 1 ; i < args.length ; ++ i )
		{
			int x = Integer.parseInt( args[i] ) ;
			current_sum += x ;
			sum.add ( current_sum ) ;
		}
		
		System.out.println( sum ) ;
		
		for ( i = 0 ; i < n ; ++ i )
			System.out.print( ( (double)sum.get(i) / n) + " " ) ;
		
		int length = sum.size ()  ;

		for ( i = n ; i < length ; ++ i )
		{
			System.out.printf ( "%.0f " , ( ((double)sum.get(i) - sum.get(i-n) ) / n ) ) ;
		}	
		
	}

	//2 1 6 4 2 5 7 9 10 2 5 1 3
}