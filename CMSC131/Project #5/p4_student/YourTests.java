package p4_student;

import static org.junit.Assert.*;

import org.junit.Test;



public class YourTests {
	//Some example JUnit tests to get you started thinking about 
	//  writing JUnit tests...
	//There are signatures for JUnit tests you are required to write
	//  below the first few that we've provided.
	
	@Test
	public void testDefaultConstructor() {
		QuadraticEquation testQuad = new QuadraticEquation();
		assertTrue(testQuad.getA().isZero()
				&& testQuad.getB().isZero()
				&& testQuad.getC().isZero());
	}
	
	@Test
	public void testSingleValConstructor() {
		MyDouble cVal = new MyDouble(27.8);
				
		QuadraticEquation testQuad = new QuadraticEquation(cVal);
		assertTrue(testQuad.getA().isZero()
				&& testQuad.getB().isZero()
				&& testQuad.getC().equals(cVal));
	}

	@Test
	public void testThreeValConstructor() {
		MyDouble aVal = new MyDouble(15.7);
		MyDouble bVal = new MyDouble(-23.7);
		MyDouble cVal = new MyDouble(4.3);
				
		QuadraticEquation testQuad = new QuadraticEquation(aVal, bVal, cVal);
		assertTrue(testQuad.getA().equals(aVal)
				&& testQuad.getB().equals(bVal)
				&& testQuad.getC().equals(cVal));
	}

	@Test
	public void testEvaluate() {
		MyDouble aVal = new MyDouble(2);
		MyDouble bVal = new MyDouble(4);
		MyDouble cVal = new MyDouble(8);
		
		QuadraticEquation testQuad = new QuadraticEquation(aVal, bVal, cVal);
		assertTrue(testQuad.evaluate(MyDouble.zero).equals(new MyDouble(8)));
		assertTrue(testQuad.evaluate(new MyDouble(1)).equals(new MyDouble(14)));
		assertTrue(testQuad.evaluate(new MyDouble(2)).equals(new MyDouble(24)));
		assertTrue(testQuad.evaluate(new MyDouble(3)).equals(new MyDouble(38)));
	}

	
	
	
	//YOU NEED TO IMPLEMENT AT LEAST THESE JUNIT TESTS BELOW
	@Test
	public void testGetters() {
		MyDouble firstTerm = new MyDouble(3.0);
		MyDouble secondTerm = new MyDouble(-4.5);
		MyDouble thirdTerm = new MyDouble(6.2);
		QuadraticEquation testQuad = new QuadraticEquation(firstTerm, secondTerm, thirdTerm);
		assertEquals(testQuad.getA(), firstTerm);
		assertEquals(testQuad.getB(), secondTerm);
		assertEquals(testQuad.getC(), thirdTerm);
		
	}

	@Test
	public void testAdd() {
		MyDouble firstTerm = new MyDouble(3.0);
		MyDouble secondTerm = new MyDouble(-4.5);
		MyDouble thirdTerm = new MyDouble(6.2);
		
		QuadraticEquation testQuad = new QuadraticEquation(firstTerm, secondTerm, thirdTerm);
		QuadraticEquation testQuad2 = new QuadraticEquation(firstTerm, secondTerm, thirdTerm);
		QuadraticEquation sumQuads = testQuad.add(testQuad2);
		
		assertEquals(sumQuads.getA(), new MyDouble(3.0 + 3.0));
		assertEquals(sumQuads.getB(), new MyDouble(-4.5 + -4.5));
		assertEquals(sumQuads.getC(), new MyDouble(6.2 + 6.2));
	}

	@Test
	public void testSubtract() {
		MyDouble firstTerm = new MyDouble(3.0);
		MyDouble secondTerm = new MyDouble(-4.5);
		MyDouble thirdTerm = new MyDouble(6.2);
		
		MyDouble firstTerm2 = new MyDouble(1.9);
		MyDouble secondTerm2 = new MyDouble(3.0);
		MyDouble thirdTerm2 = new MyDouble(7.5);
		
		QuadraticEquation testQuad = new QuadraticEquation(firstTerm, secondTerm, thirdTerm);
		QuadraticEquation testQuad2 = new QuadraticEquation(firstTerm2, secondTerm2, thirdTerm2);
		QuadraticEquation diffQuads = testQuad.subtract(testQuad2);
		
		assertEquals(diffQuads.getA(), new MyDouble(3.0 - 1.9));
		assertEquals(diffQuads.getB(), new MyDouble(-4.5 - 3.0));
		assertEquals(diffQuads.getC(), new MyDouble(6.2 - 7.5));
	}

