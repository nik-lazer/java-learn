package lan.learn.collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@see Arrays.asList} method
 * @author nik-lazer  07.10.2015   12:50
 */
public class AsListTest {
	@Test
	public void asListChangeTest() {
		String[] arr = {"one", "two", "three"};
		List<String> list = Arrays.asList(arr);
		list.set(1, "four");
		assertEquals("four", arr[1]);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void asListAddItemTest() {
		String[] arr = {"one", "two", "three"};
		List<String> list = Arrays.asList(arr);
		list.add(1, "four");
	}

}
