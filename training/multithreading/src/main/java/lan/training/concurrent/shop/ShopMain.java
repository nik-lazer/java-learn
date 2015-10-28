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

/**
 * Main class for shop model
 * @author nik-lazer  26.10.2015   09:33
 */
public class ShopMain extends Thread {
	Logger log = LoggerFactory.getLogger(ShopMain.class);
	private volatile Boolean isGone = true;
	private ShopSettings shopSettings;
	List<Cachbox> cachboxes = new ArrayList<>();
	Queue<Customer> customers = new LinkedList<>();
	private int id;
	private Object customerMonitor = new Object();

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
			generateCustomer();
			long delay = Math.round(Math.random() * 10000 / settings.getCachBoxNumber());
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
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
		synchronized (customerMonitor) {
			isGone = false;
			for (Cachbox cachbox: cachboxes) {
				cachbox.shutdown();
			}
			customerMonitor.notifyAll();
		}
	}

	private void generateCustomer() {
		long timeForProcessing = Math.round(Math.random() * 10000);
		Customer customer = new Customer(++id, timeForProcessing);
		log.info("{} is generated", customer);
		synchronized (customerMonitor) {
			customers.add(customer);
			customerMonitor.notifyAll();
		}
	}

	public Customer getNextCustomer() {
		synchronized (customerMonitor) {
			Customer customer = customers.poll();
			log.info("{} is get", customer);
			return customer;
		}
	}

	public Object getCustomerMonitor() {
		return customerMonitor;
	}
}
