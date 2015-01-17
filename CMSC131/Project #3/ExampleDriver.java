import GridTools.MyGrid;

import java.util.Scanner;
/**
 *  THIS CLASS IS PROVDED FOR YOU.  USE IT TO TEST THE LETTERMAKER
 *  CLASS THAT YOU ARE WRITING.
 *   
 *  This driver relies on the "drawFlag" method of the "FlagMaker"
 *  class.  It prompts the user to enter information about what letter
 *  he/she would like to see.  Then it creates a DrawingGrid2, and calls
 *  the drawLetter method of the FlagMaker class to actually draw
 *  the letter.
 */
public class ExampleDriver {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		/* Get input from user about what flag to draw */
		System.out.println("Type the number corresponding to the name:  ");
		System.out.println("1 Poland");
		System.out.println("2 Ukraine");
		System.out.println("3 Czech Republic");
		System.out.println("4 Benin");
		System.out.println("5 Rwanda");
		System.out.println("6 Bahamas");
		System.out.println("7 Afghanistan");
		System.out.println("8 Jersey");
		System.out.println("9 Scotland");
		System.out.print("Your choice here:");
		int choice = scanner.nextInt();
		System.out.print("Choose a size (4 or larger): ");
		int size = scanner.nextInt();
		if (size < 4 || size >30){
			size = 4;
			choice = 99;
		}
		
		/* Create drawing grid of the height requested */
		MyGrid grid = new MyGrid(size);

		/* Draw the letter on the grid */
		FlagMaker.drawFlag(grid, choice);
	}
}
