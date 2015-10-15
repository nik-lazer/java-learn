package lan.training.basic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Methods overloading testing
 * @author nik-lazer  08.10.2015   15:31
 */
public class CoinTest {
	@Test
	public void overloadTest() {
		Side firstAttempt = new Head();
		Tail secondAttempt = new Tail();
		assertEquals("Side", Coin.overload(firstAttempt));
		assertEquals("Object", Coin.overload((Object) firstAttempt));
		assertEquals("Tail", Coin.overload(secondAttempt));
		assertEquals("Side", Coin.overload((Side) secondAttempt));
	}
}
