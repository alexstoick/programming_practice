import java.util.ArrayList;
import java.util.Collections;

public class Prg5 { 

	static ArrayList<Integer> digits = new ArrayList<Integer>();
	static String[] list = new String [10] ;
	static int length ;

	static int[] x = new int[10] ;

	static void bkt ( int k )
	{
		if ( k == length + 1 )
		{
			//solutie afisam
			printSolution ( length ) ;
			return ;
		}
		int i ;
		for ( i = 0 ; i < 3 ; ++ i )
		{
			x[k] = i ;
			bkt ( k + 1 ) ;
		}
	}

	static void printSolution ( int length )
	{
		//print the solution here
		int i , digit ;
		for ( i = 0 ; i < length ; ++ i )
		{
			digit = digits.get ( i ) ;
			System.out.print ( list [digit].charAt(x[i+1]) ) ;
		}
		System.out.println () ;
	}

	public static void main ( String args [] )
	{

		//read a 7 digit number

		list [ 2 ] = "ABC" ;
		list [ 3 ] = "DEF" ;
		list [ 4 ] = "GHI" ;
		list [ 5 ] = "JKL" ;
		list [ 6 ] = "MNO" ;
		list [ 7 ] = "PRS" ;
		list [ 8 ] = "TUV" ;
		list [ 9 ] = "WXY" ;

		if ( args.length == 0 )
		{
			System.out.println ( "Not enough parameters" ) ;
			return ;
		}

		//have to take out numbers that contain either a 0 or a 1

		int n ;
		n = Integer.parseInt ( args [ 0 ] ) ;
		int digit ;

		while ( n > 0 )
		{
			digit = n % 10 ;
			if ( digit == 0 || digit == 1 )
			{
				System.out.println ( "Number contains a 0 or 1." ) ;
				return ;
			}
			digits.add ( digit ) ;
			n /= 10 ;
		}

		n = Integer.parseInt ( args [ 0 ] ) ;
		Collections.reverse(digits);

		length = digits.size() ;

		//bkt
		bkt ( 1 ) ;
	}
}