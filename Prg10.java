import java.util.ArrayList;
class Point 
{
	int x , y ;

	public String toString ( )
	{
		return ( "(" + x + " , " + y + ")" ) ;
	}
}



public class Prg16 {
	
	public static void main ( String args [] )
	{
		
		if ( args.length % 2 == 1 || args.length == 0 )
		{
			System.out.println ( "Wrong number of parameters" ) ;
			return ;
		}
		
//		Point[] queens = new Point[args.length/2] ;
		
		ArrayList<Point> queens = new ArrayList<Point>();
		
		int i , j , k  ;
		
		int[][] matrix = new int[9][9] ;
		
		for ( i = 0 ; i < args.length/2 ; ++ i )
		{
			Integer x ;
			Integer y ;
			
			x = Integer.parseInt ( args [ i*2 ] ) ;
			y = Integer.parseInt( args [ i*2 + 1 ] ) ;
			
			Point current = new Point() ;
			
			current.x = x ;
			current.y = y ;
			
			queens.add ( current ) ;
		}
		
		//initialize the matrix
		for ( i = 1 ; i <= 8 ; ++ i )
			for ( j = 1 ; j <= 8 ; ++ j )
				matrix[i][j] = 0 ;
		
		int length = queens.size ( ) ;
		
		for ( k = 0 ; k < length ; ++ k )
		{
			Point currentQueen= queens.get(k) ;
			
			//line
			for ( i = 1 ; i <= 8 ; ++ i )
				++ matrix [i][currentQueen.y] ;
			//column
			for ( j = 1 ; j <= 8 ; ++ j )
				++ matrix[currentQueen.x][j] ;
			
			//first diagonal
			for ( i = -7 ; i < 8 ; ++ i )
			{
				int current_x = currentQueen.x + i ;
				int current_y = currentQueen.y + i ;
				if ( ( 0 < current_x && current_x < 9 ) &&
						( 0 < current_y && current_y < 9 ) )
						++ matrix[current_x][current_y] ;
			}
			
			//second diagonal
			
			for ( i = -7 ; i < 8 ; ++ i )
			{
				int current_x = currentQueen.x + i ;
				int current_y = currentQueen.y - i ;
				
				if ( ( 0 < current_x && current_x < 9 ) && 
						( 0 < current_y && current_y < 9 ) )
					++ matrix[current_x][current_y] ;
			}
		}
	
		int attacked_queens = 0 ;
		
		for ( k = 0 ; k < length ; ++ k )
		{
			Point currentQueen = queens.get ( k ) ;
			int x = currentQueen.x ;
			int y = currentQueen.y ;
			if ( matrix[x][y] != 0 && matrix[x][y] != 4 )
				++ attacked_queens ;
			
			matrix [x] [y] = -1 ;
		}
		
		for ( i =  1 ; i <= 8 ; ++ i )
		{
			for ( j = 1 ; j <= 8 ; ++ j )
			{
				if ( matrix[i][j] == -1 )
					System.out.printf ( "Q" ) ;
				else
					if ( matrix[i][j] > 0 )
						System.out.printf ( "x" ) ;
					else
						System.out.printf ( "_" ) ;
			}
			System.out.println () ;
		}
		
		System.out.printf ( "Number of attacked queens: %d " , attacked_queens ) ;
		
		return ;
	}
}