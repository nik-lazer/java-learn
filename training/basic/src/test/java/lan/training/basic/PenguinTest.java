package lan.training.basic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Overriede method might not declare thowing exceptions
 * @author nik-lazer  08.10.2015   15:56
 */
public class PenguinTest {
	class CannotFlyException extends Exception {}

	interface Birdie {
		public abstract String fly() throws CannotFlyException;
	}

	interface Biped {
		public String walk();
	}

	abstract class NonFlyer {
		public String fly() {
			return "cannot fly";
		}
	}

	class Penguin extends NonFlyer implements Birdie, Biped {
		public String walk() { return "walk"; }
	}

	@Test
	public void testFly() {
		Penguin pingu = new Penguin();
		assertEquals("walk", pingu.walk());
		assertEquals("cannot fly", pingu.fly());
	}
}
