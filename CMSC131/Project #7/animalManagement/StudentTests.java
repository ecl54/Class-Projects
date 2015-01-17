package animalManagement;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTests {

	@Test
	public void checkAvailabilityTest() {
		SortedListOfImmutables list1 = new SortedListOfImmutables();
		list1.add( Animal.ANIMAL_OBJECTS[0]);
		list1.add( Animal.ANIMAL_OBJECTS[1]);
		list1.add( Animal.ANIMAL_OBJECTS[2]);
		list1.add( Animal.ANIMAL_OBJECTS[3]);
		
		SortedListOfImmutables list2 = new SortedListOfImmutables();
		list2.add( Animal.ANIMAL_OBJECTS[1]);
		list2.add( Animal.ANIMAL_OBJECTS[3]);
		
		assertTrue(list1.checkAvailability(list2));
		
		list2.add( Animal.ANIMAL_OBJECTS[5]);
		assertFalse(list1.checkAvailability(list2));
		list2.add(Animal.ANIMAL_OBJECTS[4]);
		list2.add(Animal.ANIMAL_OBJECTS[7]);
		assertEquals(list2.toString(), 
				"[ Cockatoo, Flamingo, Lion, Lioness, Owl ]");
		
	}
	@Test
	public void checkInvetoryTest(){
		PetStore testStore = new PetStore("My Store", 10000000);
		assertEquals(testStore.getName(), "My Store");
		assertEquals(testStore.getCash(), 10000000);
		
		SortedListOfImmutables animalList = new SortedListOfImmutables();
		animalList.add(Animal.ANIMAL_OBJECTS[0]);
		animalList.add(Animal.ANIMAL_OBJECTS[4]);
		animalList.add(Animal.ANIMAL_OBJECTS[5]);
		animalList.add(Animal.ANIMAL_OBJECTS[7]);
		animalList.add(Animal.ANIMAL_OBJECTS[2]);
		
		Menagerie testAnimals = new Menagerie("My Animals", animalList);
		assertEquals(testAnimals.getAnimalList().toString(), "[ Chipmunk, Firefox, Lion, Lioness, Owl ]");
		assertEquals(testAnimals.getName(), "My Animals");
		
		int animalListRetailValue = Animal.ANIMAL_OBJECTS[0].getRetailValue()+
				 Animal.ANIMAL_OBJECTS[2].getRetailValue()+
				 Animal.ANIMAL_OBJECTS[4].getRetailValue()+
				 Animal.ANIMAL_OBJECTS[5].getRetailValue()+
				 Animal.ANIMAL_OBJECTS[7].getRetailValue();
		assertEquals(testAnimals.getRetailValue(), animalListRetailValue);
		
		int animalListWholeSalecost = Animal.ANIMAL_OBJECTS[0].getWholesaleCost()+
				 Animal.ANIMAL_OBJECTS[2].getWholesaleCost()+
				 Animal.ANIMAL_OBJECTS[4].getWholesaleCost()+
				 Animal.ANIMAL_OBJECTS[5].getWholesaleCost()+
				 Animal.ANIMAL_OBJECTS[7].getWholesaleCost();
		assertEquals(testAnimals.getWholesaleCost(), animalListWholeSalecost);
		
		testStore.addMenagerie(testAnimals);
		assertTrue(testStore.getMenu().checkAvailability(testAnimals));
		
		assertTrue(testStore.addShipmentToInventory(testAnimals.getAnimalList()));
		assertEquals(testStore.getCash(), 10000000 - testAnimals.getWholesaleCost() );
		assertEquals(testStore.getInventory().toString(), testAnimals.getAnimalList().toString());
		assertTrue(testStore.checkIfInInventory(testAnimals));
		
		
		SortedListOfImmutables animalList2 = new SortedListOfImmutables();
		animalList2.add(Animal.ANIMAL_OBJECTS[0]);
		animalList2.add(Animal.ANIMAL_OBJECTS[4]);
		animalList2.add(Animal.ANIMAL_OBJECTS[5]);
		animalList2.add(Animal.ANIMAL_OBJECTS[7]);
		animalList2.add(Animal.ANIMAL_OBJECTS[2]);
		animalList2.add(Animal.ANIMAL_OBJECTS[2]);
		
		Menagerie testAnimals2 = new Menagerie("My AnimalsZ", animalList2);
		assertFalse(testStore.checkIfInInventory(testAnimals2));
		
		assertFalse(testStore.placeOrder(testAnimals2));
		assertEquals(testStore.getCash(), (10000000 - testAnimals.getWholesaleCost()));
		
		testStore.placeOrder(testAnimals);
		assertEquals(testStore.getCash(), 10000000 + (testAnimals.getRetailValue() - testAnimals.getWholesaleCost()));
		
		Menagerie testAnimals3 = new Menagerie("An Animal List", animalList2);
		Menagerie testAnimals4 = new Menagerie("ZZZZZ", animalList2);
		
		testStore.addMenagerie(testAnimals3);
		testStore.addMenagerie(testAnimals4);
		
		assertTrue( testStore.getMenu().checkAvailability(testAnimals3));
		
	}

}
