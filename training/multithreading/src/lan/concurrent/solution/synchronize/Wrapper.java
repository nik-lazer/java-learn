package lan.concurrent.solution.synchronize;

import lan.concurrent.task.MyObj;
import lan.concurrent.task.MyObjImpl;

/**
 * Wrapper around {@link lan.concurrent.task.MyObj}
 * @author nik-lazer 25.12.2013   10:01
 */
public class Wrapper {
	private final MyObj obj = new MyObjImpl();

	public void setReady(boolean flag) {
		synchronized (obj) {
			boolean needNotify = !obj.isReady() && flag;
			obj.setReady(flag);
			if (needNotify) {
				System.out.println("obj is ready, notify workers");
				obj.notifyAll();
			}

		}
	}
	public void waitForReady() {
		synchronized (obj) {
			while (!obj.isReady()) {
				try {
					System.out.println("need wait");
					obj.wait();
				} catch (InterruptedException e) {
					System.out.println("Ready change notification!");
					e.printStackTrace();
				}
			}
		}
	}

}
