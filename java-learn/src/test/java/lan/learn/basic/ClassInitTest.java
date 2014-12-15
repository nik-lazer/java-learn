package lan.learn.basic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Variables order init test
 * @author lazarev_nv  15.12.2014   13:28
 */
public class ClassInitTest {
	private SomeClass s;

	@Before
	public void init() {
		s = new SomeClass();
	}

	@Test
	public void initTest() {
		assertEquals("x must be 3", s.x, 3);
		assertEquals("y must be 0", s.y, 0);
	}
}
