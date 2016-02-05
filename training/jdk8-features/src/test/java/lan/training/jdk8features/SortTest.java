package lan.training.jdk8features;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by nik-lazer on 2/4/2016.
 */
public class SortTest {
    private List<UUID> valuesForSequential;
    private List<UUID> valuesForParallel;
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
        valuesForParallel = new ArrayList<>(values);
        valuesForSequential = new ArrayList<>(values);
        Random random = new Random();
        for (int i=0; i<1000000; i++) {
            arr[i] = random.nextInt();
            wrapperArr[i] = arr[i];
            list.add(arr[i]);
        }
    }

    @Test
    public void sortTest() {
        long sequentialDuration = sortMeter.sequentialSort(valuesForSequential);
        long parallelDuration = sortMeter.parallelSort(valuesForParallel);
        assertTrue(parallelDuration <= sequentialDuration);
        assertArrayEquals(valuesForParallel.toArray(), valuesForSequential.toArray());
    }

    @Test
    public void speedTest() {
        sortMeter.primitiveArraySort(arr);
        sortMeter.wrapperArraySort(wrapperArr);
        sortMeter.listSort(list);
    }

}
