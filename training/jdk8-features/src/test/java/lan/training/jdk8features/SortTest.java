package lan.training.jdk8features;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by nik-lazer on 2/4/2016.
 */
public class SortTest {
    private List<UUID> valuesList;
    private SortMeter sortMeter = new SortMeter();
    int[] arr = new int[1000000];
    Integer[] wrapperArr = new Integer[1000000];
    List list = new ArrayList<>();

    @Before
    public void init() {
        int max = 1000000;
        List<UUID> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid);
        }
        valuesList = new ArrayList<>(values);
        Random random = new Random();
        for (int i=0; i<1000000; i++) {
            arr[i] = random.nextInt();
            wrapperArr[i] = arr[i];
            list.add(arr[i]);
        }
    }

    @Test
    public void sortTest() {
        long sequentialDuration = sortMeter.sortStream(valuesList.stream());
        long parallelDuration = sortMeter.sortStream(valuesList.parallelStream());
        assertTrue(parallelDuration <= sequentialDuration);
    }

    @Test
    public void speedTest() {
        sortMeter.primitiveArraySort(arr);
        sortMeter.wrapperArraySort(wrapperArr);
        sortMeter.listSort(list);
    }

}
