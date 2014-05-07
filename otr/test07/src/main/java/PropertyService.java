import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexey Pobedyonny 07.05.2014
 */
public class PropertyService {
	private Map<String, String> properties;

	public String getProperty(String key) {
		checkProperties();
		return properties.get(key);
	}

	public boolean hasProperty(String key) {
		checkProperties();
		return properties.containsKey(key);
	}

	private void checkProperties() {
		if(properties == null) {
			properties = loadProperties();
		}
	}

	private Map<String, String> loadProperties() {
		//load some properties here
		HashMap<String, String> result = new HashMap<String, String>();
		result.put("OS", "Linux");
		result.put("Arch", "x86");
		result.put("StartDate", new Date().toString());
		return result;
	}
}
