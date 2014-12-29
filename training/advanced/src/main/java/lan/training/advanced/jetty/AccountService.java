package lan.training.advanced.jetty;

import lan.training.advanced.message.Abonent;
import lan.training.advanced.message.Address;
import lan.training.advanced.message.MessageSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;

/**
 * Account service for serarching users. Store data in map
 * @author nik-lazer  29.12.2014   12:12
 */
public class AccountService implements Runnable, Abonent {
	private static Logger log = Logger.getLogger(AccountService.class.getName());
	private static Map<String, Integer> users = new HashMap<>();

	private Address address = new Address();
	private MessageSystem messageSystem;

	public AccountService(MessageSystem messageSystem) {
		this.messageSystem = messageSystem;
		messageSystem.addService(this);
		users.put("first", 1);
		users.put("second", 2);
		users.put("third", 3);
	}

	@Override
	public void run() {
		while (true) {
			try {
				messageSystem.execForAbonent(this);
				sleep(5000);
			} catch (InterruptedException e) {
				log.log(Level.WARNING, "Frontend was interrupted", e);
				e.printStackTrace();
			}
		}
	}

	@Override
	public Address getAddress() {
		return address;
	}

	public MessageSystem getMessageSystem() {
		return messageSystem;
	}

	public Integer getUserId(String name) {
		log.info("Id for name" + name + " requested");
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			log.log(Level.WARNING, "Account Service was interrupted", e);
		}
		int id = users.get(name);
		log.info("Id for name" + name + " equals " + id);
		return id;
	}
}
