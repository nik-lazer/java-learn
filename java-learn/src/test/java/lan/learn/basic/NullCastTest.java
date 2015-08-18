package lan.learn.basic;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNull;

/**
 * Check cast operation on null value
 * @author lazarev_nv  18.08.2015   12:02
 */
public class NullCastTest {
	private Map map;
	@Before
	public void init() {
		map = new HashMap();
	}

	@Test
	public void testNullCast() {
		String data = (String)map.get("key");
		assertNull(data);
	}
}
