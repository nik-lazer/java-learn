package lan.training.concurrent.basic;

/**
 * Created by nik-lazer on 14.10.14.
 */
public class DataSender {
	private static final Object monitor = new Object();
	private static boolean ready = false;

	public static void main(String[] args) {
		DataPreparer dataPreparer = new DataPreparer();
		dataPreparer.start();
		//dataPreparer.interrupt();

		synchronized (monitor) {
			System.out.println("Waiting for data...");
			while (!ready) {
				try {
					monitor.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			// continue execution and sending data
			System.out.println("Sending data...");
		}
	}

	static class DataPreparer extends Thread {

		@Override
		public void run() {
			synchronized (monitor) {
				try {
					sleep(2000);
				} catch (InterruptedException e) {
					System.out.println("Thread was interrupted!");
					return;
				}
				System.out.println("Data prepared");
				ready = true;
				monitor.notifyAll();
			}
		}
	}
}
