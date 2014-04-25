import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Операция
 */
public class Operation {
	private static final String GUID_PLACE = "guid";
	private static final String PARAM_PLACE = "PARAM";
	/**
	 * сервис-источник
	 */
	private MonitoringEventSource source;
	/**
	 * гуид объекта над которым производится операция
	 */
	private Serializable guid;
	/**
	 * сообщение, может использовать внутри себя плейсхолдеры %guid (подставится guid), %param<номер_параметра> (подставится параметр).
	 */
	private String message;
	/**
	 * гуид родительского объекта, для которого была начата операция
	 */
	private Serializable parentGuid;
	/**
	 * ошибка, возникшая в ходе выполнения операции
	 */
	private Throwable error;
	/**
	 * флаг завершенности операции
	 */
	private boolean isCompleted = false;
	/**
	 * флаг успешности операции
	 */
	private boolean isSuccess = true;
	/**
	 *
	 */
	private Date start;
	/**
	 *
	 */
	private Date end;
	/**
	 * параметры для ивента
	 */
	private List paramsList = new ArrayList();

	public Operation(MonitoringEventSource source, Serializable guid) {
		this.source = source;
		this.guid = guid;
	}

	public String getGuid() {
		if (guid != null)
			return guid.toString();
		return null;
	}

	public String getParentGuid() {
		if (parentGuid !=null)
			return parentGuid.toString();
		return null;
	}

	public Operation setParentGuid(Serializable parentGuid) {
		this.parentGuid = parentGuid;
		return this;
	}

	/**
	 * указываем возникшее при выполнении исключение
	 * @param error
	 * @return
	 */
	public Operation setError(Throwable error) {
		this.error = error;
		return this;
	}

	public Throwable getError() {
		return error;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public Date getStart() {
		return start;
	}

	public Date getEnd() {
		return end;
	}

	/**
	 * Проверка наличия произошедших исключений
	 * @return
	 */
	public boolean isWithoutError() {
		return error == null;
	}

	/**
	 * Заполняем даты
	 * @param start
	 * @param end
	 * @return
	 */
	public Operation setDates(Date start, Date end) {
		this.start = start;
		this.end = end;
		return this;
	}

	/**
	 * Заполняем сообщение с аргументами
	 * @param message текстовое сообщение
	 * @param params массив подставляемых параметров
	 * @return
	 */
	public Operation setMessage(String message, Object... params) {
		this.message = message;
		paramsList = Arrays.asList(params);
		return this;
	}

	/**
	 * Устанавливаем признаки старта операции
	 * @return
	 */
	public void setStarted() {
		this.isCompleted = true;
		this.isSuccess = true;
	}

	/**
	 * Устанавливаем признаки завершения операции
	 * @param isSuccess флаг успешности операции
	 * @return
	 */
	public void setEnded(boolean isSuccess) {
		this.isCompleted = true;
		this.isSuccess = isSuccess && isWithoutError();
	}

	/**
	 * Устанавливаем признаки завершения операции
	 * @return
	 */
	public void setEnded() {
		this.isCompleted = true;
		this.isSuccess = isWithoutError();
	}

	/**
	 * Создание события по имеющимся данным
	 * @return
	 */
	public BasicMonitoringEvent createEvent() {
		BasicMonitoringEvent event = new BasicMonitoringEvent(source, getGuid(), parseMessage(), getParentGuid(), getError());
		event.setStart(getStart());
		event.setEnd(getEnd());
		event.setSuccess(isSuccess() && isWithoutError());
		event.setCompleted(isCompleted());
		return event;
	}

	/**
	 * Парсим мессадж
	 * @return сообщение с подставленными параметрами
	 */
	private String parseMessage() {
		String fullMessage = new String(message);
		if (guid != null) {
			fullMessage = fullMessage.replace(GUID_PLACE, getGuid());
		}
		int i = 0;
		for (Object object: paramsList) {
			String param = object.toString();
			fullMessage = fullMessage.replace(PARAM_PLACE + (++i), param);
		}
		return fullMessage;
	}

	/**
	 * Фабричный метод создания операции
	 * @param source
	 * @param guid
	 * @return
	 */
	public static Operation createOperation(MonitoringEventSource source, Serializable guid) {
		return new Operation(source, guid);
	}
}
