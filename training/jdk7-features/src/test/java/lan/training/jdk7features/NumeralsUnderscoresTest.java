package lan.training.jdk7features;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by nik-lazer on 2/4/2016.
 */
public class NumeralsUnderscoresTest {
    @Test
    public void decimalTest() {
        int number = 9_235_7;
        assertEquals(92357, number);
    }

    @Test
    public void decimalFloat() {
        float pi = 3.14_15F;
        assertEquals(3.1415, pi, 0.1);
    }
}
