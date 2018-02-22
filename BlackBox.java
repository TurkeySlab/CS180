package homework;

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
    	System.out.println("Welcome to the Blackbox Game! Please choose the difficulity level:\n"
    					 + "easy/ medium/ hard. or quit to end the game ");
    	Scanner s = new Scanner(System.in);
    	String input = "";
    	do {
    		input = s.nextLine();
    		// checks the input from the user and alters the required values relative to the input
    		if( input.equalsIgnoreCase("easy") )
    		{
    			size = 5;
    		} else if( input.equalsIgnoreCase("medium") ){
    			size = 7;
    		} else if( input.equalsIgnoreCase("hard") ) {
    			size = 8;
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
    	
    	System.out.println(input);
    	
       //Todo: end the game if the user says quit.
       //Todo: call the functions initialize and playgame()
       //Todo: take care of high score
    }
    /**
     * The initialize funtion
     */
    public void initialize() {
        //Todo: initialise the Box[][]
        //Todo: place the 'X' and the '#'
        //Todo: place 3 '0''s randomly.
    }
    /**
     * The printbox funtion prints out the matrix in a particular format as given in the handout.
     */
    public static void printbox() {
        //Todo:print the box in the correct order
        // for  5*5 example
        /* 1  2  3  4  5  6  7
         ======================
        1|X |# |# |# |# |# |X |
        2|# |  |  |  |  |  |# |
        3|# |  |  |  |  |  |# |
        4|# |  |  |  |  |  |# |
        5|# |  |  |  |  |  |# |
        6|# |  |  |  |  |  |# |
        7|X |# |# |# |# |# |X |
         ======================*/
        //place the guesses as the come and print the balls when the player enter sumbit.
    }
    /**
     * The playgame funtion opens the first cell and is the main controller for the game. It calls various function when needed.
     */
    public static void playgame() {
        //Todo:Take input of a guess or hint from the user.
        //Todo:Check for valid input
        //Todo:call required functions
        //Todo:keep tab on score.
    }
    /**
     * The check funtion takes in the row and column in the matrix, checks for Hit (H), Reflection (R) or Divergence(#num)
     *
     */
    public static void check(int i,int j) {
        //Todo:place a guess when the input of i and j are valid
        //Todo:Check for a Hit
        //Todo:Check for a reflection
        //Todo:Check for a bounce
        //Todo:Print a statement telling the user they cannot place a fourth ball.
    }
    /**
     * The hitcheck funtion takes in the row and column in the matrix, checks for Hit (H)
     *
     */
    public boolean hitcheck(int i,int j) {
        //todo: check if the ray causes a HIT as defined in the handout
    	
    	return false;
    }
    /**
     * The check funtion takes in the row and column in the matrix, checks for Reflection (R)
     *
     */
    public boolean reflectionCheck(int i,int j) {
        //todo: check if the ray causes a Reflection as defined in the handout
    	
    	return false;
    }
    /**
     * The check funtion takes in the row and column in the matrix, checks for Divergence(#num)
     *
     */
    public boolean deflectionCheck(int i,int j) {
        //todo: check if the ray causes a Deflection as defined in the handout
    	
    	return false;
    }
    /**
     * The straightRay funtion takes in the row and column in the matrix, checks for Straight ray
     *
     */
    public boolean straightRay(int i,int j){
        //todo: check if the ray is a straight ray as defined in the handout
    	
    	return false;
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