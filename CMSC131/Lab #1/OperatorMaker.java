import java.awt.Color;
import GridTools.SquareGrid;

public class OperatorMaker {
	
	/* Name: Eric Lancaster
	 * Section: 0404
	 * Teaching Assistant's Name: Xuetong 
	 */

	
	
	/* *************************************************
	 * Draws a single Operator in the already created grid
	 * that is passed as the first parameter 
	 * according to the symbol selection passed as the 
	 * second parameter by calling the appropriate
	 * helper method.	
	 * 
	 * All of the methods are static and are passed in a
	 * SquareGrid and the number indicating which symbol 
	 * to draw.				
	 * *************************************************/
	
	public static void drawOp(SquareGrid grid, int symbol) {
		if ( symbol == 1 ){
			minus(grid);
		}else if ( symbol == 2 ){
			plus(grid);
		}else if ( symbol == 3 ){
			divide(grid);
		}else{
			multiply(grid);
		}
	}

	/*
	 * The helper methods you should write...
	 * 
	 * 
	 * You may add more helper methods if you want, but they 
	 * all need to be static as well.	
	 */
	public static void minus(SquareGrid grid){
		int middle = ( grid.getHt() / 2 );
		for ( int i = 0; i < grid.getHt(); ++i ){
			grid.setColor( middle, i, Color.BLUE );
		}
	}

	public static void plus(SquareGrid grid){
		int middle = (grid.getHt() / 2);
		minus(grid);
		for ( int i = 0; i < grid.getHt(); ++i ){
			grid.setColor(i, middle, Color.BLUE);
		}
	}

	public static void divide(SquareGrid grid){
		for (int i = 0; i < grid.getHt() ; i++ ){
			grid.setColor( grid.getHt()-1-i, i , Color.BLUE );
		}
		
	}
	public static void multiply(SquareGrid grid){
		plus(grid);
		divide(grid);
		for ( int i = 0; i < grid.getHt(); ++i ){
			grid.setColor(i, i, Color.BLUE);
		}
		
	}

	
}

