package lan.training.jdk8features;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by nik-lazer on 2/4/2016.
 * TODO use benchmark instead nanoTime
 */
public class SortMeter {
    public long sequentialSort(List<UUID> values) {
        long t0 = System.nanoTime();

        long count = values.stream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
        return millis;
    }

    public long parallelSort(List<UUID> values) {
        long t0 = System.nanoTime();

        long count = values.parallelStream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("parallel sort took: %d ms", millis));

        return millis;
    }

    public long primitiveArraySort(int[] values) {
        long t0 = System.nanoTime();

        Arrays.sort(values);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("primitive array took: %d ms", millis));
        return millis;
    }

    public long wrapperArraySort(Integer[] values) {
        long t0 = System.nanoTime();

        Arrays.sort(values);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("wrappers array sort took: %d ms", millis));
        return millis;
    }

    public long listSort(List<Integer> values) {
        long t0 = System.nanoTime();

        Collections.sort(values);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("list sort took: %d ms", millis));
        return millis;
    }


}
