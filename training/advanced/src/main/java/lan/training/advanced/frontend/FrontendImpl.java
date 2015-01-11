package lan.training.advanced.frontend;

import lan.training.advanced.base.Frontend;
import lan.training.advanced.jetty.PageGenerator;
import lan.training.advanced.mechanics.GameSession;
import lan.training.advanced.mechanics.MsgStartGameSession;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;

/**
 * {@link lan.training.advanced.base.Frontend} Jetty-based implementation
 * @author nik-lazer  26.12.2014   11:41
 */
public class FrontendImpl extends AbstractHandler implements Runnable, Frontend {
	private static Logger log = Logger.getLogger(FrontendImpl.class.getName());

	private volatile int handleCount = 0;
	private MessageSystem messageSystem;
	private Address accountAddress;
	private Address gmAddress;
	private Address address = new Address();
	Map<Integer, UserSession> userSessionMap = new ConcurrentHashMap<>();

	public FrontendImpl(MessageSystem messageSystem, Address accountAddress, Address gmAddress) {
		this.messageSystem = messageSystem;
		messageSystem.addService(this);
		this.accountAddress = accountAddress;
		this.gmAddress = gmAddress;
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
			messageSystem.sendMessage(new MsgGetUserId(getAddress(), accountAddress, name));
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
		Map<Integer, Integer> applicants = new HashMap<>();
		UserSession resSession = null;
		for (UserSession userSession: userSessionMap.values()) {
			if (!userSession.isTakePart() && (userSession.getUserId() != 0) && !applicants.containsKey(userSession.getUserId())) {
				applicants.put(userSession.getUserId(), userSession.getSessionId());
			}
			if (name.equals(userSession.getUserName()) && userSession.getUserId() == 0) {
				log.info("Id for user " + name + " is " + userId + "!");
				resSession = userSession;
			}
		}
		if (resSession != null) {
			resSession.setUserId(userId);
			if (!applicants.containsKey(userId)) {
				applicants.put(resSession.getUserId(), resSession.getSessionId());
			}
		}
		if (applicants.size() > 2) {
			startGame(applicants);
		}
	}

	@Override
	public void replicateGameSession(GameSession gameSession) {
		UserSession userSession1 = null;
		UserSession userSession2 = null;
		for (UserSession userSession: userSessionMap.values()) {
			if (userSession.getUserId() == gameSession.getUserId1()) {
				userSession1 = userSession;
			}
			if (userSession.getUserId() == gameSession.getUserId2()) {
				userSession2 = userSession;
			}
		}
		userSession1.setEnemyName(userSession2.getUserName());
		userSession1.setClickedByUser(gameSession.getClickCount1());
		userSession2.setEnemyName(userSession1.getUserName());
		userSession2.setClickedByUser(gameSession.getClickCount2());
	}

	private void startGame(Map<Integer, Integer> applicants) {
		List<Integer> users = new ArrayList<>(2);
		int i = 0;
		for (Integer id: applicants.values()) {
			if (i>1) {
				break;
			}
			UserSession userSession = userSessionMap.get(id);
			userSession.setTakePart(true);
			users.add(userSession.getUserId());
			i++;
		}
		messageSystem.sendMessage(new MsgStartGameSession(getAddress(), gmAddress, users.get(0), users.get(1)));
	}

	@Override
	public Address getAddress() {
		return address;
	}
}
