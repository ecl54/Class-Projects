package p6_tests;

import static org.junit.Assert.*;
import org.junit.Test;
import animalManagement.*;


public class ExampleTests  {

	private static final Animal CHIPMUNK = Animal.ANIMAL_OBJECTS[0];
	private static final Animal COCKATOO = Animal.ANIMAL_OBJECTS[1];
	private static final Animal FIREFOX = Animal.ANIMAL_OBJECTS[2];
	private static final Animal FLAMINGO = Animal.ANIMAL_OBJECTS[3];
	private static final Animal LION = Animal.ANIMAL_OBJECTS[4];
	
	@Test
	public void testDefaultConstructorAndGetSize() {
		SortedListOfImmutables list = new SortedListOfImmutables();
		assertTrue(list.getSize() == 0);
		assertEquals("[  ]", list.toString());
	}
	
	@Test
	public void testListSimpleAdd() {
		SortedListOfImmutables list = new SortedListOfImmutables();
		for (int i = Animal.ANIMAL_OBJECTS.length - 1; i >= 0; i--) {
			list.add(Animal.ANIMAL_OBJECTS[i]);
		}
		assertEquals(Animal.ANIMAL_OBJECTS.length, list.getSize());
		assertEquals(
			"[ " +
			"Chipmunk, Cockatoo, Firefox, Flamingo, Lion, Lioness, "+
			"Orangutan, Owl, Panda, Tamarin, Tiger, "+
			"Toucan, Vulture, Zebra ]",
			
			list.toString()
		);
		
		list.add(CHIPMUNK);
		list.add(COCKATOO);
		list.add(FIREFOX);
		list.add(FLAMINGO);
		list.add(FIREFOX);
		list.add(LION);
		assertEquals(20, list.getSize());
		assertEquals(
				"[ " +
				"Chipmunk, Chipmunk, Cockatoo, Cockatoo, Firefox, Firefox, Firefox, "+
				"Flamingo, Flamingo, Lion, Lion, Lioness, "+
				"Orangutan, Owl, Panda, Tamarin, Tiger, "+
				"Toucan, Vulture, Zebra ]",
				
				list.toString()
		);
	}	
	
	
	
	@Test
	public void testRemoveExample() {
		SortedListOfImmutables list1 = new SortedListOfImmutables();
		SortedListOfImmutables list2 = new SortedListOfImmutables();

		list1.add(CHIPMUNK);
		list1.add(FIREFOX);
		list1.add(FIREFOX);
		list1.add(LION);
		list1.add(LION);
		
		
		list2.add(CHIPMUNK);
		list2.add(CHIPMUNK);
		list2.add(FIREFOX);
		list2.add(LION);
		list2.add(LION);
		
		list1.remove(list2);	
		assertEquals("[ Firefox ]", list1.toString());
	}
	
	
}
