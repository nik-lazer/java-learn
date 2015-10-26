package lan.training.concurrent.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Cachebox model
 * @author nik-lazer  26.10.2015   09:34
 */
public class Cachbox implements Runnable, Comparable<Cachbox> {
	private static final Logger log = LoggerFactory.getLogger(Cachbox.class);
	private Integer number;
	private volatile Boolean isGone = true;
	private Queue<Customer> customers = new LinkedList<>();

	public Cachbox(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		while (isGone) {
			Customer customer = customers.poll();
			if (customer != null) {
				processNextCustomer(customer);
			} else {
				synchronized (this) {
					try {
						log.info("There are no for processing, {} is waiting", this);
						wait(10000);
					} catch (InterruptedException e) {
						log.error("{} is interrupted in waiting", e, this);
					}
				}
			}
		}
		log.info("{} is finished", this);
	}

	public synchronized void addCustomer(Customer customer) {
		customers.add(customer);
		notifyAll();
	}

	private void processNextCustomer(Customer customer) {
		log.info("{} Processing customer {} started", toString(), customer);
		try {
			Thread.sleep(customer.getTimeOfProcessing());
		} catch (InterruptedException e) {
			log.error("Cachbox {} is interrupted during processinf", e, this);
		}
		log.info("{} Processing customer {} finished", this, customer);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Cachbox)) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		return number.equals(((Cachbox) obj).number);
	}

	@Override
	public int compareTo(Cachbox o) {
		Integer size = customers.size();
		return size.compareTo(o.customers.size());
	}

	@Override
	public String toString() {
		return "Cachbox{" +
		       "number=" + number +
		       '}';
	}

	public synchronized void shutdown() {
		isGone = false;
		notifyAll();
	}
}
