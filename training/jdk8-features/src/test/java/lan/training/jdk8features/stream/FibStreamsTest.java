package lan.training.jdk8features.stream;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by nik-lazer on 2/8/2016.
 */
public class FibStreamsTest {
    @Test
    public void fibComparativeTest() {
        Optional<BigInteger> supplierSum = FibStreams.generate().limit(100).parallel().reduce(BigInteger::add);
        Optional<BigInteger> arraySum = FibStreams.streamIterateArray().limit(100).parallel().reduce(BigInteger::add);
        Optional<BigInteger> iteratorSum = FibStreams.streamIterator().limit(100).parallel().reduce(BigInteger::add);
        System.out.println("supplierSum = " + supplierSum);
        System.out.println("arraySum = " + arraySum);
        System.out.println("iteratorSum = " + iteratorSum);
    }
}
