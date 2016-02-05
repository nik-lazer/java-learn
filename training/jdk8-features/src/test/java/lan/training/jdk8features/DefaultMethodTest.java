package lan.training.jdk8features;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by nik-lazer on 2/4/2016.
 */
public class DefaultMethodTest {
    @Test
    public void formulaTest() {
        System.out.println("formulaTest");
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
        assertEquals(100 ,formula.calculate(100), 0.1);
        assertEquals(4, formula.sqrt(16), 0.1);
    }



}
