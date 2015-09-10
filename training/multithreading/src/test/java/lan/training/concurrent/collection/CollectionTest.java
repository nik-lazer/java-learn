package lan.training.concurrent.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Test removing data from lists during iteration
 * @author nik-lazer  09.09.2015   16:41
 */
public class CollectionTest {
	private List<String> simpleList;
	private List<String> copyOnWriteList;

	@Before
	public void init() {
		simpleList = new ArrayList<String>(10);
		simpleList.add("123");
		simpleList.add("456");
		simpleList.add("789");
		simpleList.add("012");
		simpleList.add("345");
		simpleList.add("678");

		copyOnWriteList = new CopyOnWriteArrayList<>();
		copyOnWriteList.add("123");
		copyOnWriteList.add("456");
		copyOnWriteList.add("789");
		copyOnWriteList.add("012");
		copyOnWriteList.add("345");
		copyOnWriteList.add("678");
	}

	@Test(expected = ConcurrentModificationException.class)
	public void listSimpleTest() {
		int i = 0;
		for (Iterator it = simpleList.iterator(); it.hasNext();) {
			String myObject = (String)it.next();
			if (i % 2 != 0) {
				simpleList.remove(myObject); //can throw ConcurrentModificationException in single as well as multi-thread access situations.
			}
			i++;
		}
	}

	@Test
	public void listIteratorTest() {
		int i = 0;
		for (Iterator it = simpleList.iterator(); it.hasNext();) {
			String myObject = (String)it.next();
			if (i % 2 != 0) {
				it.remove();
			}
			i++;
		}
		assertEquals(3, simpleList.size());
		assertEquals("123", simpleList.get(0));
		assertEquals("789", simpleList.get(1));
		assertEquals("345", simpleList.get(2));
	}

	@Test
	public void listCopyOnWriteTest() {
		int i = 0;
		for (Iterator it = copyOnWriteList.iterator(); it.hasNext();) {
			String myObject = (String)it.next();
			if (i % 2 != 0) {
				copyOnWriteList.remove(myObject);
			}
			i++;
		}
		assertEquals(3, copyOnWriteList.size());
		assertEquals("123", copyOnWriteList.get(0));
		assertEquals("789", copyOnWriteList.get(1));
		assertEquals("345", copyOnWriteList.get(2));
	}

	@Test
	public void listCopyOnWriteForeachTest() {
		int i = 0;
		for (String myObject: copyOnWriteList) {
			if (i % 2 != 0) {
				copyOnWriteList.remove(myObject);
			}
			i++;
		}
		assertEquals(3, copyOnWriteList.size());
		assertEquals("123", copyOnWriteList.get(0));
		assertEquals("789", copyOnWriteList.get(1));
		assertEquals("345", copyOnWriteList.get(2));
	}

}
