package lan.training.jdk8features;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by nik-lazer on 2/4/2016.
 */
public class DefaultMethodTest {
    @Test
    public void formulaTest() {
        // Old school
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
        // Much more shorter
        Formula exp = a -> Math.pow(a, 2);

        assertEquals(16, exp.calculate(4), 0.1);
        assertEquals(100 ,formula.calculate(100), 0.1);
        assertEquals(4, formula.sqrt(16), 0.1);
    }

    @Test
    public void overrideTest() {
        C1 c1 = new C1();
        assertEquals("C1", c1.test());
        assertEquals("I1C1 double", c1.testDouble());
        assertEquals("I2 third", c1.testThird());
    }

}
