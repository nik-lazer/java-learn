package lan.learn.basic;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link lan.learn.basic.Derived} class
 * @author nik-lazer  31.08.2015   17:02
 */
public class DerivedTest {
	@Test
	public void testStaticField() {
		Derived derived = new Derived();
		assertEquals(0, derived.getState());
	}
}
