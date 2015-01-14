package lan.training.advanced.resource;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Test for {@link lan.training.advanced.resource.ResourceFactory}
 * @author nik-lazer  14.01.2015   13:11
 */
public class ResourceFactoryTest {
	@Test
	public void resourceLoadTest() {
		AccountResource accountResource = ResourceFactory.getAccountResource();
		assertNotNull("account resource must be loaded", accountResource);
		assertEquals("Fireld runDelay in accountResource must be right", 5000, accountResource.getRunDelay());
		assertEquals("Fireld authDelay in accountResource must be right", 5000, accountResource.getAuthDelay());
	}
}
