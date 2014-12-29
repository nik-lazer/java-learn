package lan.training.advanced.message;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;

/**
 * Message system
 * @author nik-lazer  29.12.2014   12:36
 */
public class MessageSystemImpl implements MessageSystem {
	private static Logger log = Logger.getLogger(MessageSystemImpl.class.getName());
	private Map<Address, ConcurrentLinkedQueue<Msg>> messages = new HashMap<>();
	private AddressService addressService = new AddressService();

	public void addService(Abonent abonent) {
		addressService.addAdress(abonent.getClass(), abonent.getAddress());
		messages.put(abonent.getAddress(), new ConcurrentLinkedQueue<Msg>());
	}

	public void sendMessage(Msg message) {
		ConcurrentLinkedQueue<Msg> messageQueue = messages.get(message.getTo());
		messageQueue.add(message);
		log.info("Message sended: " + message.toString());
	}

	public void execForAbonent(Abonent abonent) {
		ConcurrentLinkedQueue<Msg> messageQueue = messages.get(abonent.getAddress());
		while (!messageQueue.isEmpty()) {
			Msg msg = messageQueue.poll();
			log.info("Message received: " + msg.toString());
			msg.exec(abonent);
		}
	}

	public AddressService getAddressService() {
		return addressService;
	}
}
