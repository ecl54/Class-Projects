import static org.junit.Assert.*;

import org.junit.Test;


public class StudentTests {

	@Test
	public void test() {
		// add your tests here.
	}
	@Test
	public void selectSortTest(){
		Integer[] sortedArray = {0,1,2,3,4};
		Integer[] unsortedArray = {3,2,4,0,1};
		Integer[] postSortArray = SelectionSorter.selectSort(unsortedArray);
		
		for ( int i = 0; i < 5; i++){
			assertEquals(postSortArray[i], sortedArray[i]);
			
		
		}
		
	}
	@Test
	public void selectMinTest(){
		Integer[] testArray = {4,5,3,6,7};
		int minIdx = SelectionSorter.findMin(0, testArray); 
		assertEquals(minIdx, 2);
	}
	@Test
	public void selectMaxTest(){
		Integer[] testArray = {4,3,7,2,5};
		int maxIdx = SelectionSorter.findMax(0, testArray);
		assertEquals(maxIdx, 2);
	}
	@Test
	public void SelectSortReverseTest(){
		Integer[] sortedArray = {4,3,2,1,0};
		Integer[] unsortedArray = {3,2,4,0,1};
		Integer[] postSortArray = SelectionSorter.selectSortReverse(unsortedArray);
		
		for ( int i = 0; i < 5; i++){
			assertEquals(postSortArray[i], sortedArray[i]);
		}			
	}
	@Test public void swap(){
		Integer[] testArray = {4,3};
		SelectionSorter.swap(0, 1, testArray);
		assertTrue(testArray[0] == 3);
		assertTrue(testArray[1] == 4);
	}
	
}
