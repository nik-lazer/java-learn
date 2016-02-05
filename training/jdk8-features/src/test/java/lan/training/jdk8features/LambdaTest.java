package lan.training.jdk8features;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by nik-lazer on 2/4/2016.
 */
public class LambdaTest {
    private Lambda lambda;

    @Before
    public void init() {
        lambda = new Lambda(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void sumAllTest() {
        int sumAllOld = lambda.sumAll();
        int sumAllNew = lambda.sumAll(n -> true);
        assertEquals(sumAllOld, sumAllNew);
    }

    @Test
    public void sumAllEvenTest() {
        int sumAllEvenOld = lambda.sumAllEven();
        int sumAllEvenNew = lambda.sumAll(n -> (n % 2 == 0));
        assertEquals(sumAllEvenOld, sumAllEvenNew);
    }

    @Test
    public void sumNonTrivialTest() {
        int sumAboveThree = lambda.sumAll(n -> n > 3);
        assertEquals(15, sumAboveThree);
    }
}
