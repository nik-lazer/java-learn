package lan.training.advanced.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
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

}
