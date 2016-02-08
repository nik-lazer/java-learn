package lan.training.advanced.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Some tests for {@link lan.training.advanced.util.ReflectionHelper}
 * @author nik-lazer  13.01.2015   11:39
 */
public class ReflectionHelperTest {
	@Test
	public void createInstanceTest() {
		Object obj = ReflectionHelper.createInstance("lan.training.advanced.util.Domain");
		assertTrue("obj must be domain", obj instanceof Domain);
	}

	@Test
	public void settingFieldTest() {
		Domain domain = new Domain(1, "first", 2);
		ReflectionHelper.setFieldValue(domain, "id", "2");
		ReflectionHelper.setFieldValue(domain, "name", "second");
		ReflectionHelper.setFieldValue(domain, "nextId", "3");
		assertEquals("ID must be 2", 2, domain.getId());
		assertEquals("Name must be 'second'", "second", domain.getName());
		assertEquals("nextID must be 3", 3, domain.getNextId().intValue());
	}

	@Test
	public void gettingFieldTest() {
		Domain domain = new Domain(1, "first", 2);
		Object o1 = ReflectionHelper.getFieldValue(domain, "id");
		Object o2 = ReflectionHelper.getFieldValue(domain, "name");
		Object o3 = ReflectionHelper.getFieldValue(domain, "nextId");
		assertEquals("ID must be 2", 1, o1);
		assertEquals("Name must be 'second'", "first", o2);
		assertEquals("nextID must be 3", 2, o3);
	}

	@Test
	public void invokeMethodTest() {
		Domain domain = new Domain(1, "one", 2);
		Object result = ReflectionHelper.methodInvoke("getNextId", domain);
		assertNotNull("Invoke result must be not null", result);
		assertTrue("Result must be int", result instanceof Integer);
		assertEquals("Name must be equal '2'", domain.getNextId(), (Integer)result);
	}
}
