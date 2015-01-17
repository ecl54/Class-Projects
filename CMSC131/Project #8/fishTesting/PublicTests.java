package fishTesting;

import java.util.ArrayList;


import java.util.List;

import org.junit.Test;

import cmsc131Utilities.Random131;

import fishPond.Fish;
import fishPond.Model;
import fishPond.Plant;


import static org.junit.Assert.*;


public class PublicTests {


	@Test
	public void testTurnFish() {
		Random131.setDeterministic(1027);
		Model m = new Model(6, 6, 0, 0, 0);
		m.addFish(new Fish(1, 1, 2, Fish.LEFT));
		m.addFish(new Fish(3, 3, 2, Fish.DOWN));
		m.turnFish();
		assertEquals(Fish.RIGHT,m.getFish().get(0).getDirection());
		assertEquals(Fish.DOWN,m.getFish().get(1).getDirection());
	}


	@Test
	public void testMoveFish() {
		Random131.setDeterministic(1027);
		Model m = new Model(5, 5, 0, 0, 0);
		m.addFish(new Fish(1, 1, 2, Fish.LEFT));
		m.turnFish();
		assertEquals(Fish.RIGHT,m.getFish().get(0).getDirection());
		m.addPlant(new Plant(1,2,4));
		m.moveFish();
		assertEquals(6,m.getFish().get(0).getSize());
	}
	
	

	@Test
	public void testBasicPlantTests() {
		Plant p = new Plant(2, 2, 50);
		p.grow();
		assertEquals(51, p.getSize());
		p.removeBite(51);
		assertEquals(0, p.getSize());
		assertEquals(false, p.isAlive());
		p = new Plant(3, 3, 1);
		assertEquals(true, p.isAlive());
	}

	@Test
	public void testBasicFishTests() {
		Fish f1 = new Fish(0, 0, 100, Fish.UP);
		Fish f2 = new Fish(0, 0, 100, Fish.DOWN);
		Fish f3 = new Fish(0, 0, 300, Fish.RIGHT);
		Fish f4 = new Fish(0, 0, 499, Fish.LEFT);
		f1.fight(f2);
		assertEquals(200, f1.getSize());
		assertEquals(0, f2.getSize());
		f1.fight(f3);
		assertEquals(0, f1.getSize());
		assertEquals(500, f3.getSize());
		f3.fight(f4);
		assertEquals(0, f4.getSize());
		assertEquals(999, f3.getSize());
		f3.move();

		assertEquals(false, f4.isAlive());
		Fish deadFish = new Fish(2, 2, -1, Fish.UP);
		assertEquals(false, deadFish.isAlive());
		Fish liveFish = new Fish(2, 2, 1, Fish.LEFT);
		assertEquals(true, liveFish.isAlive());

		Fish upFish = new Fish(2, 2, 10, Fish.UP);
		Fish downFish = new Fish(2, 2, 10, Fish.DOWN);
		Fish leftFish = new Fish(2, 2, 10, Fish.LEFT);
		Fish rightFish = new Fish(2, 2, 10, Fish.RIGHT);
		upFish.move();
		downFish.move();
		leftFish.move();
		rightFish.move();
		assertEquals(1, upFish.getRow());
		assertEquals(2, upFish.getCol());
		assertEquals(3, downFish.getRow());
		assertEquals(2, downFish.getCol());
		assertEquals(2, leftFish.getRow());
		assertEquals(1, leftFish.getCol());
		assertEquals(2, rightFish.getRow());
		assertEquals(3, rightFish.getCol());

		upFish.shrink();
		assertEquals(8, upFish.getSize());
	}

	@Test
	public void testIsSpaceAvailable() {
		Model m = new Model(10,10,0,0,0);
		Fish f = new Fish(1, 7, 100, Fish.UP);
		Plant p = new Plant(2, 8, 100);
		m.addFish(f);
		m.addPlant(p);
		assertFalse(m.isSpaceAvailable(1, 7));
		assertFalse(m.isSpaceAvailable(2, 8));
		assertFalse(m.isSpaceAvailable(0, 0));
		for (int i = 1; i < 9; i++) {
			for (int j = 1; j < 9; j++) {
				if ((i != 1 || j != 7) && (i != 2  || j != 8)) {
					assertTrue(m.isSpaceAvailable(i, j));
				}
			}
		}
	}

	@Test
	public void testModelCopyConstructor() {
		Model m = new Model(10, 10, 3, 3, 3);

		Model copy = new Model(m);
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				assertEquals(m.getShape(i, j), copy.getShape(i, j));
		List<Fish> fish1 = m.getFish();
		List<Fish> fish2 = copy.getFish();
		for (int i = 0; i < fish1.size(); i++) {
			Fish f1 = fish1.get(i);
			Fish f2 = fish2.get(i);
			assertEquals(true, f1.getRow() == f2.getRow());
			assertEquals(true, f1.getCol() == f2.getCol());
			assertEquals(true, f1.getSize() == f2.getSize());
			assertEquals(true, f1.getDirection() == f2.getDirection());
			assertEquals(false, f1 == f2);
		}
		List<Plant> plant1 = m.getPlants();
		List<Plant> plant2 = copy.getPlants();
		for (int i = 0; i < plant1.size(); i++) {
			Plant p1 = plant1.get(i);
			Plant p2 = plant2.get(i);
			assertEquals(true, p1.getRow() == p2.getRow());
			assertEquals(true, p1.getCol() == p2.getCol());
			assertEquals(true, p1.getSize() == p2.getSize());
			assertEquals(false, p1 == p2);
		}
	}


	@Test
	public void testGetPlantsGetFish() {
		Model m = new Model(10, 10, 5, 5, 5);
		ArrayList<Fish> fList = m.getFish();
		ArrayList<Plant> pList = m.getPlants();
		ArrayList<Fish> fList2 = m.getFish();
		ArrayList<Plant> pList2 = m.getPlants();
		assertTrue(fList != fList2);
		assertTrue(pList != pList2);
		for (int i = 0; i < fList.size(); i++) {
			assertTrue(fList.get(i) == fList2.get(i));
		}
		for (int i = 0; i < pList.size(); i++) {
			assertTrue(pList.get(i) == pList2.get(i));
		}
	}

	@Test
	public void testFishEatPlant() {
		Fish f = new Fish(5, 5, 100, Fish.UP);
		Plant p = new Plant(5, 5, 120);
		int biteAmount = Math.min(Plant.PLANT_BITE_SIZE, p.getSize());
		Model.fishEatPlant(f, p);
		assertEquals(f.getSize(), 100 + biteAmount);
		assertEquals(p.getSize(), 120 - biteAmount);
		Fish f2 = new Fish(5, 5, 100, Fish.LEFT);
		Plant p2 = new Plant(5, 5, 40);
		biteAmount = Math.min(Plant.PLANT_BITE_SIZE, p2.getSize());
		Model.fishEatPlant(f2, p2);
		assertEquals(f2.getSize(), 100 + biteAmount);
		assertEquals(p2.getSize(), 40 - biteAmount);
	}

	
}
