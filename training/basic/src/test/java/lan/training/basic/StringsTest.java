package lan.training.basic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by nik-lazer on 14.01.16.
 */
public class StringsTest {
    @Test
    public void concatTest() {
        String s = 15 + 11 + "a";
        String s2 = "" + 15 + 11 + "a";
        assertEquals("26a", s);
        assertEquals("1511a", s2);
    }
}
