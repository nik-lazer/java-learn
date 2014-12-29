package lan.training.advanced.frontend;

import lan.training.advanced.base.Frontend;
import lan.training.advanced.jetty.PageGenerator;
import lan.training.advanced.message.Address;
import lan.training.advanced.message.MessageSystem;
import lan.training.advanced.account.MsgGetUserId;
import lan.training.advanced.util.TimeHelper;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;

/**
 * Abstarct handler uding sample
 * @author nik-lazer  26.12.2014   11:41
 */
public class FrontendImpl extends AbstractHandler implements Runnable, Frontend {
	private static Logger log = Logger.getLogger(FrontendImpl.class.getName());

	private volatile int handleCount = 0;
	private MessageSystem messageSystem;
	private Address recipientAddress;
	private Address address = new Address();
	Map<Integer, UserSession> userSessionMap = new ConcurrentHashMap<>();

	public FrontendImpl(MessageSystem messageSystem, Address recipientAddress) {
		this.messageSystem = messageSystem;
		messageSystem.addService(this);
		this.recipientAddress = recipientAddress;
	}

	@Override
	public void handle(String s, Request request, HttpServletRequest request2, HttpServletResponse response) throws IOException, ServletException {
		String param = request.getParameter("id");
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		request.setHandled(true);
		Integer id = PageGenerator.getId(param);
		if (id == null ) {
			id = PageGenerator.generateId();
			userSessionMap.put(id, new UserSession(id));
		}
		String name = request.getParameter("name");
		if (name != null && !name.isEmpty()) {
			UserSession session = userSessionMap.get(id);
			session.setUserName(name);
			messageSystem.sendMessage(new MsgGetUserId(getAddress(), recipientAddress, name));
		}
		incCounter();
		response.getWriter().println(PageGenerator.createRefreshingFormPage(userSessionMap.get(id)));
	}

	@Override
	public void run() {
		while (true) {
			messageSystem.execForAbonent(this);
			TimeHelper.sleep(5000);
			log.info("handleCount=" + handleCount);
		}
	}

	private synchronized void incCounter() {
		handleCount++;
		log.info("handleCount increment: old val=" + (handleCount - 1) + ", new value=" + handleCount);
	}

	@Override
	public MessageSystem getMessageSystem() {
		return messageSystem;
	}

	@Override
	public void updateUserId(String name, int userId) {
		for (UserSession userSession: userSessionMap.values()) {
			if (name.equals(userSession.getUserName())) {
				log.info("Id for user " + name + " is " + userId + "!");
				userSession.setUserId(userId);
				break;
			}
		}
	}

	@Override
	public Address getAddress() {
		return address;
	}
}
