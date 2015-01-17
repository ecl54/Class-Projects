import static org.junit.Assert.*;

import org.junit.Test;


public class StudentTests {
	
	/* 
	 * implement any or all of the following tests.
	 * If you do not wish to implement a particular test then
	 * you may either remove its declaration and method implementation
	 * from this file, or just remove the body of the method that you
	 * will to exclude from the tests ... in this way the method will
	 * not "fail" upon the execution of the remaining tests in this
	 * file.
	 */

	@Test
	public void testRationalIntInt() {
		Rational test = new Rational(3, 3);
		assertEquals(3, test.getNumer());
		assertEquals(3, test.getDenom());
	}

	@Test
	public void testRationalRational() {
		Rational test = new Rational(3, 3);
		Rational copy = new Rational(test);
		assertEquals(test.getNumer(), copy.getNumer());
		assertEquals(test.getDenom(), copy.getDenom());
	}

	@Test
	public void testGetNumer() {
		int myNumerator = 5;
		Rational test = new Rational(myNumerator, 3);
		assertEquals(myNumerator, test.getNumer());
	}

	@Test
	public void testGetDenom() {
		int myDenom = 5;
		Rational test = new Rational(myDenom, 5);
		assertEquals(myDenom, test.getDenom());
	}

	@Test
	public void testToString() {

		Rational test = new Rational(3,5);
		String testString = test.toString();
		assertEquals(testString, "3/5");
	}

	@Test
	public void testReciprocal() {
		Rational test = new Rational(5, 6);
		Rational recipRational = test.reciprocal();
		assertEquals(recipRational.getNumer(), test.getDenom());
		assertEquals(recipRational.getDenom(), test.getNumer());
	}

	@Test
	public void testMultiply() {
		Rational testRat1 = new Rational(5, 6);
		Rational testRat2 = new Rational(7, 8);
		Rational multiRat = Rational.multiply(testRat1, testRat2);
		assertEquals(testRat1.getNumer()*testRat2.getNumer(), multiRat.getNumer());
		assertEquals(testRat1.getDenom()*testRat2.getDenom(), multiRat.getDenom());
	}

	@Test
	public void testDivide() {
		Rational testRat1 = new Rational(5, 6);
		Rational testRat2 = new Rational(7, 8);
		Rational divideRat = testRat1.divide(testRat2);
		assertEquals(testRat1.getNumer()*testRat2.getDenom(), divideRat.getNumer());
		assertEquals(testRat1.getDenom()*testRat2.getNumer(), divideRat.getDenom());
	}

	@Test
	public void testAdd() {
		Rational testRat1 = new Rational(5, 6);
		Rational testRat2 = new Rational(7, 8);
		Rational addRat = testRat1.add(testRat2);
		assertEquals( (testRat1.getNumer()*testRat2.getDenom()) + (testRat2.getNumer() * testRat1.getDenom()), addRat.getNumer());
		assertEquals( (testRat1.getDenom()) * (testRat2.getDenom()), addRat.getDenom() );
	}

	@Test
	public void testReduce() {
		Rational test = new Rational(6, 10);
		Rational reduceRat = test.reduce();
		test.equals(reduceRat);
	}

}
