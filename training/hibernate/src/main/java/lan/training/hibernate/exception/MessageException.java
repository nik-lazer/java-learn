package lan.training.hibernate.exception;

/**
 * Message receiving exception
 * @author nik-lazer  23.12.2014   16:24
 */
public class MessageException extends RuntimeException {
	public MessageException(String message) {
		super(message);
	}

	public MessageException(String message, Throwable cause) {
		super(message, cause);
	}
}