	@Test
	public void testMultiply() {
		MyDouble firstTerm = new MyDouble(3.0);
		MyDouble secondTerm = new MyDouble(-4.5);
		MyDouble thirdTerm = new MyDouble(5.4);
		
		QuadraticEquation testQuad = new QuadraticEquation(firstTerm, secondTerm);
		QuadraticEquation testQuad2 = new QuadraticEquation(firstTerm, secondTerm);
		QuadraticEquation multQuads = testQuad.limitedMultiply(testQuad2);
		QuadraticEquation testQuad3 = new QuadraticEquation(firstTerm, secondTerm, thirdTerm);
		
		// (ax^2 + bx + c) * c
		QuadraticEquation testQuad4 = new QuadraticEquation(firstTerm);
		QuadraticEquation multQuads2 = testQuad3.limitedMultiply(testQuad4);
		assertEquals(multQuads2.getA(), new MyDouble(3.0*3.0));
		assertEquals(multQuads2.getB(), new MyDouble(3.0*-4.5));
		assertEquals(multQuads2.getC(), new MyDouble(3.0*5.4));
		
		// (bx + c) * (bx+c)
		assertEquals(multQuads.getA(), new MyDouble(3.0 * 3.0));
		assertEquals(multQuads.getB(), new MyDouble(2.0* 3.0 * -4.5));
		assertEquals(multQuads.getC(), new MyDouble(-4.5 * -4.5));
		// (ax^2 + bx + c) * (ax^2 + bx + c)
		assertNull(testQuad3.limitedMultiply(testQuad3));
		
		// (bx + c) * (ax^2 + bx + c)
		assertNull(testQuad2.limitedMultiply(testQuad3));
		
		// (ax^2 + bx + c) * 0
		QuadraticEquation testQuad5 = new QuadraticEquation();
		QuadraticEquation multQuads3 = testQuad5.limitedMultiply(testQuad3);
		assertEquals(multQuads3.getA(), MyDouble.zero);
		assertEquals(multQuads3.getB(), MyDouble.zero);
		assertEquals(multQuads3.getB(), MyDouble.zero);
		
		QuadraticEquation multQuads4 = testQuad4.limitedMultiply(testQuad4);
		assertEquals(multQuads4.getA(), MyDouble.zero);
		assertEquals(multQuads4.getB(), MyDouble.zero);
		assertEquals(multQuads4.getC(), new MyDouble(9));
	}

	@Test
	public void testDerivative() {
		MyDouble firstTerm = new MyDouble(3.0);
		MyDouble secondTerm = new MyDouble(-4.5);
		MyDouble thirdTerm = new MyDouble(6.2);
		
		QuadraticEquation testQuad = new QuadraticEquation(firstTerm, secondTerm, thirdTerm);
		QuadraticEquation derivQuad = testQuad.derivative();
		
		assertEquals(derivQuad.getA(), new MyDouble(0.0));
		assertEquals(derivQuad.getB(), new MyDouble(3.0*2));
		assertEquals(derivQuad.getC(), new MyDouble(-4.5));
	}

	@Test
	public void testNormalize() {
		MyDouble firstTerm = new MyDouble(3.0);
		MyDouble secondTerm = new MyDouble(-4.5);
		MyDouble thirdTerm = new MyDouble(6.2);
		
		QuadraticEquation testQuad = new QuadraticEquation(firstTerm, secondTerm, thirdTerm);
		MyDouble testDouble = new MyDouble(testQuad.normalize());
		MyDouble testDouble2 = new MyDouble((3.0*3.0) + (-4.5*-4.5) + (6.2*6.2));
		
		assertEquals(testDouble, testDouble2.sqrt());
	}

