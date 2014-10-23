package lan.training.concurrent.task;

/**
 * Wrapped non-thread-safe interface
 * @author nik-lazer 25.12.2013   09:59
 */
public interface MyObj {
	void setReady(boolean flag);
	boolean isReady();
}
