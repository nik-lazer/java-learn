package lan.training.collections;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Lower wildcard sample
 * @author nik-lazer  07.10.2015   12:28
 */
public class WildCardSamples {
	@Test
	public void lowerWildCardTest() {
		ArrayList<? super IOException> exceptions = new ArrayList<Exception>();
		exceptions.add(new IOException("Problem 1"));
		exceptions.add(new IOException("Problem 2"));
		exceptions.add(new FileNotFoundException("Problem 3"));
		assertEquals(3, exceptions.size());
	}
}
