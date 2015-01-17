import java.util.EmptyStackException;

/**
 * Complete the implementation of this class.
 * Use an array of objects as the "backing-store."
 * Note: carefully study the comments on each of the
 * interface methods and make sure that your implementation
 * throws all required exceptions, etc.
 * 
 * @author UMD CS Department.
 *
 */
public class MyStack implements IStack {
	// declare instance variables here
	Object[] stackArray;
	// define constructor(s) here
	public MyStack(){
		this(0);
	}
	public MyStack( int capacity ) {
		this.stackArray = new Object[capacity];
	}

	@Override
	public boolean empty() {
		// check if array contains no elements
		if( stackArray.length == 0 ){ 
			return true;
		}
		// if even one element in array is non-null then array is not empty 
		for( int i = 0; i < stackArray.length; i++){
			if( stackArray[i] != null){
				return false;
			}
		}
		// otherwise, array is full of null elements (i.e. empty)
		return true;
	}

	@Override
	public Object peek() {
		if( this.empty() == true){ 
			throw new EmptyStackException();
		}else{
			// loop through top-to-bottom checking for the first real Object
			for( int i = this.stackArray.length-1; i >= 0; i-- ){
				if( this.stackArray[i] != null && this.stackArray[i] instanceof Object){
					return this.stackArray[i];
				}
			}
			// this shouldn't happen if empty method is correct
			throw new EmptyStackException();
		}
	}
	@Override
	public Object pop() {
		if( this.empty() == true ){ 
			throw new EmptyStackException();
		}else{
			// stack is not empty -> loop through top-to-bottom
			// search for first real object (not null)
			for( int i = this.stackArray.length-1; i >= 0; i--){
				if( this.stackArray[i] != null ){
					Object tempObj = this.stackArray[i];
					this.stackArray[i] = null;
					return tempObj;
				}
			}
			// shouldn't happen if empty method is correct
			throw new EmptyStackException();
		}
	}

	@Override
	public void push(Object obj) {
		// stack array size is not zero
		if( stackArray.length != 0){
			// test if stackArray is full (i.e. no nulls)
			for( int i = 0; i < this.stackArray.length; i++){
				// if there exists a null then array is not full
				if( this.stackArray[i] == null ){
					this.stackArray[i] = obj;
					return;
				}
			}
			throw new StackOverflowError();
		}else{
			throw new StackOverflowError();
		}
	}

	@Override
	public int search(Object obj) {
		for( int i = this.stackArray.length-1; i >= 0; i-- ){
			if( this.stackArray[i].equals(obj) ){
				return i;
			}
		}
		return -1;
	}

}

