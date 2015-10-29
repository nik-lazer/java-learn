package lan.training.concurrent.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * Cachebox model
 * @author nik-lazer  26.10.2015   09:34
 */
public class Cachbox implements Callable<Integer> {
	private static final Logger log = LoggerFactory.getLogger(Cachbox.class);
	private Integer number;
	private ShopMain shopMain;
	private volatile Boolean isGone = true;
	private int processed = 0;

	public Cachbox(int number, ShopMain shopMain) {
		this.number = number;
		this.shopMain = shopMain;
	}

	private void processNextCustomer(Customer customer) {
		log.info("{} Processing customer {} started", toString(), customer);
		try {
			Thread.sleep(customer.getTimeOfProcessing());
		} catch (InterruptedException e) {
			log.error("Cachbox {} is interrupted during processing", e, this);
			shutdown();
		}
		processed++;
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

	@Override
	public Integer call() throws Exception {
		log.info("{} is started", this);
		while (isGone) {
			if (Thread.currentThread().isInterrupted()) {
				shutdown();
			} else {
				Customer customer = shopMain.getNextCustomer();
				if (customer != null) {
					processNextCustomer(customer);
				} else {
					log.info("Something happened during getting customer");
					shutdown();
				}
			}
		}
		log.info("{} is finished", this);
		return processed;
	}
}
