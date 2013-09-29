import java.util.ArrayList;
class Point 
{
	int x , y ;

	public String toString ( )
	{
		return ( "(" + x + " , " + y + ")" ) ;
	}
}



public class Prg10 {
	
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
		
		System.out.println ( queens ) ;
		int length = queens.size ( ) ;
		
		for ( k = 0 ; k < length ; ++ k )
		{
			Point currentQueen= queen.get(k) ;
			
			//line
			for ( i = 0 ; i < 8 ; ++ i )
				++ matrix [i][currentQueen.y] ;
			//column
			for ( j = 0 ; j < 8 ; ++ j )
				++ matrix[currentQueen.x][j] ;
			
			//first diagonal
			for ( i = -7 ; i < 8 ; ++ i )
				++ matrix[]
			
		}
		
	}
	
}