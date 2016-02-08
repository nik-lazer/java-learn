package lan.training.jdk8features.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by nik-lazer on 2/8/2016.
 */
public class ProblemTest {
    @Test
    public void toListTest() {
        List<Integer> list = new ArrayList<>();
        try {
            IntStream.range(0, 1000000).parallel().forEach(list::add);
            System.out.println(list.size());
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
