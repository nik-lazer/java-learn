import java.util.Date;
import java.util.UUID;

/**
 * @author Alexey Pobedyonny 11.02.2014
 */

public class Main {
	public static void main(String[] args) {
		MonitoringService ms = new MonitoringService();

		ms.startOperation(Operation.createOperation(MonitoringEventSource.IN, UUID.randomUUID()).setMessage("message", "param"));
		ms.startOperation(Operation.createOperation(MonitoringEventSource.IN, UUID.randomUUID()).setMessage("message", "param1", "param2", "param3", false));
		ms.endOperation(Operation.createOperation(MonitoringEventSource.IN, UUID.randomUUID()).setMessage("message"));
		ms.endOperation(Operation.createOperation(MonitoringEventSource.IN, UUID.randomUUID()).setMessage("message").setError(new Throwable()));
		ms.endOperation(Operation.createOperation(MonitoringEventSource.IN, UUID.randomUUID()).setMessage("message", new Throwable(), false), false);
		ms.startOperation(Operation.createOperation(MonitoringEventSource.IN, UUID.randomUUID()).setMessage("message").setDates(new Date(), new Date()));
	}
}
