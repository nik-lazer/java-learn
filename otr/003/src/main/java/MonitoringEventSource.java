

/**
 * @author Pobedyonny Alexey
 *         Date: 15.03.2010
 */
public enum MonitoringEventSource {
	IN("IN"),
	OUT("OUT"),
	ERR("ERR");

	String name;

	MonitoringEventSource(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
