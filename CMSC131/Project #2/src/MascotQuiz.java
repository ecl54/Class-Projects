import java.util.Scanner;
/*
 * Name: Eric Lancaster
 * Section: 0404
 * Teaching Assistant's Name: Xuetong 
 * Purpose: To quiz the user on the mascots of certain universities and inversely the universities 
 * of certain mascots. Keep the user's score based on how they answer these questions.
 * 
 * add comments as needed but all executable code must appear
 * between the two large comment blocks below.
*/
public class MascotQuiz {

	public static void main(String[] args) {

		int score = 0;
		
		String greeting = 
				"In this game, I ask you four questions about mascots for "
				+"US collegiate sports teams." +
				"\nYou get 1 point for each correct answer, "
				+"0 points if you type don't know, "
				+"and you lose a point for wrong answers.";
		final String schoolOptions = "University of Michigan, "
				+"University of Nebraska, "
				+"University of Oklahoma, "
				+"University of Wisconsin";
		final String mascotOptions = 
				"Badgers, Cornhuskers, Sooners, Wolverines";
		String prompt1 = 
				"\nType 1 and I'll give you the mascot and "
				+"you give give the school. \n"
				+"Type 2 and I'll give you the school and "
				+"you give me the mascot. \n"
				+"Type 3 and I'll quit.";		
		
		System.out.println( greeting );
		
		/*************************************************************
		 *  Do NOT delete, move, or change the lines of code above this:
		 * All of your code should appear between these comments.
		 ************************************************************/
		Scanner myScanner = new Scanner(System.in);
		int counter = 0;
		
		do{
			// Ask the user a question regarding universities and their mascots, keep user's score 
			// based on their answer to the question, and and ask four questions per game 
			// (the counter variable keeps tracks of questions per game, score variable tracks score) 
			// terminate when the user either quits by pressing 3 or says 'no' to playing another 
			// game at the end of a game. If the user says 'yes' instead then counter/score variables
			// will reset themselves and another game will begin
				
			System.out.println( prompt1 );
			String question;
			String answer;
			int numChoice = myScanner.nextInt();
			myScanner.nextLine();
			
			if ( numChoice == 1 ){
		
				if ( counter == 0 ) {
					question = "Sooners ? => ";
					answer = "University of Oklahoma";
				} else if ( counter == 1 ) {
					question = "Badgers ? => ";
					answer = "University of Wisconsin";
				} else if ( counter == 2 ) {
					question = "Wolverines ? => ";
					answer = "University of Michigan";
				} else {
					question = "Cornhuskers ? => ";
					answer = "University of Nebraska";
				}
				
				System.out.println( "Answer with one of: " + mascotOptions );
				System.out.print( question );
				String mascotInput = myScanner.nextLine();
				
				if ( mascotInput.equals( answer ) ) {
					score++;
				} else if ( mascotInput.equalsIgnoreCase( "don't know" ) ) {
					score = score;
				} else {
					score--;
				}
				
			} else if ( numChoice == 2 ) {
				
				if ( counter == 0 ) {
					question = "University of Oklahoma ? => ";
					answer = "Sooners";
				} else if ( counter == 1 ) { 
					question = "University of Wisconsin ? => ";
					answer = "Badgers";
				} else if ( counter == 2 ) { 
					question = "University of Michigan ? => ";
					answer = "Wolverines";
				} else {
					question = "University of Nebraska ? => ";
					answer = "Cornhuskers";
				}
				
				System.out.println( "Answer with one of: " +schoolOptions );
				System.out.print( question );
				String schoolInput = myScanner.nextLine();
			
				if ( schoolInput.equals(answer) ) {
					score++;
				} else if ( schoolInput.equalsIgnoreCase( "don't know" ) ) {
					score = score;
				} else {
					score--;
				}
				
			} else {
				break;
			}
			
			counter++;
			if ( counter == 4 ) {
				System.out.println( "Want to play again? (type yes or no)" );
				String repeatInput = myScanner.nextLine();
				if ( repeatInput.equalsIgnoreCase( "yes" ) ) {
					score = 0;
					counter = 0;
				}
			}
			
		} while ( counter != 4 );	
		
		/*************************************************************
		 *  Do NOT delete, move, or change this next line of code:
		 * This should be the last line of code in your program!
		 ************************************************************/
		System.out.println( "\nBye. Your score is " + score );
	}

}
