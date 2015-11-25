/* Team Feel the Bernie Sanders - Nick Ng & Zicheng Zhen
   APCS1 pd10
   HW36 -- Some Folks Call It a Memory [Revised]
   2015-11-24 */

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
	for(int i = 0; i < _words.length; i++){
	    swap( i, (int)(Math.random() * 16) );
	}
	
	_board = new Tile[4][4];
	for(int r = 0; r < 4; r++){
	    for(int c = 0; c < 4; c++){
		_board[r][c] = new Tile(_words[(4 * r) + c]);
	    }
	}
    }

    public void play(){
	display(_board);
	int moves = 0;
	int numTiles = _board[0].length * _board.length; // Robustied for future use.
	int len = _board[0].length;
	while (countFaceUp() < numTiles) {
	    try {
		Scanner sc = new Scanner(System.in);
		sc.reset();
		System.out.print("Please choose the first tile [x y]: ");
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		if (x1 >= len || y1 >= len || _board[x1][y1].isFaceUp()) {
		    throw new Exception();
		} // Verifcation.
		System.out.println();
		_board[x1][y1].flip(); // Flips tile 1.
		display(_board);
		System.out.print("Please choose the second tile [x y]: ");
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		if (x2 >= len || y2 >= len) {
		    _board[x1][y1].flip();
		    display(_board);
		    throw new Exception();
		} // Verifcation.
		System.out.println();
		if (x1 == x2 && y1 == y2) {
		    System.out.println("You can't choose the same tile, silly!\n");
		    _board[x1][y1].flip();
		    display(_board);
		    continue; // skips the rest
		}
		_board[x2][y2].flip(); // Flip it.
		if (_board[x1][y1].equals(_board[x2][y2])) { // Two tiles are equal.
		    display(_board);
		    System.out.println("Booyah!");
		} else { // If not equal.
		    display(_board);
		    System.out.println("Close, but no cigar.");
		    System.out.println();
		    _board[x1][y1].flip(); //
		    _board[x2][y2].flip(); //
		    display(_board);
		}
		moves += 1;
	    } catch (Exception ex) {
		System.out.println("Please enter valid values!");
	    }
	}
	System.out.println("Congratulations! You won in " + moves + " moves!");
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

    private int countFaceUp() {
	int count = 0;
	for (Tile[] i : _board) {
	    for (Tile j : i) {
		if (j.isFaceUp())
		    count += 1;
	    }
	}
	return count;
    }
    
    /*
    private static boolean allFaceUp(Tile[][] a) { // Win Condition
	for (Tile[] i : a) {
	    for (Tile j : i) {
		if (j.isFaceUp() == false)
		    return false;
	    }
	}
	return true;
    }
    */
    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
		
    //DO NOT MODIFY main()
    public static void main(String[] args){
	Concentration game = new Concentration();
       	game.play();
    }

}//end class Concentration

