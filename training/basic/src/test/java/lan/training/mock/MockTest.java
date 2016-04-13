package lan.training.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test for replacing {@link Calculation} to dummy version
 * Created by nik-lazer on 4/8/2016.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(LegacyClass.class)
public class MockTest {


    @Test
    public void mockConstructorTest() throws Exception {
        PowerMockito.spy(LegacyClass.class);
        PowerMockito.whenNew(Calculation.class).withNoArguments().thenReturn(new MockCalculation());
        LegacyClass.work();
    }

    private class MockCalculation extends Calculation {
        public MockCalculation() {
            System.out.println("Mock calculation init");
        }

        @Override
        public boolean calculate(String s, int i) {
            System.out.println("Mock calculate: "+s + "::" +i);
            return true;
        }
    }
}
