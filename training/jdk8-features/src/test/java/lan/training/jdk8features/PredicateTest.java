package lan.training.jdk8features;

import org.junit.Test;

import java.util.Objects;
import java.util.function.Predicate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by nik-lazer on 2/4/2016.
 */
public class PredicateTest {
    @Test
    public void stringTest() {
        Predicate<String> predicate = (s) -> s.length() > 0;

        assertTrue(predicate.test("foo"));
        assertFalse(predicate.negate().test("foo"));
    }

    @Test
    public void nullTest() {
        Predicate<Object> nonNull = Objects::nonNull;
        Predicate<Object> isNull = Objects::isNull;

        assertTrue(nonNull.test(Boolean.TRUE));
        assertFalse(isNull.test("foo"));
    }

    @Test
    public void negateTest() {
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        assertTrue(isEmpty.test(""));
        assertTrue(isNotEmpty.test("foo"));
    }
}
