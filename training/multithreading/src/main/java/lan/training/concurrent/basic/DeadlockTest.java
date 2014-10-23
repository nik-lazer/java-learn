package lan.training.concurrent.basic;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;

/**
 * Created by nik-lazer on 14.10.14.
 */
public class DeadlockTest {

	static class Friend {
		private final String name;
		public Friend(String name) {
			this.name = name;
		}
		public String getName() {
			return this.name;
		}
		public synchronized void bow(Friend bower) {
			System.out.format("%s: %s has bowed to me!%n", this.name, bower.getName());
			bower.bowBack(this);
		}
		public synchronized void bowBack(Friend bower) {
			System.out.format("%s: %s has bowed back to me!%n", this.name, bower.getName());
		}
	}

	public static void main(String[] args) {
		final Friend alphonse =
				new Friend("Alphonse");
		final Friend gaston =
				new Friend("Gaston");
		new Thread(new Runnable() {
			public void run() { alphonse.bow(gaston); }
		}).start();
		new Thread(new Runnable() {
			public void run() { gaston.bow(alphonse); }
		}).start();
		try {
			Thread.sleep(2000);
			getStat();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void getStat() {
		ThreadMXBean thMxB = ManagementFactory.getThreadMXBean();
		long[] ids = thMxB.findDeadlockedThreads();
		long[] idsMonitor = thMxB.findMonitorDeadlockedThreads();
		System.out.println("findDeadlockedThreads: " + Arrays.toString(ids));
		System.out.println("findMonitorDeadlockedThreads" + Arrays.toString(idsMonitor));
		if (ids != null) {
			System.out.println("Thread info: " + Arrays.toString(thMxB.getThreadInfo(ids)));
		}
	}
}
