import java.util.Date;

/**
 * @author Alexey Pobedyonny 11.02.2014
 */
public class BasicMonitoringEvent {
	private final MonitoringEventSource source;
	private final String guid;
	private final CharSequence message;
	private final String parentGuid;
	private final Throwable error;
	private boolean success;
	private boolean completed;
	private Date start;
	private Date end;

	public BasicMonitoringEvent(MonitoringEventSource source, String guid, CharSequence message, String parentGuid, Throwable error) {

		this.source = source;
		this.guid = guid;
		this.message = message;
		this.parentGuid = parentGuid;
		this.error = error;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public boolean isCompleted() {
		return completed;
	}

	public MonitoringEventSource getSource() {
		return source;
	}

	public String getGuid() {
		return guid;
	}

	public CharSequence getMessage() {
		return message;
	}

	public String getParentGuid() {
		return parentGuid;
	}

	public Throwable getError() {
		return error;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getStart() {
		return start;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Date getEnd() {
		return end;
	}
}
