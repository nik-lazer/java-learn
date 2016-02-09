package lan.training.jdk8features.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by nik-lazer on 2/9/2016.
 */
public class ExceptionsTest {
    private List<Integer> digits = Arrays.asList(5, 6, -1, 5, 6, 8);

    @Test
    public void exceptionTest() {
        long incorrectCount = digits.stream().map(integer -> {
            try {
                return Optional.of(ExceptionSample.getLog10(integer));
            } catch (CheckedException e) {
                return Optional.empty();
            }
        }).filter(o -> !o.isPresent()).count();
        assertEquals(1, incorrectCount);
    }
}
