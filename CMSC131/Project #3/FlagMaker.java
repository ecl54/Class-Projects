import java.awt.Color;
import GridTools.MyGrid;

public class FlagMaker {

	/**
	 * Name: Eric Lancaster
	 * Section: 0404
	 * TA: Xuetong Sun
	 * 
	 * Purpose: To draw the flags of various countries by painting 
	 * a colored grid based on the user's flagNumber and size selection. 
	 * This is achieved by drawing a number of colored shapes like 
	 * triangles and rectangles, as defined in the helper methods.
	 **/
	
	
	/* *************************************************
	 * Draws a single flag in the already created grid
	 * that is passed as the first parameter 
	 * according to the countryCode passed as the 
	 * second parameter.		
	 * 
	 * (Student: you will need to modify this method - the code
	 * provided here is for demonstration purposes only.			
	 * *************************************************/
	
	
	/**
	 * Purpose: Draw country flag based on user's flagNumber
	 * input and grid object. Incorrect dimensions or flagNumber
	 * lead to an error flag being drawn.
	 * 
	 * @param grid: Grid object to draw shape on
	 * @param flagNumber: Country number of flag to draw
	 */
	public static void drawFlag( MyGrid grid, int flagNumber ){
		final int MIDDLE_HT = grid.getHt() / 2;
		final int AREA_OF_GRID = grid.getWd() * grid.getHt();
		
		if ( checkDimensions( grid, flagNumber ) ){
			// dimensions are correct for given flag number
			
			if ( flagNumber == 1 ){
				// Poland -> height is even
				drawRect(grid, MIDDLE_HT, grid.getWd() - 1, grid.getHt() - 1, 0, Color.red);
				
				
			} else if ( flagNumber == 2 ){
				// Ukraine -> height is even 
				drawRect(grid, 0, grid.getWd() - 1, MIDDLE_HT - 1, 0, Color.blue );
				drawRect(grid, MIDDLE_HT, grid.getWd() - 1, grid.getHt() - 1, 0, Color.yellow);
			
			} else if ( flagNumber == 3 ){
				// Czech Reupublic -> height is even
				drawRect( grid, MIDDLE_HT, grid.getWd() - 1, grid.getHt() - 1, 0, Color.red );
				drawLine( grid, 0, 0, grid.getHt() - 1, 0, Color.blue );
				drawTriangle( grid, 0, 1, grid.getHt() - 1, 1, Color.blue );
				
			} else if ( flagNumber == 4 ){
				// Benin -> height is multiple of 6
				final int AREA_OF_RECT = AREA_OF_GRID / 3;
				int WIDTH_OF_RECT = AREA_OF_RECT / grid.getHt();
				
				drawRect( grid, 0, grid.getWd() - 1, grid.getHt() - 1, 0, Color.green );
				drawRect( grid, 0, grid.getWd() - 1, MIDDLE_HT - 1, WIDTH_OF_RECT, Color.yellow );
				drawRect( grid, MIDDLE_HT, grid.getWd() - 1, grid.getHt() - 1, WIDTH_OF_RECT, Color.red );
		
			} else if ( flagNumber == 5 ){
				// Rwanda -> height is multiple of 4
				int middleHalf = ( grid.getHt() / 2 );
				int quarter = ( middleHalf / 2 );
				
				drawRect( grid, 0, grid.getWd() - 1, middleHalf - 1,0, Color.blue );
				drawRect( grid, middleHalf, grid.getWd() - 1, middleHalf + quarter - 1, 0, Color.yellow );
				drawRect( grid, middleHalf + quarter, grid.getWd() - 1, grid.getHt() - 1, 0, Color.green );
		
			} else if ( flagNumber == 6 ){
				// Bahamas -> height is even
				drawRect( grid, 0, grid.getWd() - 1, grid.getHt() - 1, 0, Color.blue );
				drawLine( grid, MIDDLE_HT, 0, MIDDLE_HT, grid.getWd()-1, Color.yellow );
				drawLine( grid, MIDDLE_HT - 1, 0, MIDDLE_HT, grid.getWd()-1, Color.yellow );
				drawLine( grid, 0, 0, grid.getHt() - 1, 0, Color.black );
				drawTriangle( grid, 0, 1, grid.getHt() - 1, 1,Color.black );
				
			} else if ( flagNumber == 7 ){
				// Afghanistan -> height is multiple of 3
				int thirdOfWd = ( grid.getWd() / 3 );
				drawRect( grid, 0, thirdOfWd - 1, grid.getHt() - 1, 0, Color.black );
				drawRect( grid, 0, ( thirdOfWd*2) - 1, grid.getHt() - 1, thirdOfWd, Color.red );
				drawRect( grid, 0, ( thirdOfWd*3) - 1, grid.getHt() - 1, thirdOfWd*2, Color.green );
				
			} else if ( flagNumber == 8 ){
				// Jersey -> height is odd
				drawDiagonals( grid, Color.red );
				
			} else if ( flagNumber == 9 ){
				// Scotland -> height is odd
				drawRect ( grid, 0, grid.getWd() - 1, grid.getHt() - 1, 0, Color.blue );
				drawDiagonals ( grid, Color.white );
			}
			
	} else {
		// dimensions or country code is out of range 
		drawErrorFlag( grid );
	}
	
}
	/*Helper functions for the drawFlag method appear below this line*/
	
