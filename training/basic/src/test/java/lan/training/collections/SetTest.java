package lan.training.collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

import static org.junit.Assert.assertEquals;

/**
 * Elements order in different collections
 * @author nik-lazer  08.10.2015   16:22
 */
public class SetTest {
	@Test
	public void testData() {
		List list = Arrays.asList(10, 5, 10, 20);
		assertEquals("[10, 5, 10, 20]" ,list.toString());
		assertEquals("[20, 5, 10]", new HashSet(list).toString()); // It's very strange
		assertEquals("[5, 10, 20]", new TreeSet(list).toString());
		assertEquals("[5, 10, 20]", new ConcurrentSkipListSet(list).toString());
	}
}