	@Test
	public void testEqualsAndCompareTo() {
		QuadraticEquation testQuad = new QuadraticEquation(new MyDouble(3.2), new MyDouble(5.4), new MyDouble(6.5));
		QuadraticEquation testQuad2 = new QuadraticEquation(new MyDouble(3.5), new MyDouble(5.6), new MyDouble(6.8));
		QuadraticEquation testQuad3 = new QuadraticEquation(new MyDouble(3.2), new MyDouble(5.4), new MyDouble(6.5));
		
		assertEquals( testQuad.compareTo(testQuad2), -1 );
		assertEquals( testQuad.compareTo(testQuad3), 0 );
		assertEquals( testQuad2.compareTo(testQuad), 1);
		assertTrue(testQuad.equals(testQuad3));
		assertFalse(testQuad.equals(testQuad2));
		
	}

	@Test
	public void testToString() {
		
		// Varieties of ax^2 + bx + c
		QuadraticEquation testQuad = new QuadraticEquation(new MyDouble(3.0), new MyDouble(-5.4), new MyDouble(1.0));
		QuadraticEquation testQuad6 = new QuadraticEquation(new MyDouble(3.2), new MyDouble(1.2), new MyDouble(6.5));
		QuadraticEquation testQuad12 = new QuadraticEquation(new MyDouble(1.0), new MyDouble(-1), new MyDouble(1.0));
		QuadraticEquation testQuad10 = new QuadraticEquation(new MyDouble(-5.4), new MyDouble(3.2), new MyDouble(-1.2));
		QuadraticEquation testQuad8 = new QuadraticEquation(new MyDouble(-5.4), new MyDouble(-3.2), new MyDouble(-1.2));
		QuadraticEquation testQuad15 = new QuadraticEquation(testQuad);
		
		assertEquals(testQuad6.toString(), "3.2x^2+1.2x+6.5");	// all positive
		assertEquals(testQuad.toString(), "3x^2-5.4x+1");
		assertEquals(testQuad12.toString(), "1x^2-1x+1");	
		assertEquals(testQuad10.toString(), "-5.4x^2+3.2x-1.2"); 
		assertEquals(testQuad8.toString(), "-5.4x^2-3.2x-1.2"); 	// all negative
		assertEquals(testQuad15.toString(), "3x^2-5.4x+1");
		
		
		
		// Varieties of ax^2 + c
		QuadraticEquation testQuad3 = new QuadraticEquation(new MyDouble(3.2), new MyDouble(0), new MyDouble(6.5));
		QuadraticEquation testQuad23 = new QuadraticEquation(new MyDouble(-5.4), new MyDouble(0), new MyDouble(-3.0));
		assertEquals(testQuad3.toString(), "3.2x^2+6.5");
		assertEquals(testQuad23.toString(), "-5.4x^2-3");
		
		// Varieties of bx
		QuadraticEquation testQuad2 = new QuadraticEquation(new MyDouble(0), new MyDouble(-5.4), new MyDouble(0));
		QuadraticEquation testQuad20 = new QuadraticEquation(new MyDouble(0), new MyDouble(5.4), new MyDouble(0));
		assertEquals(testQuad2.toString(), "-5.4x");
		assertEquals( (testQuad20.toString()), "5.4x" );		
		
		// Varieties of ax^2
		QuadraticEquation testQuad9 = new QuadraticEquation(new MyDouble(5.4), new MyDouble(0), new MyDouble(0));
		QuadraticEquation testQuad22 = new QuadraticEquation(new MyDouble(-5.4), new MyDouble(0), new MyDouble(0));
		assertEquals(testQuad9.toString(), "5.4x^2");
		assertEquals(testQuad22.toString(), "-5.4x^2");
		
		// Varieties of ax^2 + bx
		QuadraticEquation testQuad11 = new QuadraticEquation(new MyDouble(5.4), new MyDouble(3.2), new MyDouble(0));
		QuadraticEquation testQuad21 = new QuadraticEquation(new MyDouble(-5.4), new MyDouble(-3.2), new MyDouble(0) );
		assertEquals(testQuad11.toString(), "5.4x^2+3.2x");
		assertEquals(testQuad21.toString(), "-5.4x^2-3.2x");
		
		// Varities of bx + c
		QuadraticEquation testQuad13 = new QuadraticEquation(new MyDouble(5.4), new MyDouble(1.5));
		QuadraticEquation testQuad24 = new QuadraticEquation(new MyDouble(0), new MyDouble(-5.4), new MyDouble(-3.2));
		QuadraticEquation testQuad25 = new QuadraticEquation(new MyDouble(-5.4), new MyDouble(-1.5));
		assertEquals(testQuad13.toString(), "5.4x+1.5");
		assertEquals(testQuad24.toString(), "-5.4x-3.2");
		assertEquals(testQuad25.toString(), "-5.4x-1.5");
		
		
		// Varities of c
		QuadraticEquation testQuad7 = new QuadraticEquation(new MyDouble(0), new MyDouble(0), new MyDouble(6));
		QuadraticEquation testQuad14 = new QuadraticEquation(new MyDouble(-5.4));
		QuadraticEquation testQuad19 = new QuadraticEquation(new MyDouble(5.4));
		QuadraticEquation testQuad4 = new QuadraticEquation(new MyDouble(0), new MyDouble(0), new MyDouble(0));
		QuadraticEquation testQuad17 = new QuadraticEquation(new MyDouble(0), new MyDouble(0));
		QuadraticEquation testQuad18 = new QuadraticEquation(new MyDouble(0));
		QuadraticEquation testQuad16 = new QuadraticEquation();
		
		assertEquals(testQuad19.toString(), "5.4");
		assertEquals(testQuad14.toString(), "-5.4");
		assertEquals(testQuad7.toString(), "6");
		assertEquals(testQuad16.toString(), "0");
		assertEquals(testQuad17.toString(), "0");
		assertEquals(testQuad18.toString(), "0");
		assertEquals(testQuad4.toString(), "0");
		

		
	}
	@Test
	public void testParseQuadratic(){
		// -ax^2 + bx + c
		QuadraticEquation testQuad = QuadraticEquation.parseQuadratic("5x^2+5.2x+5.0");
		assertEquals(testQuad.getA(), new MyDouble(5));
		assertEquals(testQuad.getB(), new MyDouble(5.2));
		assertEquals(testQuad.getC(), new MyDouble(5));
		
		// -ax^2-bx-c
		QuadraticEquation testQuad6 = QuadraticEquation.parseQuadratic("-5x^2-1.0x-5.0");
		assertEquals(testQuad6.getA(), new MyDouble(-5));
		assertEquals(testQuad6.getB(), new MyDouble(-1));
		assertEquals(testQuad6.getC(), new MyDouble(-5.0));
		
		// bx + c with spaces
		QuadraticEquation testQuad2 = QuadraticEquation.parseQuadratic("  -5.2x  -5.0 ");
		assertEquals(testQuad2.getB(), new MyDouble(-5.2));
		assertEquals(testQuad2.getC(), new MyDouble(-5));
		assertEquals(testQuad2.getA(), new MyDouble(0));
		
		// ax^2 + c
		QuadraticEquation testQuad3 = QuadraticEquation.parseQuadratic("-4.5x^2+5");
		assertEquals(testQuad3.getA(), new MyDouble(-4.5));
		assertEquals(testQuad3.getB(), new MyDouble(0));
		assertEquals(testQuad3.getC(), new MyDouble(5));
		
		// ax^2 + b
		QuadraticEquation testQuad4 = QuadraticEquation.parseQuadratic("-4.8x^2-5.9x");
		assertEquals(testQuad4.getA(), new MyDouble(-4.8));
		assertEquals(testQuad4.getB(), new MyDouble(-5.9));
		assertEquals(testQuad4.getC(), new MyDouble(0));
		
		// ax^2
		QuadraticEquation testQuad5 = QuadraticEquation.parseQuadratic("5x^2");
		assertEquals(testQuad5.getA(), new MyDouble(5));
		assertEquals(testQuad5.getB(), new MyDouble(0));
		assertEquals(testQuad5.getC(), new MyDouble(0));
		
		// bx
		QuadraticEquation testQuad8 = QuadraticEquation.parseQuadratic("-5x");
		assertEquals(testQuad8.getA(), new MyDouble(0));
		assertEquals(testQuad8.getB(), new MyDouble(-5));
		assertEquals(testQuad8.getC(), new MyDouble(0));
		
		// c
		QuadraticEquation testQuad7 = QuadraticEquation.parseQuadratic("-5");
		assertEquals(testQuad7.getA(), new MyDouble(0));
		assertEquals(testQuad7.getB(), new MyDouble(0));
		assertEquals(testQuad7.getC(), new MyDouble(-5));
		
		
		
		
	}
	
}