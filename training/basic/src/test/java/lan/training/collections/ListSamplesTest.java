package lan.training.collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test conversion from  array to list and vice versa
 * @author nik-lazer  07.10.2015   11:50
 */
@RunWith(Parameterized.class)
public class ListSamplesTest {
	private int arrSize;
	private int expectedInitArrSize;
	private int expectedResultArraySize;
	private boolean expectedArrayComparing;

	public ListSamplesTest(int arrSize, int expectedInitArrSize, int expectedResultArraySize, boolean expectedArrayComparing) {
		this.arrSize = arrSize;
		this.expectedInitArrSize = expectedInitArrSize;
		this.expectedResultArraySize = expectedResultArraySize;
		this.expectedArrayComparing = expectedArrayComparing;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(
				new Object[][] {
						{0, 0, 3, false},
						{3, 3, 3, true}
				}
		);
	}

	@Test
	public void toArraySampleTest() {
		System.out.printf("Test runned with parameters: %d, %d, %d, %b\n",arrSize, expectedInitArrSize, expectedResultArraySize, expectedArrayComparing);
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		String[] arr = new String[arrSize];
		String[] resArr = list.toArray(arr);
		assertEquals(expectedInitArrSize, arr.length);
		assertEquals(expectedResultArraySize, resArr.length);
		assertEquals(expectedArrayComparing, arr == resArr);
	}
}