	/**
	 * Purpose: Draw a vertical or horizontal line across the 
	 * grid depending on user input with a landscape 
	 * orientation in mind.
	 * 
	 * User input as follows:
	 * @param grid: grid object vertical line is drawn on
	 * @param xStartCord: starting x-coordinate of line
	 * @param yStartCord: starting y-coordinate of line
	 * @param xEndCord: ending x-coordinate of line
	 * @param yEndCord: ending y-coordinate of line
	 * @param myColor: Color object specifying color of line
	 */
	public static void drawLine(MyGrid grid, int xStartCord, int yStartCord, 
									int xEndCord, int yEndCord, Color myColor){
	if (yStartCord == yEndCord){
		// Start/End coords on same y-plane so draw vertical line
		for ( int x = xStartCord; x <= xEndCord; x++ ){
			grid.setColor(x, yStartCord, myColor);
		}
	}else{
		// Assume then that xStartCord and xEndCord are equal
		// in which case we need to draw a horizontal line
		for( int y = yStartCord; y <= yEndCord; y++ ){
			grid.setColor( xStartCord, y, myColor );
			}
		}
	}
	
	/**
	 * Purpose: Draw a rectangle on the grid using its top left
	 * and bottom right x/y coordinates. 
	 * 
	 * User input as follows:
	 * @param grid: MyGrid object to draw rectangle on
	 * @param topLeftXCord: top left x-coordinate of rectangle
	 * @param topLeftYCord: top left y-coordinate of rectangle
	 * @param bottomRightXCord: bottom right x-coordinate of rectangle
	 * @param bottomRightYCord: bottom right y-coordinate of rectangle
	 * @param myColor: Color object specifies color of shape
	 */
	public static void drawRect( MyGrid grid, int topLeftXCord, int topLeftYCord,
								int bottomRightXCord, int bottomRightYCord, Color myColor){
		
		for (int x = topLeftXCord; x <= bottomRightXCord; x++){
			drawLine( grid, x, bottomRightYCord, x, topLeftYCord, myColor );
		}	
	}
	
