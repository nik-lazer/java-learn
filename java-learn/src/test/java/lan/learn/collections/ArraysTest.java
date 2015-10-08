package lan.learn.collections;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Deep equals for arrays - only {@see Arrays.equals}
 * @author nik-lazer  08.10.2015   14:17
 */
public class ArraysTest {
	@Test
	public void equalsTest() {
		int []arr1 = {1, 2, 3, 4, 5};
		int []arr2 = {1, 2, 3, 4, 5};
		assertFalse("arr1 == arr2 must be false ", (arr1 == arr2));
		assertFalse("arr1.equals(arr2) maus be false ", arr1.equals(arr2));
		assertTrue("Arrays.equals(arr1, arr2) must be true ", java.util.Arrays.equals(arr1, arr2));
	}
}
