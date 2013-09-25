public class Prg4 {

	public static void main ( String args[] )
	{

		if ( args.length < 3 )
		{
			System.out.println ( "Not enough parameters" ) ;
			return ;
		}

		int x , y , u , v ;

		x = Integer.parseInt ( args [ 0 ] ) ;
		y = Integer.parseInt ( args [ 1 ] ) ;
		u = Integer.parseInt ( args [ 2 ] ) ;
		v = Integer.parseInt ( args [ 3 ] ) ;

		//have to see if (x,y) fits in (u,v)
		if ( ( x <= u && y <= v ) || ( x <= v && y <= u ) )
			System.out.println ( "It fits" ) ;
		else
			System.out.println ( "It does not fit" ) ;
	}

}