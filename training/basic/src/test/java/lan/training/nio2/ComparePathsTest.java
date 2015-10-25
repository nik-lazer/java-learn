package lan.training.nio2;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by nik-lazer on 26.10.15.
 */
public class ComparePathsTest {
	@Test
	public void compareTest() {
		Path current = Paths.get(".");
		Path path1 = Paths.get("Test");
		Path path2 = Paths.get(current.toAbsolutePath() +"/Test").normalize();
		// comparing two paths using compareTo() method
		assertFalse("(path1.compareTo(path2) == 0) is: ", (path1.compareTo(path2) == 0));

		//comparing two paths using equals() method
		assertFalse("path1.equals(path2) is: ", path1.equals(path2));

		// comparing two paths using equals() method with absolute path
		assertTrue("path2.equals(path1.toAbsolutePath()) is ", path2.equals(path1.toAbsolutePath()));
	}
}
