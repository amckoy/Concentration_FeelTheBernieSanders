/* Team Feel the Bernie Sanders - Adam McKoy and Zicheng Zhen
   APCS1 pd10
   HW36 -- Some Folks Call It a Memory
   2015-11-23 */

// import cs1.Keyboard;  //if comfortable with Scanner, you may comment this out
import java.util.*;
		
public class Concentration {

    //instance variables
    private Tile[][] _board;     //storage for 4x4 grid of Tiles.
    private int _numberFaceUp;   //count of Tiles with faces visible
    private String[] _words = {"foo", "foo", "goo", "goo", 
			       "boo", "boo", "moo", "moo",
			       "lieu", "lieu", "coup", "coup",
			       "rue", "rue", "who", "who"};;     
                                 //list of unique Strings used for Tile vals
    private static int _numRows = 4;


    //insert constructor and methods here
    public Concentration() {
	for(int i = 0; i <= 15; i++){
	    swap( i, (int)(Math.random() * 16) );
	}
	
	_board = new Tile[4][4];
	for(int r = 0; r < 4; r++){
	    for(int c = 0; c < 4; c++){
		_board[r][c] = new Tile(_words[(2 * r) + c]);
	    }
	}
    }

    public void play(){
	display(_board);
    }
    
    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
    //helper functions
    private void swap( int i, int j ) {
	String iHolder = _words[i];
	_words[i] = _words[j];
	_words[j] = iHolder;
    } 

    private static void display( Tile[][] a ) {
	for(Tile[] i : a){
	    String line = "";
	    for(Tile j : i){
		line += j + "\t";
	    }
	    System.out.println(line);
	}
    }
    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
		
    //DO NOT MODIFY main()
    public static void main(String[] args){
	Concentration game = new Concentration();
       	game.play();
    }

}//end class Concentration

