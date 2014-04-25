import java.util.HashMap;
import java.util.Map;

/**
 * @author Pobedyonny Alexey
 *         Date: 11.02.2011
 */
public class MonitoringService {
	private Map<String, BasicMonitoringEvent> events = new HashMap<String, BasicMonitoringEvent>();

	/**
	 * Старт операции
	 * @param operation
	 */
	public void startOperation(Operation operation) {
		operation.setStarted();
		sendEvent(operation.createEvent());
	}

	/**
	 * Завершение операции с явным указанием ее успешности
	 * @param operation
	 * @param isSuccess
	 */
	public void endOperation(Operation operation, boolean isSuccess) {
		operation.setEnded(isSuccess);
		sendEvent(operation.createEvent());
	}

	/**
	 * Завершение операции с неявным указанием ее успешности
	 * @param operation
	 */
	public void endOperation(Operation operation) {
		operation.setEnded();
		sendEvent(operation.createEvent());
	}

	private void sendEvent(BasicMonitoringEvent event) {
		events.put(event.getGuid(), event);
	}
}
