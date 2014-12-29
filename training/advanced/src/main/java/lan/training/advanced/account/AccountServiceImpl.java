package lan.training.advanced.account;

import lan.training.advanced.base.AccountService;
import lan.training.advanced.message.Address;
import lan.training.advanced.message.MessageSystem;
import lan.training.advanced.util.TimeHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;

/**
 * Account service for searching users. Store data in map
 * @author nik-lazer  29.12.2014   12:12
 */
public class AccountServiceImpl implements Runnable, AccountService {
	private static Logger log = Logger.getLogger(AccountServiceImpl.class.getName());
	private static Map<String, Integer> users = new HashMap<>();

	private Address address = new Address();
	private MessageSystem messageSystem;

	public AccountServiceImpl(MessageSystem messageSystem) {
		this.messageSystem = messageSystem;
		messageSystem.addService(this);
		users.put("first", 1);
		users.put("second", 2);
		users.put("third", 3);
	}

	@Override
	public void run() {
		while (true) {
			messageSystem.execForAbonent(this);
			TimeHelper.sleep(5000);
		}
	}

	@Override
	public Address getAddress() {
		return address;
	}

	@Override
	public MessageSystem getMessageSystem() {
		return messageSystem;
	}

	@Override
	public Integer getUserId(String name) {
		log.info("Id for name" + name + " requested");
		TimeHelper.sleep(5000);
		int id = users.get(name);
		log.info("Id for name" + name + " equals " + id);
		return id;
	}
}
