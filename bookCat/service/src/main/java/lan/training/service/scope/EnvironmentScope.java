package lan.training.service.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by NL on 8/19/2016.
 */
public class EnvironmentScope implements Scope {
    private Map<String, Map<String, ObjectFactory<?>>> environmentMap = new HashMap<>();
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (!environmentMap.containsKey(getEnvironment())) {
            environmentMap.put(getEnvironment(), new HashMap<String, ObjectFactory<?>>());
        }
        return environmentMap.get(getEnvironment()).put(name, objectFactory);
    }

    @Override
    public Object remove(String name) {
        return environmentMap.get(getEnvironment()).remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return environmentMap.get(getEnvironment()).get(key);
    }

    @Override
    public String getConversationId() {
        return "environment";
    }

    private String getEnvironment() {
        return "default";
    }
}
