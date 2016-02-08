package lan.training.jdk8features.stream;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by nik-lazer on 2/8/2016.
 */
public class FibStreams {
    public static Stream<BigInteger> generate() {
        return Stream.generate(new Supplier<BigInteger>() {
            BigInteger first = BigInteger.ZERO;
            BigInteger second = BigInteger.ONE;
            @Override
            public BigInteger get() {
                BigInteger s = second.add(first);
                first = second;
                second = s;
                return first;
            }
        });
    }

    public static Stream<BigInteger> streamIterateArray() {
        return Stream.iterate(new BigInteger[] {BigInteger.ZERO, BigInteger.ONE},
                t -> new BigInteger[] {t[1], t[0].add(t[1])}).map(bigIntegers -> bigIntegers[1]);
    }

    public static Stream<BigInteger> streamIterator() {
        Iterator<BigInteger> bit = new Iterator<BigInteger>() {
            BigInteger first = BigInteger.ZERO;
            BigInteger second = BigInteger.ONE;
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public BigInteger next() {
                BigInteger s = second.add(first);
                first = second;
                second = s;
                return first;
            }
        };

        Spliterator<BigInteger> bsplit = Spliterators.spliterator(bit, Long.MAX_VALUE, Spliterator.ORDERED | Spliterator.SORTED | Spliterator.NONNULL | Spliterator.IMMUTABLE);
        return StreamSupport.stream(bsplit, false);
    }
}
