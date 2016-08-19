package lan.training.service.scope;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by NL on 8/19/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EnvironmentConfig.class)
public class ScopedBeanTest {
    @Autowired
    @Environment("specific")
    private ScopedBean scopedBean;

    @Test
    public void testEnvironment() throws Exception {
        assertNotNull(scopedBean.getEnironmentData());
        assertEquals("default", scopedBean.getEnironmentData().getData());

    }
}