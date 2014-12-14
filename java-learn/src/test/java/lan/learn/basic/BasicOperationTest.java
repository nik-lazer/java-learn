package lan.learn.basic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Arithmetic operations tests
 * Created by nik-lazer on 14.12.14.
 */
public class BasicOperationTest {
	@Test(expected = ArithmeticException.class)
	public void intDivisionByZeroTest() {
		int i = 1/0;
	}

	@Test
	public void testDivisionTest() {
		assertEquals("Must be Infinity", Float.POSITIVE_INFINITY, 1./0, 0);
		assertEquals("Must be Infinity too", Float.POSITIVE_INFINITY, 1/0., 0);
		assertEquals("Must be Infinity such as first and second", Float.POSITIVE_INFINITY, 1./0., 0);
		assertEquals("Must be 23", 23, '\n' + '\r');
	}

	@Test
	public void varsInitTest() {
		int a = 5, b = 6;
		a = b++;
		assertEquals("Must be equal", ++a , b++);
	}
}
