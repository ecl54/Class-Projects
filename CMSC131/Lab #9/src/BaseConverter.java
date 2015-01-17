import java.util.Stack;
/**
 * Uses Java's builtin <code>Stack</code> class to facilitate your writing
 * a <code>static</code> method called <code>fromBase10</code> that 
 * takes two integers: the first is the integer (base 10 > 1) that you
 * wish to have converted into the second integer, the base, an integer
 * greater than 1.
 * 
 * @author UMD CS Department
 *
 */

public class BaseConverter {
	/* Don't change this unless you know what you're doing. */
	private static Stack theStack = new Stack();
	/**
	 * Iteratively deconstructs <code>n</code> (assumed base-10) by the algorithm we discussed in 
	 * class (and that is summarized in the accompanying Lab Notes) and uses
	 * Java's <code>StringBuilder</code> class to accumulate the resulting
	 * digits in the desired base, i.e., the <code>to_base</code>/
	 * 
	 * @param n (an <code>int</code> greater than 0)
	 * @param to_base (an <code>int</code> greater than 1)
	 * @return (<code>String</code>) the number n translated into the desired base.
	 */
	public static String fromBase10( int n, int to_base ) {
		StringBuilder sb = new StringBuilder();
		if( n == 0 ){
			sb.append(n);
			return sb.toString();
		}
		while(n > 0){
			int r =  n % to_base;
			n = (n / to_base);
			theStack.push(r);
		}
		do{	
			sb.append(theStack.pop());
		}while(theStack.isEmpty() == false);
		return (sb.toString());
	}
	/**
	 * [Optional method] Implement this method if you are up for a challenge. 
	 * The idea is to avoid using a Stack all together. (The Public tests are written
	 * so as to exercise this method only if the method body DOES NOT throw the
	 * UnsupportedOperationException. So, if you do nothing, then no points
	 * should be deducted for calls to this method by the test methods.)
	 * 
	 * @param n (an <code>int</code> > 0)
	 * @param to_base (an <code>int</code> > 1
	 * @return a <code>String</code> representing the number n (base 10) in its new base.
	 */
	public static String fromBase10NoStack( int n, int to_base ) {
		throw new UnsupportedOperationException( "you must implement this method" );
	}

	
}
