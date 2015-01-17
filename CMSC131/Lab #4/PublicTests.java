import static org.junit.Assert.*;

import org.junit.Test;


public class PublicTests {

	@Test
	public void testConstructorAndGetters() {
		Rational r = new Rational(3, 4);
		assertEquals(3, r.getNumer());
		assertEquals(4, r.getDenom());
	}
	
	@Test
	public void testToString() {
		Rational r = new Rational(7,11);
		assertTrue(r.toString().equals("7/11"));
	}
	
	@Test
	public void testReciprocal() {
		Rational r = new Rational(7,11);
		Rational x = r.reciprocal();
		assertEquals(11, x.getNumer());
		assertEquals(7, x.getDenom());
	}

}
