/**
 * An approximation of Java's Stack ...
 * 
 * @author tomr55
 *
 */
public interface IStack {
	/**
	 * Returns true iff this stack is empty
	 * @return
	 */
	public boolean empty();
	/**
	 * Adds obj to stack. Note, may throw
	 * a StackOverflowError if the object 
	 * implementing the stack is out of
	 * space.
	 * @param obj
	 */
	public void push( Object obj );
	/**
	 * Removes and Returns the object at the top of the
	 * stack. Note, will throw an EmptyStackException
	 * if the stack is empty
	 * @return
	 */
	public Object pop();
	/**
	 * Returns the object at the top of the stack.
	 * Note, throws an EmptyStackException if called
	 * on an empty stack.
	 * @return
	 */
	public Object peek();
	/**
	 * Returns the "index" of the obj in stack.
	 * Note, if more than one obj exists in the
	 * stack, this method should return the first,
	 * i.e., the one closest to the top of the
	 * stack.
	 * If obj is not in the stack, then -1 is returned.
	 */
	public int search( Object obj );
}
