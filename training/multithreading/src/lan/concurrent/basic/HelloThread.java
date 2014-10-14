package lan.concurrent.basic;

/**
 * Created by nik-lazer on 14.10.14.
 */
public class HelloThread extends Thread {
	public void run() {
		System.out.println("Hello from a thread!");
	}

	public static void main(String args[]) {
		System.out.println("try start thread");
		(new HelloThread()).start();
		System.out.println("thread started");
	}
}
