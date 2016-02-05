package lan.training.advanced.vfs;

import lan.training.advanced.base.VFS;
import lan.training.advanced.vfs.VFSImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Iterator;

/**
 * Test for {@link lan.training.advanced.base.VFS}
 * @author nik-lazer  12.01.2015   16:46
 */
public class VFSTest {
	private static final String SIMPLE_FILE = "simple.txt";
	private static final String MAIN_DIR = "maindir";
	private static final String BASE_DIR = ".";
	private VFS vfs;

	@Before
	public void init() {
		vfs = new VFSImpl(getClass().getResource(BASE_DIR).getFile());
	}

	@Test
	public void testExists() {
		Assert.assertEquals(SIMPLE_FILE + " must exist", true, vfs.isExist(SIMPLE_FILE));
		Assert.assertEquals("wrongSimple.txt must not exist", false, vfs.isExist("wrongSimple.txt"));
	}

	@Test
	public void testIsDir() {
		Assert.assertEquals(MAIN_DIR + " is directory", true, vfs.isDirectory(MAIN_DIR));
		Assert.assertEquals(SIMPLE_FILE + " simple.txt must be file", false, vfs.isDirectory(SIMPLE_FILE));
	}

	@Test
	@Ignore // TODO Fix for Windows
	public void testAbsolutePath() {
		String expected = getClass().getResource("./"+SIMPLE_FILE).getFile();
		Assert.assertEquals("must be equal", expected, vfs.getAbsolutePath(SIMPLE_FILE));
	}

	@Test
	public void testUTFReading() {
		String s = vfs.getUFT8Text(SIMPLE_FILE);
		Assert.assertEquals("must be content of " + SIMPLE_FILE, "first second third", s);
	}

	@Test
	@Ignore // TODO Fix for Windows
	public void testIterator() {
		Iterator<String> iterator = vfs.getIterator(MAIN_DIR);
		Assert.assertTrue("must be not empty", iterator.hasNext());
		Assert.assertEquals("First file must be " + MAIN_DIR, getClass().getResource(MAIN_DIR).getFile(), iterator.next());
		int i = 0;
		while (iterator.hasNext()) {
			iterator.next();
			i++;
		}
		Assert.assertEquals("Three subfiles expected", 3, i);
	}
}
