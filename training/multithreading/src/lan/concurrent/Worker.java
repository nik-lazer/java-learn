package lan.concurrent;

/**
 * Реализация конкурирующих тредов
 * @author lazarev_nv 25.12.2013   10:16
 */
public class Worker extends Thread {
	private Wrapper wrapper;

	public Worker(String name, Wrapper wrapper) {
		super(name);
		this.wrapper = wrapper;
	}

	@Override
	public void run() {
		System.out.println(getName()+": started");
		wrapper.waitForReady();
		System.out.println(getName()+": finished");
	}
}
