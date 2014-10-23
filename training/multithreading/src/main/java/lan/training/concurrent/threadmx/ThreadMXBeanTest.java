package lan.training.concurrent.threadmx;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * Test {@link java.lang.management.ThreadMXBean}
 * @author nuk-lazer 14.10.2014   17:07
 */
public class ThreadMXBeanTest {
	class UserThread extends Thread {
		@Override
		public void run() {
			ThreadMXBean thMxB = ManagementFactory.getThreadMXBean();
			System.out.println(("Current thread count:"+ thMxB.getThreadCount()));
			//gets current thread cpu time.
			System.out.println("CurrentThreadCpuTime: "+thMxB.getCurrentThreadCpuTime());
			//gets curent thread user time.
			System.out.println("CurrentThreadUserTime:"+thMxB.getCurrentThreadUserTime());
			//gets Demon thread count
			System.out.println("DaemonThreadCount:"+thMxB.getDaemonThreadCount());
			//gets peak thread count
			System.out.println("PeakThreadCount:"+thMxB.getPeakThreadCount());
			//gets thread count
			System.out.println("ThreadCount:"+thMxB.getThreadCount());
		}
	}
	public static void main(String[] a){
		Thread th= new ThreadMXBeanTest().new UserThread();
		Runtime.getRuntime().addShutdownHook(th);
	}
}
