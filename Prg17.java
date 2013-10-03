import java.io.FileInputStream;
import java.util.Stack ;
import java.util.HashSet ;
import java.util.Scanner;

class Operation {
	
	private char x ;
	
	public Operation ( char op )
	{
		x = op ;
	}
	
	public int priority ( )
	{
		if ( x == '(' )
			return 3 ;

		if ( x =='~' )
			return 2 ;

		if ( x == 'v' || x == '^' )
			return 1 ;
		
		return 0 ;
	}
	
	public char getOperation ( )
	{
		return x ;
	}
}


public class Prg17 {
	
	static boolean isOperation ( char x )
	{
		return ( x == '~' || x == 'v' || x == '&' || x == '(' || x == ')' ) ;
	}
	
	static boolean isVariable ( char x )
	{
		return ( 'a' <= x && x <= 'z' && x != 'v' ) ;
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
		x = x.replace ( " " , "" ) ;
		
		Stack<Operation> operations = new Stack<Operation>() ;
		HashSet<Character> variables = new HashSet<Character>() ;
		
		char[] polonez = new char[500] ;
		int polonez_length = -1 ;
		
		int[] f = new int[30] ;
		
		int length = x.length() ;
		int i ;
		
		for ( i = 0 ; i < length ; ++ i )
		{
			
			char current_char = x.charAt ( i ) ;
			
			if ( isOperation ( current_char ) )
			{
				Operation current_operation = new Operation ( current_char ) ;

				if ( current_char == ')' )
				{
					//pop everything until '('
					while ( operations.peek().getOperation() != '(' ) 
					{
						char last_operation = operations.pop().getOperation() ;
						polonez [ ++ polonez_length ] = last_operation ;
					}
					//pop the '('
					operations.pop();
				}
				else
				{
					
					while ( ! operations.empty() && !( operations.peek().getOperation() == '(') && current_operation.priority() < operations.peek().priority() )
					{
						char last_operation = operations.pop().getOperation() ;
						polonez [ ++ polonez_length ] = last_operation ;
					}
					
					operations.push( current_operation ) ;
				}
			}
			else
			{
				++ polonez_length ;
				polonez [ polonez_length ] = current_char ;
				variables.add ( current_char ) ;
			}

		}
		
		//see how many variables we have
		
		int variable_count = variables.size() ;

		System.out.println ( variables ) ;
				
		while ( ! operations.empty() )
		{
			polonez [ ++ polonez_length ] = operations.pop().getOperation() ;
		}

		++ polonez_length ;

		for ( i =  0 ; i < polonez_length ; ++ i ) 
			System.out.print ( polonez [i] ) ;
		
		System.out.println() ;
		//generam pana la 2^variable_count
		
		int limit = 1 << variable_count ;
		int j , k ;

		Stack<Boolean> values = new Stack<Boolean>();

		for ( k = 0 ; k < limit ; ++ k )
		{
			for ( j = 0; j < variable_count ; ++ j )
				if ( ( k &  (1 << j ) ) > 0 )
					System.out.printf ( "1 " ) ;
				else
					System.out.printf ( "0 " ) ;

			boolean currentValue = false ;

			for ( i = 0 ; i < polonez_length ; ++ i )
			{
				if ( isOperation ( polonez [ i ] ) )
				{
					//daca e NOT ne uitam doar la ultimul caracter
					if ( polonez[i] == '~' )
					{
						boolean value = values.pop() ; //( k & ( 1 << ( polonez [ i - 1 ] - 'a' ) ) ) > 0 ;
						values.push ( Boolean.valueOf (!value) ) ;
					}
					else
					{
						boolean first_value = values.pop() ;
						boolean second_value = values.pop() ;
						if ( polonez[i] == '&' )
							values.push ( Boolean.valueOf ( first_value & second_value ) ) ;
						else
							values.push ( Boolean.valueOf ( first_value | second_value ) ) ;
					}
				}
				else
				{
					boolean value = ( k & ( 1 << ( polonez [ i ] - 'a' ) ) ) > 0 ;
					values.push ( Boolean.valueOf (value) ) ;
				}
			}

			System.out.print ( values.pop() ) ;

			System.out.println ( ) ;
		}
		
		
		return ;
	}
}