	/**
	 * Purpose: Draw a triangle on the grid using its base
	 * left x/y and right x/y coordinates. We assume triangle
	 * coordinates to be on the same y-plane with height moving
	 * towards right side of grid.
	 * 
	 * User input as follows:
	 * @param grid: grid object to draw triangle on
	 * @param leftXCord: left x-coordinate of triangle base
	 * @param leftYCord: left y-coordinate of triangle base
	 * @param rightXCord: right x-coordinate of triangle base
	 * @param rightYCord: right y-coordinate of triangle base
	 * @param myColor: Color object specifies shape of color
	 */
	public static void drawTriangle( MyGrid grid, int leftXCord, int leftYCord,
						int rightXCord, int rightYCord, Color myColor ){	
		
		// The triangle shape increments in steps or blocks (of 1) until it hits 
		// the top of the triangle where it increments downwards by 1.
		int step = 0;
		
		int middleOfTri = ( ( rightXCord - leftXCord ) / 2 ); 
		
			for( int x = leftXCord; x <= middleOfTri; x++ ){
				drawLine( grid, x, leftYCord, x, leftYCord + step, myColor );
				drawLine( grid, rightXCord - x, leftYCord, rightXCord - x, leftYCord + step, myColor );
				step++;
		}
	}
	
	/**
	 * Purpose: Draw two diagonals on grid - one from top
	 * left to bottom right and another from top right
	 * to bottom left.
	 * 
	 * @param grid: MyGrid object to draw diagonals on
	 * @param myColor: Color object specifies color of shape
	 */
	public static void drawDiagonals( MyGrid grid, Color myColor ){
		int yStartCord = 0;
		
		for ( int x = 0; x < grid.getHt(); x++ ) {
			grid.setColor( x, yStartCord, myColor );
			grid.setColor( x, yStartCord+1, myColor );
			grid.setColor( x, ( grid.getWd() - yStartCord - 1 ), myColor );
			grid.setColor( x, ( grid.getWd() - yStartCord - 2), myColor );
			yStartCord = yStartCord + 2;
		}
	}
	/**
	 * Purpose: Draw the error flag with four red corners based on
	 * original dimensions specified. If the user's size was out of
	 * bounds 4<=x<=30 then size height is set to 4 and error flag
	 * is drawn. If incorrect flagNumber code was entered then error
	 * flag is drawn based on original dimensions (if suitable - above).
	 * 
	 * User Input as follows:
	 * @param grid: grid object to draw error flag on
	 */
	public static void drawErrorFlag( MyGrid grid ){

			grid.setColor( 0,0, Color.red );
			grid.setColor( 0, grid.getWd() - 1, Color.red );
			grid.setColor( grid.getHt() - 1, 0, Color.red );
			grid.setColor( grid.getHt() - 1, grid.getWd() - 1, Color.red );
	}
	
	/**
	 * Purpose: Check the dimensions of the flag based 
	 * on what the height should be. Return true/false
	 * which leads to whether drawErrorFlag is called or not.
	 * 
	 * User input as follows:
	 * @param grid: MyGrid object to draw on
	 * @param flagNumber: number of flag to draw on
	 * @return: return True/False based on whether dimensions
	 * are correct/incorrect given selected flag
	 */
	
	public static boolean checkDimensions( MyGrid grid, int flagNumber ){
		
		if ( flagNumber == 1 || flagNumber == 2 || flagNumber == 3 || flagNumber == 6 ){
			
			if ( grid.getHt() % 2 != 0 ) {
				return false;
			}
		} else if ( flagNumber == 4 ){
			
			if ( grid.getHt() % 6 != 0){
				return false;
			}
		} else if ( flagNumber == 5 ){
			
			if ( grid.getHt() % 4 != 0){
				return false;
			}
		} else if( flagNumber == 7 ){
			
			if ( grid.getHt() % 3 != 0){
				return false;
			}
		} else if ( flagNumber == 8 || flagNumber == 9 ){
			
			if ( grid.getHt() % 2 == 0 ){
				return false;
			}
		} else if ( flagNumber < 1 || flagNumber > 9 ){
			// flag number is not 1-9
			return false;
		}
	// return true if dimensions for given flag work 
	return true;
	}
}
