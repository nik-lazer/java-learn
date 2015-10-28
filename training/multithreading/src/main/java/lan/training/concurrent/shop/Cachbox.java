package lan.training.concurrent.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Cachebox model
 * @author nik-lazer  26.10.2015   09:34
 */
public class Cachbox implements Runnable {
	private static final Logger log = LoggerFactory.getLogger(Cachbox.class);
	private Integer number;
	private ShopMain shopMain;
	private volatile Boolean isGone = true;

	public Cachbox(int number, ShopMain shopMain) {
		this.number = number;
		this.shopMain = shopMain;
	}

	@Override
	public void run() {
		while (isGone) {
			Customer customer = shopMain.getNextCustomer();
			if (customer != null) {
				processNextCustomer(customer);
			}
		}
		log.info("{} is finished", this);
	}

	private void processNextCustomer(Customer customer) {
		log.info("{} Processing customer {} started", toString(), customer);
		try {
			Thread.sleep(customer.getTimeOfProcessing());
		} catch (InterruptedException e) {
			log.error("Cachbox {} is interrupted during processing", e, this);
			shutdown();
		}
		log.info("{} Processing customer {} finished", this, customer);
	}

	@Override
	public String toString() {
		return "Cachbox{" +
		       "number=" + number +
		       '}';
	}

	public void shutdown() {
		isGone = false;
	}
}
