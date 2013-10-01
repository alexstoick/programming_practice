import java.io.FileInputStream;
import java.util.Scanner;

public class Prg9 {

	static int[][] matrix ;
	static int n ;

	static boolean isSaddlePoint ( int x , int y )
	{
		int i , j ;
		int current_value = matrix [x][y] ;

		for ( i = 0 ; i < n ; ++ i )
			if ( current_value > matrix[i][y] )
				return false ;
		for ( j = 0 ; j < n ; ++ j )
			if ( current_value < matrix[x][j] )
				return false ;

		return true ;
	}

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
		String x ;
		
		x = scanner.nextLine ( ) ;
		n = Integer.parseInt ( x ) ;

		matrix = new int[n][n] ;

		int counter = 0 ;

		while ( scanner.hasNextInt () )
		{
			int tmp = scanner.nextInt () ;
			matrix [counter/n] [counter%n] = tmp ;
			++counter ;
			//System.out.println ( tmp ) ;
		}

		int current_column , current_row ;
		//A saddle point is a cell whose value is greater than or equal to any in its row,
		// and less than or equal to any in its column.

		for ( current_row = 0 ; current_row < n ; ++ current_row )
		{
			for ( current_column = 0 ; current_column < n ; ++ current_column )
			{
				if ( isSaddlePoint ( current_column , current_row ) )
					System.out.printf ( "(%d , %d)\n" , current_row + 1 , current_column + 1 ) ; 
				//System.out.printf ( "%d " , matrix[i][j] ) ;
			}
		}
	}

}