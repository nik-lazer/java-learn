package lan.training.basic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * instance of doen't throw NPE
 * @author nik-lazer  08.10.2015   12:22
 */
public class NullInstanceOf {
	@Test
	public void instanceOfNull() {
		String str = null;
		assertFalse(str instanceof Object);
		assertFalse(str instanceof String);
	}
}
