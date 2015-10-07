package lan.learn.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Lists comparing - equals method of List does not make a distinction about the actual
 List implementation, so an ArrayList can equal a Vector as long they have the same size
 and all corresponding pairs of elements in the two lists are equal
 * @author nik-lazer  07.10.2015   15:29
 */
public class ListEqualsTest {
	@Test
	public void listsCompare() {
		List<String> list1 = new ArrayList<>();
		list1.add("abc");
		List<String> list2 = new Vector<>();
		list2.add("abc");
		Vector<String> vector = new Vector<>();
		vector.add("abc");
		assertEquals(list1, list2);
		assertEquals(list1, vector);
	}

	@Test
	public void listWithSetCompare() {
		List<String> list = new ArrayList<>();
		list.add("abc");
		Set<String> set = new HashSet<>();
		set.add("abc");
		assertNotEquals(set, list);
	}
}
