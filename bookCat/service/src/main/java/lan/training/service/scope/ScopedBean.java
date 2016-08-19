package lan.training.service.scope;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by NL on 8/19/2016.
 */
//@Scope("environment")
@Component
public class ScopedBean implements ApplicationContextAware, InitializingBean {
    @Autowired(required = false)
    private EnvironmentData enironmentData;
    private ApplicationContext applicationContext;

    @PostConstruct
    public void post() {
        if (enironmentData == null) {
            //enironmentData = applicationContext.getBean("specific", EnvironmentData.class);
        }
    }

    public EnvironmentData getEnironmentData() {
        return enironmentData;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        post();
    }
}
