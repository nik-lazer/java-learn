package lan.training.concurrent.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections.synchronizedXXX methods usage
 * @author nik-lazer  09.09.2015   16:10
 */
public class CollectionTest {
	public static void main(String[] args) {
		List<String> simpleList = new ArrayList<>();
		List list = Collections.synchronizedList(simpleList);
		System.out.println(simpleList.getClass().getCanonicalName()); // java.util.ArrayList
		System.out.println(list.getClass().getCanonicalName()); // java.util.Collections.SynchronizedRandomAccessList
	}
}
