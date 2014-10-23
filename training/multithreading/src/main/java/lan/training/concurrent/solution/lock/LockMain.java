package lan.training.concurrent.solution.lock;

import lan.training.concurrent.solution.Worker;

/**
 * Created by nik-lazer on 15.10.14.
 */
public class LockMain {
	public static void main(String[] args) {
		System.out.println("LockMain started");
		LockWrapper wrapper = new LockWrapper();
		Worker worker1 = new Worker("Lock worker 1", wrapper);
		Worker worker2 = new Worker("Lock worker 2", wrapper);
		worker1.start();
		worker2.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wrapper.setReady(true);
		System.out.println("LockMain finished");
	}
}
