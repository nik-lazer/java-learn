package lan.training.jdk8features;

import org.junit.Test;

import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

import static org.junit.Assert.assertEquals;

/**
 * Created by nik-lazer on 2/10/2016.
 */
public class NumbersSample {
    @Test
    public void intBinaryTest() {
        IntBinaryOperator simpleAdd = (left, right) -> left + right;
        IntFunction<IntUnaryOperator> curriedAdd = value -> operand -> operand + value;

        assertEquals(9, simpleAdd.applyAsInt(4, 5));
        assertEquals(13, curriedAdd.apply(5).applyAsInt(8));

        IntUnaryOperator adder = curriedAdd.apply(5);
        assertEquals(8, adder.applyAsInt(3));
    }
}
