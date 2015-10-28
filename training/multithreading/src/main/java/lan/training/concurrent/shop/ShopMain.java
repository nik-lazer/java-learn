package lan.training.concurrent.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Main class for shop model
 * @author nik-lazer  26.10.2015   09:33
 */
public class ShopMain extends Thread {
	Logger log = LoggerFactory.getLogger(ShopMain.class);
	private volatile Boolean isGone = true;
	private ShopSettings shopSettings;
	List<Thread> cachboxes = new ArrayList<>();
	BlockingQueue<Customer> customers = new LinkedBlockingQueue<>();
	private int id;

	public static void main(String[] args) {
		ShopMain main = new ShopMain();
		main.start();
	}

	@Override
	public void run() {
		ShopSettings settings = getSettings();
		for (int i=0; i<settings.getCachBoxNumber(); i++) {
			Cachbox cachbox = new Cachbox(i+1, this);
			Thread thread = new Thread(cachbox);
			cachboxes.add(thread);
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
			generateCustomer();
			long delay = Math.round(Math.random() * 10000 / settings.getCachBoxNumber());
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				log.error("sleeping error", e);
				stopThreads();
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
		isGone = false;
		for (Thread cachbox: cachboxes) {
			cachbox.interrupt();;
		}
	}

	private void generateCustomer() {
		long timeForProcessing = Math.round(Math.random() * 10000);
		Customer customer = new Customer(++id, timeForProcessing);
		log.info("{} is generated", customer);
		try {
			customers.put(customer);
		} catch (InterruptedException e) {
			log.error("generate error", e);
		}
	}

	public Customer getNextCustomer() {
		Customer customer = null;
		try {
			customer = customers.take();
		} catch (InterruptedException e) {
			log.error("taking error", e);
		}
		log.info("{} is got", customer);
		return customer;
	}
}
