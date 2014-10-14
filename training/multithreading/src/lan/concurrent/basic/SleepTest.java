package lan.concurrent.basic;

import java.util.Arrays;
import java.util.List;

/**
 * Created by nik-lazer on 14.10.14.
 */
public class SleepTest extends Thread {
	public static void main(String[] args) {
		System.out.println("SleepTest started");
		(new SleepTest()).start();
		System.out.println("SleepTest finished");
	}

	private List<String> words = Arrays.asList("one", "two", "three", "four", "five");

	public void run() {
		for (String word: words) {
			try {
				sleep(1000);
				System.out.println(word);
			} catch (InterruptedException e) {
				System.out.println("Thread was interrupted");
			}
		}
	}
}
