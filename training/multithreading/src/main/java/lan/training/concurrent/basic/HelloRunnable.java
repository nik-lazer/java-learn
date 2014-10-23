package lan.training.concurrent.basic;

/**
 * Created by nik-lazer on 14.10.14.
 */
public class HelloRunnable implements Runnable {

	public void run() {
		System.out.println("Hello from a runnable!");
	}

	public static void main(String args[]) {
		System.out.println("try start runnable");
		(new Thread(new HelloRunnable())).start();
		System.out.println("runnable started");
	}

}
