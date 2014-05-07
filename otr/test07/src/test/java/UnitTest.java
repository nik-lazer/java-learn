import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
		service.eval("1+(-1)");
		service.eval("'1'+2");
		System.out.println(1);
		service.eval("'1'+'a'");
		System.out.println(2);
		service.eval("'c'+'2'");
		System.out.println(3);
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
