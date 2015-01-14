package lan.training.advanced.resource;

import lan.training.advanced.parser.ResourceParser;
import lan.training.advanced.parser.dom.ResourceDomParser;
import lan.training.advanced.parser.sax.ResourceSaxParser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Tests for xml parsers
 * @author nik-lazer  14.01.2015   14:00
 */
public class ParsersTest {
	private static String RESOURCE_ADDRESS = "data/account.xml";
	private String file;

	@Before
	public void inti() {
		file = getClass().getResource(RESOURCE_ADDRESS).getFile();
	}

	@Test
	public void saxParserTest() {
		ResourceParser parser = new ResourceSaxParser();
		Resource resource = parser.parse(file);
		assertNotNull("SAX Resource must be not null", resource);
		assertTrue("SAX Resource must be AccountResource", resource instanceof AccountResource);
		AccountResource accountResource = (AccountResource)resource;
		assertEquals("SAX Field runDelay in accountResource must be right", 5000, accountResource.getRunDelay());
		assertEquals("SAX Field authDelay in accountResource must be right", 5000, accountResource.getAuthDelay());

	}

	@Test
	public void domParserTest() {
		ResourceParser parser = new ResourceDomParser();
		Resource resource = parser.parse(file);
		assertNotNull("DOM Resource must be not null", resource);
		assertTrue("DOM Resource must be AccountResource", resource instanceof AccountResource);
		AccountResource accountResource = (AccountResource)resource;
		assertEquals("DOM Field runDelay in accountResource must be right", 5000, accountResource.getRunDelay());
		assertEquals("DOM Field authDelay in accountResource must be right", 5000, accountResource.getAuthDelay());

	}
}
