import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * @author Alexey Pobedyonny 07.05.2014
 */
public class UnitTest {
	static Service service;

	@Test
	public void testAdd() {
		int result = service.eval("1+2");
		assertEquals("Сумма должна быть равна 3", 3, result);
	}

	@Test
	public void testSub() {
		int result = service.eval("1-2");
		assertEquals("Сумма должна быть равна -1", -1, result);
	}

	@Test
	public void testMultiply() {
		int result = service.eval("2*2");
		assertEquals("Сумма должна быть равна 4", 4, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalid() {
		testExp("1+1");
		testExp("1+(-1)");
		testExp("'1'+2");
		testExp("1+1");
		testExp("'1'+'a'");
		testExp("'c'+'2'");
		throw new IllegalArgumentException("");
	}

	private void testExp(String exp) {
		try {
			service.eval(exp);
			fail("Expression must be failed");
		} catch (IllegalArgumentException e) {
			System.out.println("good:"+exp);
		}
	}

	@Test
	public void testGetProperty() {
		String _val = service.getProperty("OS");
		assertNotNull(_val);
		assertEquals("Linux", _val);
	}

	@BeforeClass
	public static void setUp() {
		System.out.println("Setup");
		service = new Service();
		service.setPropertyService(new PropertyService());
	}
}
