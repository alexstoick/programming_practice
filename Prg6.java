import java.io.FileInputStream;
import java.util.ArrayList ;
import java.util.Scanner;


public class Prg6 {
		
	public static void main ( String args[] )
	{
		
		FileInputStream instream = null ;
		try {
			instream = new FileInputStream ("date.in") ;
		} catch ( Exception e )		{
			System.out.println ( e ) ;
		}
		
		System.setIn(instream); 
		
		Scanner scanner = new Scanner ( System.in ) ;
		
		ArrayList<Integer> x = new ArrayList<Integer>() ;
		
		while ( scanner.hasNextInt() )
		{
			int tmp = scanner.nextInt () ;
			
			x.add ( tmp ) ;
		}
		
		
		int length = x.size() ;
		int current_frame = 1 ;
		int score = 0 ;
		int i ;
		
		for ( i = 0 ; i < length && current_frame <= 10 ; ++ i , ++ current_frame )
		{
			int current_value = x.get(i) ;
			if ( current_value == 10 )
			{
				//have to add up the next 2 values
				
				if ( current_frame < 10 )
					score += ( 10 + x.get(i+1) + x.get(i+2) ) ;
			}
			else
				if ( current_value + x.get(i+1) == 10 )
				{
					score += ( 10 + x.get(i+2) ) ;
					++ i ;
				}
				else
				{
					score += ( current_value + x.get(i+1) ) ;
					++ i ;
				}
			System.out.println ( "Frame " + current_frame + " : " + score ) ;
		}
		
	}
	
}