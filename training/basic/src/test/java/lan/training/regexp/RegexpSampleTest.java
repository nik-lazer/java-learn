package lan.training.regexp;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link lan.training.regexp.RegexpSample}
 * @author nik-lazer  06.10.2015   14:34
 */
public class RegexpSampleTest {
	private Set<String> set;

	@Before
	public void init() {
		String data = "qwert, test,WSRP, ToDo";
		set = RegexpSample.getDataSetWithIgnoreCase(data);
	}
	@Test
	public void getDataSetWithIgnoreCaseTest() {
		assertNotNull(set);
		assertNotNull(set.contains("qwert"));
		assertFalse(set.contains(" test"));
		assertEquals(4, set.size());
	}

	@Test
	public void containsIgnoreCaseTest() {
		assertTrue(RegexpSample.containsIgnoreCase(set, "test"));
		assertTrue(RegexpSample.containsIgnoreCase(set, "TEST"));
		assertTrue(RegexpSample.containsIgnoreCase(set, "WSRP"));
		assertTrue(RegexpSample.containsIgnoreCase(set, "WsRp"));
		assertTrue(RegexpSample.containsIgnoreCase(set, "tODo"));
		assertTrue(RegexpSample.containsIgnoreCase(set, "TODO"));
	}
}
