package lan.training.basic;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Primitive wrappers may be equal by ==
 * @author nik-lazer  08.10.2015   11:57
 */
class Increment {
	@Test
	public void primitivesTest() {
		Integer i = 10;
		Integer j = 11;
		Integer k = ++i; // INCR
		assertTrue("k == j is ", (k == j));
		assertTrue("k.equals(j) is ", k.equals(j));
	}
}
