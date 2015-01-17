package fishTesting;

import cmsc131Utilities.Random131;

import static org.junit.Assert.*;

import org.junit.Test;

import fishPond.Fish;
import fishPond.Model;
import fishPond.Plant;


public class StudentTests {

	@Test
	public void testPlantGrow() {
		Plant p = new Plant(2, 2, 50);
		p.grow();
		assertEquals(51, p.getSize());
	}

	@Test
	public void testBasicMoveFishTest() {
		Fish f1 = new Fish(0, 0, 100, Fish.DOWN);
		f1.move();
		assertEquals(Fish.DOWN,f1.getDirection());
	}

	@Test
	public void testTurnOneFish() {
		Random131.setDeterministic(1027);
		Model m = new Model(6, 6, 0, 0, 0);
		m.addFish(new Fish(1, 1, 2, Fish.LEFT));
		m.turnFish();
		assertEquals(Fish.RIGHT,m.getFish().get(0).getDirection());
	}

	@Test
	public void testMoveOneFish() {
		Random131.setDeterministic(1027);
		Model m = new Model(5, 5, 0, 0, 0);
		m.addFish(new Fish(1, 1, 2, Fish.LEFT));
		m.turnFish();
		assertEquals(Fish.RIGHT,m.getFish().get(0).getDirection());
		m.addPlant(new Plant(1,2,4));
		m.moveFish();
		assertEquals(6,m.getFish().get(0).getSize());
	}
	/* all student-authored tests should be below this line. */
	@Test
	public void testRemoveDeadFish(){
		Model m = new Model(5,5,0,0,0);
		Fish deadFish1 = new Fish(1,1, 0, Fish.DOWN);
		m.addFish(deadFish1);
		assertEquals(m.getFish().get(0), deadFish1);
		m.removeDeadFish();
		assertTrue(m.getFish().size() == 0);
		
		Fish aliveFish1 = new Fish(2,3, 100, Fish.DOWN);
		Fish aliveFish2 = new Fish(2,2, 100, Fish.DOWN);
		Fish deadFish2 = new Fish(3,3, 0, Fish.DOWN);
		
		m.addFish(aliveFish1);
		m.addFish(deadFish1);
		m.addFish(deadFish2);
		m.addFish(aliveFish2);
		
		m.removeDeadFish();
		
		for(Fish anyFish: m.getFish()){
			assertTrue(anyFish.isAlive());
		}
		
	}
	@Test
	public void testGetColsRowws(){
		Model m = new Model(5, 7, 0, 0, 0);
		assertEquals(5, m.getRows());
		assertEquals(7, m.getCols());
	}
	@Test
	public void testFishMethods(){
		Fish testFish1 = new Fish(5,5, 8, Fish.LEFT);
		assertTrue(testFish1.getCol() == 5 && testFish1.getRow() == 5 
				&& testFish1.getSize() == 8 && testFish1.getDirection()==Fish.LEFT);
		assertTrue(testFish1.isAlive());
		
		Fish smallerFish1 = new Fish(6,6, 5, 2);
		testFish1.fight(smallerFish1);
		assertTrue((8 + 5) == testFish1.getSize());
		testFish1.eat(5);
		assertTrue(testFish1.getSize() == (8+5+5));
		testFish1.move();
		assertTrue(testFish1.getCol() == 4);
		testFish1.setRandomDirection();
		assertTrue(testFish1.getDirection() == testFish1.LEFT || testFish1.getDirection() == testFish1.RIGHT
				|| testFish1.getDirection() == testFish1.DOWN || testFish1.getDirection() == testFish1.UP);
		
	
	}
	@Test
	public void testPlantMethods(){
		Plant testPlant1 = new Plant(5,6,10);
		assertTrue(testPlant1.getRow() == 5 && testPlant1.getCol() == 6 && testPlant1.getSize() == 10);
		assertTrue(testPlant1.isAlive());
		testPlant1.grow();
		assertTrue(testPlant1.getSize() == 11);
		testPlant1.removeBite(10);
		assertEquals(testPlant1.getSize(), 1);
	
	}
	@Test
	public void testModelMethods(){
		
		Model m2  = new Model(5,5,0,0,0);
		Fish f = new Fish(1,1,10, Fish.RIGHT);
		m2.addFish(f);
		m2.moveFish();
		assertTrue(f.getCol() == 2 || f.getRow() == 2);
		m2.moveFish();
		
		Model m3 = new Model(5,5,0,0,0);
		Fish f2 = new Fish(1,1,10, Fish.RIGHT);
		Plant p1 = new Plant(1,2,5);
		
		m3.addFish(f2);
		m3.addPlant(p1);
		m3.moveFish();
		
		assertTrue(p1.getSize() == 0);
		assertTrue(m3.getPlants().get(0).equals(p1));
		m3.removeDeadPlants();
		assertTrue(m3.getPlants().size() == 0);
		
		Model m4 = new Model(5,5,0,0,0);
		Fish largeFish = new Fish(1,1,10,Fish.RIGHT);
		Fish smallFish = new Fish(1,2,5,Fish.LEFT);
		m4.addFish(largeFish);
		m4.addFish(smallFish);
		assertTrue(!(m4.isSpaceAvailable(smallFish.getRow(), smallFish.getCol())));
		m4.moveFish();
		assertTrue(smallFish.getSize() == 0);
		assertTrue(largeFish == m4.getFish().get(0));
		assertTrue(smallFish == m4.getFish().get(1));
		m4.removeDeadFish();
		assertTrue(m4.getFish().size() == 1);
		assertTrue(m4.getShape(0, 0) == m4.ROCK);
		assertTrue(m4.getShape(3, 2) == m4.WATER);
		
		
		Model m5 = new Model(5,5,0,0,0);
		Fish largeFish2 = new Fish(1,3, 10, Fish.RIGHT);
		Fish samePlaceFish = new Fish(1,3,10,Fish.RIGHT);
		Fish smallFish2 = new Fish(3,3, 10, Fish.RIGHT);
		Plant largePlant = new Plant(3,1,Plant.PLANT_BITE_SIZE);
		Plant samePlacePlant = new Plant(3,1,10);
		Fish onRockFish = new Fish(0,0,10,Fish.LEFT);
		
		
		m5.addFish(largeFish2);
		try{
			m5.addFish(samePlaceFish);
			fail("Two fishes in one place should have failed");
		}catch(fishPond.IllegalFishPositionException e){
			// caught error successfully
		}
		m5.addFish(smallFish2);
		m5.addPlant(largePlant);
		try{
			m5.addPlant(samePlacePlant);
			fail("Two plants in one place should have failed");
		}catch(fishPond.IllegalPlantPositionException e){
			// caught error successfully
		}
		try{
			m5.addFish(onRockFish);
			fail("Fish on rock should have failed");
		}catch(fishPond.IllegalFishPositionException e){
			// caught error successfully
		}
		m5.growPlants();
		assertTrue(largePlant.getSize() == largePlant.PLANT_BITE_SIZE+1);
		m5.shrinkFish();
		assertTrue(largeFish2.getSize() == 8 );
		
		
	}
}
