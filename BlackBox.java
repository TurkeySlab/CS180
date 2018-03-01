import java.util.Random;
import java.util.Scanner;

/**
 * @author  maxwell williams
 * @version 02/22/2018
 * 
 * This code simulates the black box game 
 */
public class BlackBox {
    public static char box[][]; // The matrix for the game.
    public static int size;       // to store the number of rows and columns.
    public static int numball;
    public static int numlink;
    public static boolean end;
    public static int score;
    public static int high_score=-1;
    public static int guess[][] = new int[3][2];		// each game gets 3 guesses that are saved as a point

    /**
     * The default constructor which places default values to the class variables
     */
    public BlackBox()
    {
        this.box = new char[0][0];
        this.size = 0;
        this.numball = 0;
        this.numlink = 0;
        this.end = false;
        this.score = 0;
    }
    /**
     * The parameterized constructor which places values to the class variables
     */
    public BlackBox(int size, int numball, int numlink, boolean end, int score)
    {
        this.box = new char[size][size];
        this.size = size;
        this.numball = numball;
        this.numlink = numlink;
        this.end = end;
        this.score = score;
    }
    /**
     * The main function takes input for the difficulty level and call the functions initialize(int) and
     * playgame()
     */
    public static void main(String[] args) {
       //Todo:start the game print the welcome message and ask for correct difficulty level.
    	/*System.out.println("Welcome to the Blackbox Game! Please choose the difficulity level:\n"
    					 + "easy/ medium/ hard. or quit to end the game ");
    	Scanner s = new Scanner(System.in);
    	String input = "";
    	do {
    		input = s.nextLine();
    		// checks the input from the user and alters the required values relative to the input
    		// size is set to be +2 of board size to handle borders
    		if( input.equalsIgnoreCase("easy") )
    		{
    			size = 7;
    		} else if( input.equalsIgnoreCase("medium") ){
    			size = 9;
    		} else if( input.equalsIgnoreCase("hard") ) {
    			size = 10;
    		} else if( input.equalsIgnoreCase("quit") ) {
    			// leaves
    			System.out.println("Goodbye!");
    			return;
    		} else {
    			// there was not a valid input
    			// input is reset and the question is asked again
    			System.out.println("Please choose the difficulity level:\n" + 
    					"easy/ medium/ hard. or quit to end the game");
    			input = "";
    		}
    	} while ( input.equals("") );
    	*/ 
    	size = 10;
    	initialize();		// size has been created; now creating the board
    	printbox();
    	playgame();
       //Todo: end the game if the user says quit.
       //Todo: call the functions initialize and playgame()
       //Todo: take care of high score
    }
    /**
     * The initialize function
     */
    public static void initialize() {
        //Todo: initialise the Box[][]
        //Todo: place the 'X' and the '#'
        //Todo: place 3 '0''s randomly.
    	box = new char[size][size];
    	
    	for( int i = 0; i < size; i++ )
    	{
    		for( int j = 0; j < size; j++ )
    		{
    			if( i == 0 || i == size - 1)		// handles top and bottom
    				box[i][j] = '#';
    			if( j == 0 || j == size - 1)		// handles left and right columns
    				box[i][j] = '#';
    			if( (i == 0 && j == 0) || ( i == 0 && j == size -1 ) || ( i == size -1 && j == 0 ) || (i == size -1&& j == size -1) )	// handles corners
    				box[i][j] = 'X';
    		}
    	}
    	for( int i = 0; i < 3; i++ )
    	{
    		// generates 3 random ball locations
    		boolean validPlace = false;
    		Random r = new Random();
    		do
    		{
    			// generates a new point in the matrix
    			int x = r.nextInt(size - 2) + 1, y = r.nextInt(size - 2) + 1;
    			if( box[x][y] == 'o' )
    			{
    				// there is already a ball at the location 
    				validPlace = false;
    			} else {
    				// adds a ball to the location and changes loop parameter 
    				box[x][y] = 'o';
    				validPlace = true;
    			}
    		} while ( !validPlace );
    	}
    	box[4][4] = 'o';
    }
    /**
     * The printbox function prints out the matrix in a particular format as given in the handout.
     */
    public static void printbox() {
        //Todo:print the box in the correct order
        // for  5*5 example
        /*1  2  3  4  5  6  7
         ======================
        1|X |# |# |# |# |# |X |
        2|# |  |  |  |  |  |# |
        3|# |  |  |  |  |  |# |
        4|# |  |  |  |  |  |# |
        5|# |  |  |  |  |  |# |
        6|# |  |  |  |  |  |# |
        7|X |# |# |# |# |# |X |
         ======================*/
        //place the guesses as they come and print the balls when the player enter submit..
    	if( size == 10)					// done to line up bottom row for hard mode
    		System.out.print("  |");
    	else
    		System.out.print(" |");
    	for( int i = 1; i < size + 1; i++ )
    	{
    		System.out.print(i + "  ");
    	} 
    	String f = String.format("\n   %" + (( size * 3 )) + "s", "").replace(" ", "=");	// adjusts for variable game box sizes ( 3.75 )
    	System.out.println( f );
    	
    	for(int i = 1; i < size + 1; i++)		//TODO (int i = 1; i < size + 1; i++) and change print grid to be [i - 1]
    	{	
    		if( i < 10 )				// done to line up bottom row for hard mode
    			System.out.print(i + " |");
    		else 
    			System.out.print(i + "|");
    		
    		for( int j = 0; j < size; j++ )
    		{
    			/*
    			// prints the "cells"
    			if( box[i - 1][j] == 'o' )
    			{
    				TODO remove tracking
    				System.out.print("  |");
    			} else {
    				System.out.print(box[i - 1][j] + " |");
    			} 
    			*/
    			//System.out.print(box[i - 1][j] + " |");		TODO use
    			System.out.print(box[i - 1][j] + " |");
    		}
    		
    		if( i == size )				// used to determine bottom line
    			System.out.print("");
    		else
    			System.out.println();
    	}
    	System.out.print(f);
    	System.out.println("\n");
    	
    }
    /**
     * The playgame function opens the first cell and is the main controller for the game. It calls various function when needed.
     */
    public static void playgame() {
        //Todo:Take input of a guess or hint from the user.
        //Todo:Check for valid input
        //Todo:call required functions
    	// inputs are reduced by 1 here to follow index rules 
    	int i, j;						// the beams current location
    	int iStart, jStart;				// the firing port
    	int[] val = new int[3];			// used to both move the beam relative to the balls and detect straight rays
    	int d;							// the direction of movement for methods
    	boolean inBounds = true, str8 = true, game = true;	// handles beam movement loop; used to determine if the beam moved straight; master game control
    	int beamExits = 1;				// used for updating the margin values for user returns
    	String input = "";
    	// input recieved 
    	// check first for reflection at entry port
    	Scanner s = new Scanner( System.in );
    	do {
    		/* 
    		 * the master game control
    		 * gets inputs and tests values and prints the end result 
    		 */
    		System.out.println("Choose the new coordinate (row, column) to play the next step or say submit/ quit");
    		input = s.nextLine();
    		if( input.equalsIgnoreCase("quit") )
    		{
    			// user request to leave the game ( really weird doubt this will be used because the game is the best like 10/10 by IGN game )
    			return;
    		} else if( input.equalsIgnoreCase("submit") ) {
    			// handles submitting the user's guesses of where the ball is located
    			// TODO
    		} else {
    			/*
    			 * The user entered a coordinate and will run the beam and return the outputs
    			 */
    			int[] temp = coordinates(input);		// gets the coordinates 
    			
    			iStart = temp[0];		// saves starting values for user returns 
    			jStart = temp[1];
    			
    			i = iStart;				// assigns beam location variables to move beam
    			j = jStart;
    			inBounds = true;
    			str8 = true;
    			d = 0;		// TODO : set d relative to input
		    	while( inBounds )
		    	{	
		    		/*
		    		 * this loop handles beam movement and will run while the (i, j) beam location 
		    		 * is within the grid. the loop will also exit in the even that the beam leaves the 
		    		 * board due to a reflection at the detection of a reflection
		    		 */
		    		System.out.println(i + ", " + j);
		    		
		    		if( reflectionCheck(i, j, d) )		// a reflection has been detected the starting coordinates will be updated
		    		{
		    			System.out.println("Reflection @ : " + i + ", " + j );
		    			box[iStart][jStart] = 'R';		// updates the margin 
		    			inBounds = false;				// beam 'exited' getting new input for next beam
		    		}
		    		
		    		if( hitcheck(i, j, d) )				// placed above because stacked balls will return a deflection when it should be a hit
		    		{
		    			System.out.println("Hit @ : " + i + ", " + j);
		    			box[iStart][jStart] = 'H';		// updates the margin 
		    			inBounds = false;				// beam 'exited' getting new input for next beam
		    		}
		    		
		    		val = deflectionCheck(i, j, d);		// gets data from deflection and uses values to alter beam location (i, j)
		    		i += val[0];						// moves i relative to
		    		j += val[1];						// moves j relative to 
		    		d  = val[3];						// changes direction relative to
		    		if( val[2] == 1 )
		    			str8 = false;					// there was a deflection beam is no longer straight
		    		
		    		box[i][j] = '*';					// used to "track" laser
		
		    		if( i == 0 || i == size - 1 || j == 0 || j == size - 1 )
		    		{
		    			if( str8 )
		    			{
		    				// the beam path was not altered
		    				box[iStart][jStart] = Character.forDigit(beamExits, 10);
		    				box[i][j] 			= Character.forDigit(beamExits, 10);
		    				beamExits++;
		    			} else {
		    				// the beam path was altered
		    				box[iStart][jStart] = Character.forDigit(beamExits, 10);
		    				box[i][j] 			= Character.forDigit(beamExits, 10);
		    				beamExits++;
		    			}
		    			inBounds = false;
		    		}
		    		printbox();
		    	}
		    	printbox();							// updates playing field
    		}
    	} while( game );
    	
    	
        //Todo:keep tab on score.
    	
    	// (1, 1) = (0, 0) so 1 is subtracted from user input to translate to matrix
    	
    	// the ray will be a "Straight Ray" if the start 'i' = end 'i' or start 'j' = end 'j'
    	// this is tested at the exit of the controlling loop and not in a method
    }
    /**
     * The check function takes in the row and column in the matrix, checks for Hit (H), Reflection (R) or Divergence(#num)
     *
     */
    public static void check(int i,int j)	// ( DEPRECIATED )
    {	 
        //Todo:Check for a Hit
        //Todo:Check for a reflection
        //Todo:Check for a bounce
        //Todo:Print a statement telling the user they cannot place a fourth ball.
    }
    /**
     * The hitcheck function takes in the row and column in the matrix, checks for Hit (H)
     *
     */
    public static boolean hitcheck(int i,int j, int d) 
    {
    	/* 
    	 * @return : if the next point the laser will hit is a ball then a hit char 'H' is placed at the entry point
    	 */
    	try {
	    	if( d == 2 )		// coming from left
	    		if( box[i][j-1] == 'o' ) 			
	    			return true;
			if( d == 4 )		// coming from right
				if ( box[i][j+1] == 'o' ) 		
					return true;
			if( d == 1 )		// coming from bottom
				if( box[i-1][j] == 'o' ) 			
					return true;
			if( d == 3 )		// coming from top
				if( box[i+1][j] == 'o' )			// down right	
					return true;
    	} catch( ArrayIndexOutOfBoundsException e ) {
    		return false;
    	}
    	return false;
    }
    public void placeball(int i, int j)
    {
    	/*
    	 * checks if user placed guess is a valid place and saves the guess's placement 
    	 */
    }
    /**
     * The check function takes in the row and column in the matrix, checks for Reflection (R)
     */
    public static boolean reflectionCheck(int i,int j, int d) {
    	/* @ return : will return true if
    	  				1) a ball is 45 from the entry point causing a reflection
    	  				2) there is "ball-space-ball" combination 
    	 * @return  : if this returns true the loop is exited and a reflection char 'R' is placed at the entry point
    	 */
    	if( i == 0 ) {					// top row 
    		if( box[i+1][j+1] == 'o' || box[i+1][j-1] == 'o' )
    		{
    			return true;
    		}
    	} else if ( i == size - 1 ) { 	// bottom row
    		if( box[i-1][j-1] == 'o' || box[i-1][j+1] == 'o' ) 
    		{
    			return true;
    		}
    	} else if ( j == 0 ) {			// left col	 
    		if( box[i+1][j+1] == 'o' || box[i-1][j+1] == 'o' )
    		{
    			return true;
    		}
    	} else if ( j == size - 1) {	// right col
    		if( box[i+1][j-1] == 'o' || box[i+1][j-1] == 'o' ) 
    		{
    			return true;
    		}
    	}
    	/*
    	 *  if the "laser" has passed the entry point and is inside the box
    	 */
    	if( i != 0 && i != size - 1 )
    	{
	    	if( d == 2 && j < size - 1 )		// coming from left
	    		if( box[i-1][j+1] == 'o' && box[i+1][j+1] == 'o' ) 			
	    			return true;
			if( d == 4 )		// coming from right
				if ( box[i-1][j-1] == 'o' && box[i+1][j-1] == 'o') 		
					return true;
    	} 
    	if( j != 0 && j != size - 1 )
    	{
			if( d == 1 )		// coming from bottom
				if( box[i-1][j+1] == 'o' && box[i-1][j-1] == 'o' ) 			
					return true;
			if( d == 3 )		// coming from top
				if( box[i+1][j+1] == 'o' && box[i+1][j-1] == 'o')		
					return true;
    	}
    	return false;
    }
    /**
     * The check function takes in the row and column in the matrix, checks for Divergence(#num)
     */
    public static int[]  deflectionCheck(int i, int j, int d) {
    	/* 
    	   @parm d : the direction the "laser" is moving towards ( N,S,E,W )
    	   @Note   : This is the only method that will move the point ( i, j ) relative to the firing direction
    	   @return : the direction to move the "laser" from point ( i, j ) 
    	 		    	[0] > moves i | 
    	 		    	[1] > moves j | 
    	 		    	[2] > if there was a deflection	| 
    	 		    	[3] updates direction  :  1=N 2=E 3=S 4=W
    			   		if [2] == 1 then straightRay boolean will be set to false
    	   @return : the loop will exit and place a deflection char 'current-delfection-num' if straightRay is false and ( i, j ) reaches the end
    	*/
		if( d == 2 )		// coming from left
		{
			if( box[i-1][j+1] == 'o' ) 			// up right
				return new int[] {1, 0, 1, 3};
			else if( box[i+1][j+1] == 'o' )		// down right	
				return new int[] {-1, 0, 1, 1};
			
			return new int[] {0, 1, 0, 2};			// moves space 1 right
		} 
		if( d == 4 )		// coming from right
		{
			if ( box[i-1][j-1] == 'o' ) 		// up left
				return new int[] {1, 0, 1, 3};
			else if( box[i+1][j-1] == 'o' )		// down left	
				return new int[] {-1, 0, 1, 1};
			
			return new int[] {0, -1, 0, 4};		// moves space 1 left
		}
		if( d == 1 )		// coming from bottom
		{
			if( box[i-1][j+1] == 'o' ) 			// up right
				return new int[] {0, -1, 1, 4};
			else if ( box[i-1][j-1] == 'o' ) 	// up left
				return new int[] {0, 1, 1, 2};
			
			return new int[] {-1, 0, 0, 1};		// moves space up 1
		}
		if( d == 3 )		// coming from top
		{
			if( box[i+1][j+1] == 'o' )			// down right	
				return new int[] {0, 1, 1, 4};
			else if( box[i+1][j-1] == 'o' )		// down left	
				return new int[] {0, 1, 1, 2};
			
			return new int[] {1, 0, 0, 3};			// moves space down 1
		}
		// ( will not be reached )
		return new int[] {};
    }
    /**
     * The straightRay function takes in the row and column in the matrix, checks for Straight ray	( DEPRECIATED )
     */
    public int[] straightRay(int i,int j, int d)// ( DEPRECIATED )
    {
    	// @parm d : the direction the "laser" is moving towards ( N,S,E,W )
    	// @return : the direction to move the "laser" from point ( i, j )
    	//		   : [0] > moves i
    	//		   : [1] > moves j
    	//		   : the ray will be a "Straight Ray" if the start 'i' = end 'i' or start 'j' = end 'j'
    	//		   :	this is tested at the exit of the controlling loop
    	if( d == 2 )		// coming from left
		{
			return new int[] {0, 1};			// moves space 1 right
		} 
		if( d == 4 )		// coming from right
		{
			return new int[] {0, -1};			// moves space 1 left
		}
		if( d == 1 )		// coming from bottom
		{
			return new int[] {-1, 0};			// moves space up 1
		}
		if( d == 3 )		// coming from top
		{
			return new int[] {1, 0};			// moves space down 1
		}
    	return new int[] {};
    }
    public static int[] coordinates(String in)
    {
    	/*
    	 * Returns the coordinate pair based on input and removes all white space 
    	 * [0] = i
    	 * [1] = j
    	 */
    	in = in.replaceAll("\\s+", "");
    	return new int[] {Integer.parseInt(in.substring(0, in.indexOf(','))), Integer.parseInt(in.substring(in.indexOf(',') + 1))};
    }
    
    /**
     * The following definitions are the getters and setter functions which have to be implemented
     *
     */
    public char[][] getbox() {
    	return box;
    }
    public int getscore() {
    	return score;
    }
    public int getNumball() {
    	return numball;
    }
    public int getNumlink() {
    	return numlink;
    }
    public boolean getend() {
    	return false;
    }
    public void setbox(char box[][]) {
    	this.box = box;
    }
    public void setSize(int size){
    	this.size = size;
    }
    public void setNumball(int numball) {
    	this.numball = numball;
    }
    public void setNumlink(int numlink) {
    	this.numlink = numlink;
    }
    public void setEnd(boolean end) {
    	this.end = end;
    }
    public void setScore(int score) {
    	this.score = score;
    }
}