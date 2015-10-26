package lan.training.concurrent.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Main class for shop model
 * @author nik-lazer  26.10.2015   09:33
 */
public class ShopMain extends Thread {
	Logger log = LoggerFactory.getLogger(ShopMain.class);
	private volatile boolean isGone = true;
	private ShopSettings shopSettings;
	List<Cachbox> cachboxes = new ArrayList<>();
	private int id;

	public static void main(String[] args) {
		ShopMain main = new ShopMain();
		main.start();
	}

	@Override
	public void run() {
		ShopSettings settings = getSettings();
		for (int i=0; i<settings.getCachBoxNumber(); i++) {
			Cachbox cachbox = new Cachbox(i+1);
			Thread thread = new Thread(cachbox);
			cachboxes.add(cachbox);
			thread.start();
		}
		new Thread() {
			@Override
			public void run() {
				Scanner scanner = new Scanner(System.in);
				while (isGone) {
					String data = scanner.next("exit");
					stopThreads();
				}
				log.info("Keyboard controller is finished");
			}
		}.start();
		while (isGone) {
			Customer customer = generateCustomer();
			Collections.sort(cachboxes);
			Cachbox cachbox = cachboxes.get(0);
			log.info("Selected {} as the least loaded", cachbox);
			cachbox.addCustomer(customer);
			long delay = Math.round(Math.random() * 1000000 / settings.getCachBoxNumber());
			synchronized (this) {
				try {
					wait(delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		log.info("Main is finished");
	}

	private ShopSettings getSettings() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input number of cachbox");
		int cachBoxNumber = scanner.nextInt();
		System.out.println("Please input true for output in file");
		boolean isFile = scanner.nextBoolean();
		return new ShopSettings(cachBoxNumber, (isFile?StatOutputType.FILE:StatOutputType.CONSOLE));
	}

	private void stopThreads() {
		log.info("Shutdown");
		synchronized (this) {
			isGone = false;
			notify();
		}
		for (Cachbox cachbox: cachboxes) {
			cachbox.shutdown();
		}
	}

	private Customer generateCustomer() {
		long timeForProcessing = Math.round(Math.random() * 10000);
		Customer customer = new Customer(++id, timeForProcessing);
		log.info("{} is generated", customer);
		return customer;
	}
}
