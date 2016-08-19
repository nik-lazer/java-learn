package lan.training.service.scope;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by NL on 8/19/2016.
 */
@Configuration
@ComponentScan("lan.training.service.scope")
public class EnvironmentConfig {
    @Bean
    @Qualifier("default")
    @Primary
    public EnvironmentData getDefaultEnironmentData() {
        return new EnvironmentData("default");
    }

    @Bean
    @Qualifier("specific")
    public EnvironmentData getSpecificEnironmentData() {
        return new EnvironmentData("specific");
    }

    @Bean
    public CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();
        Map<String, Object> scopes = new HashMap();
        scopes.put("environment", new EnvironmentScope());
        customScopeConfigurer.setScopes(scopes);
        return customScopeConfigurer;
    }
}
