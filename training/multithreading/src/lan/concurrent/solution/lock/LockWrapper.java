package lan.concurrent.solution.lock;

import lan.concurrent.solution.Wrapper;
import lan.concurrent.task.MyObj;
import lan.concurrent.task.MyObjImpl;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by nik-lazer on 15.10.14.
 */
public class LockWrapper implements Wrapper {
	private volatile MyObj obj = new MyObjImpl();
	private Lock lock = new ReentrantLock();
	Condition wait = lock.newCondition();

	public void setReady(boolean flag) {
		lock.lock();
		try {
			boolean needNotify = !obj.isReady() && flag;
			obj.setReady(flag);
			if (needNotify) {
				System.out.println("obj is ready, notify workers");
				wait.signalAll();
			}
		} finally {
			lock.unlock();
		}

	}

	public void waitForReady() {
		if (lock.tryLock()) {
			try {
				if (!obj.isReady()) {
					try {
						System.out.println("need await");
						wait.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} finally {
				lock.unlock();
			}
		} else {
			System.out.println("need wait");
		}
	}
}
