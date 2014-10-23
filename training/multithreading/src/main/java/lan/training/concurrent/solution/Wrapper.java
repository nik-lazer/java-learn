package lan.training.concurrent.solution;

/**
 * Created by nik-lazer on 15.10.14.
 */
public interface Wrapper {
	void setReady(boolean flag);
	public void waitForReady();
}
