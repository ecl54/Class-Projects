/*
 * You will need to change the values where indicated below to match
 * the correct answers.  Some of the answers will be in the notes. 
 * Others you might need to look for online.  If you look online for
 * any answers, provide the source(s) in comment(s) below.
 * 
 * Please observe that the replacement "variables" appear between
 * the <>'s, such as <myName>, throughout this assignment. DO NOT type
 * the <>'s ... just the text that belongs between them. Also note
 * that all but one variable is a String; the other an integer (an int).
 */

public class History {

	public static void main(String[] args) {
		/*
		 * Replace myName with your name, then use the String concatenation
		 * operator, +, to assemble the message:
		 * "Hello. My name is <myName>."
		 */
		String myName = "Eric Lancaster";
		System.out.println( "Hello. My name is " + myName ); 
		
		/*
		 * Replace the <deviceName> with the name of the textile manufacturing
		 * device that was discussed in class or that you obtained from your
		 * research.
		 * Next, use the String concatenation operator to assemble the message:
		 * "In 1801, the <deviceName> used punch-cards to control textile manufacturing."
		 */
		String deviceName = "jacquard loom";
		System.out.println( "In 1801, the " + deviceName + " used punch-cards to control textile manufacturing." );
		
		/*
		 * Replace the variables, inventorName and inventionName, with the
		 * proper nouns. Use the String concatenation operator, +, to 
		 * assemble the message:
		 * "In 1968, <inventorName> demonstrated the <inventionName> that we use every day."
		 */
		String inventorName = "Douglas Engelbart";
		String inventionName = "mouse"; // hint: you point with it.
		System.out.println( "In 1968, " + inventorName + " demonstrated the " + inventionName + " that we use every day." );
		
		/*
		 * Replace the variable <yearWWW> with the correct year (from class discussion or
		 * from your research) and use it to assemble the message:
		 * "The World Wide Web went public on the alt.hypertext newsgroup in <yearWWW>."
		 */
		String yearWWW = "1991";
		System.out.println( "The World Wide Web went public on the alt.hypertext newsgroup in " + yearWWW + "." );
		
		/*
		 * Replace the <techWord> with the proper noun and use it to complete the
		 * message:
		 * "<techWord> is what makes up the physical machine."
		 */
		String techWord = "Hardware";
		System.out.println( techWord + " is what makes up the physical machine." );
		
		/*
		 * Replace <bitsInByte> to correctly construct the message:
		 * "There are <bitsInByte> bits in a byte."
		 */
		int bitsInByte = 8;
		System.out.println( "There are " + bitsInByte + " bits in a byte." );
		
		/*
		 * Replace the <cryptoAnswer> variable with the correct noun that completes the
		 * message:
		 * "The cryptographic technique of hiding a message in plain sight (whose name
		 * comes from stegano and graphein) is <cryptoAnswer>"
		 */
		String cryptoAnswer = "steganography";
		System.out.println( "The cryptographic technique of hiding a message in plain site (whose name comes from steganos and graphein) is " + cryptoAnswer + ".");
	}
	
}
