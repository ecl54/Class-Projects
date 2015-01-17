/**
 * Just a container, really, that serves as a place to house these public methods:
 * 
 * static Integer[] selectSort( Integer[] incoming );
 * 
 * static Integer[] selectSortReverse( Integer[] incoming );
 * 
 * static int findMin( int fromIndex, Integer[] arrayOfInts );
 * 
 * static int findMax( int fromIndex, Integer[] arrayOfInts );
 * 
 * static void swap( int fromPos, int toPos, Integer[] arrayOfInts);
 * 
 * Note: these MUST be public in order for you to pass any of the tests. 
 * 
 * @author UMD CD Department
 *
 */
public class SelectionSorter {
	/**
	 * Returns a sorted (from smallest to largest) shallow COPY of the incoming
	 * array of Integers.
	 * @param incoming
	 * @return
	 */
	public static Integer[] selectSort( Integer[] incoming ) {
		Integer[] newArray = new Integer[incoming.length];
		for (int a = 0; a < incoming.length; a++){
			newArray[a] = incoming[a];
		}
		
		int minIdx;
		
		for ( int i = 0; i < newArray.length-1; i++){
			minIdx = SelectionSorter.findMin(i, newArray);
			SelectionSorter.swap(i, minIdx, newArray);
		}
		return newArray;
	}
	/**
	 * Returns a sorted (from largest to smallest) copy of the incoming array
	 * of Integers.
	 * @param incoming
	 * @return
	 */
	public static Integer[] selectSortReverse( Integer[] incoming ) {
		Integer[] newArray = new Integer[incoming.length];
		for ( int a = 0; a < incoming.length; a++){
			newArray[a] = incoming[a];
		}
		int maxIdx;
		
		for ( int i = 0; i < newArray.length-1; i++){
			maxIdx = SelectionSorter.findMax(i, newArray);
			SelectionSorter.swap(i, maxIdx, newArray);
		}
		return newArray;
	}
	/**
	 * Return the index of the smallest element in the arrayOfInts, beginning
	 * the search fromIndex;
	 * @param fromIndex
	 * @param arrayOfInts
	 * @return
	 */
	public static int findMin( int fromIndex, Integer[] arrayOfInts ) {
		int minVal = arrayOfInts[fromIndex];
		int minIdx = fromIndex;
		
		for ( int i = fromIndex + 1; i < arrayOfInts.length; i++){
			if ( arrayOfInts[i] < minVal){
				minVal = arrayOfInts[i];
				minIdx = i;
			}
		}
		return minIdx;
	}
	/**
	 * Returns the index of the largest element in the arrayOfIntegers, beginning
	 * from the fromIndex.
	 * @param fromIndex
	 * @param arrayOfIntegers
	 * @return
	 */
	public static int findMax( int fromIndex, Integer[] arrayOfIntegers ) {
		int maxVal = arrayOfIntegers[fromIndex];
		int maxIdx = fromIndex;
		
		for ( int i = fromIndex + 1; i < arrayOfIntegers.length; i++){
			if ( arrayOfIntegers[i] > maxVal){
				maxVal = arrayOfIntegers[i];
				maxIdx = i;
			}
		}
		return maxIdx;
		
	}
	/**
	 * Swaps the contents in the toPos with the fromPos; note, this 
	 * method does not copy the array, but operates on the arrayOfInts
	 * directly.
	 * @param fromPos
	 * @param toPos
	 * @param arrayOfInts
	 */
	public static void swap( int fromPos, int toPos, Integer[] arrayOfInts ) {
		int storeFromVal = arrayOfInts[fromPos];
		arrayOfInts[fromPos] = arrayOfInts[toPos];
		arrayOfInts[toPos] = storeFromVal;
	}
	
}
