
public class testerBoi {

    public static void main( String[]  args )
    {
    	/*
    	 * General class for testing that also houses regular common methods
    	 */
    	
    	CollegeStudent c = new CollegeStudent( "in state" );
    	System.out.println(c.toString());
    
    
    }
    
    
    
    
    public static void print( int[][] a )
    {
    	for( int i = 0; i < a.length; i++ )
    	{
    		for(int j = 0; j < a.length; j++ )
    			System.out.print(a[i][j]);
    		System.out.println();
    	}
    	
    }
}

