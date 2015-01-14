package lan.training.advanced.mechanics;

import lan.training.advanced.base.Frontend;
import lan.training.advanced.base.GameMechanics;
import lan.training.advanced.frontend.MsgReplicateGameSession;
import lan.training.advanced.message.Address;
import lan.training.advanced.message.MessageSystem;
import lan.training.advanced.message.Recipients;
import lan.training.advanced.resource.ResourceFactory;
import lan.training.advanced.util.TimeHelper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Game mechanic implementation
 * Created by nik-lazer on 30.12.14.
 */
public class GameMechanicsImpl implements GameMechanics, Runnable {
	private final Map<Integer, GameSession> gameSessionMap = new HashMap<>();
	private Address address = new Address();
	MessageSystem messageSystem;

	public GameMechanicsImpl(MessageSystem messageSystem) {
		this.messageSystem = messageSystem;
		messageSystem.addService(Recipients.GAME_MECHANICS, this);
	}

	@Override
	public MessageSystem getMessageSystem() {
		return messageSystem;
	}

	@Override
	public void startGame(int userId1, int userId2) {
		GameSession gameSession = new GameSession(userId1, userId2);
		gameSessionMap.put(userId1, gameSession);
		gameSessionMap.put(userId2, gameSession);
	}

	@Override
	public void incrementUserClick(int userId) {
		GameSession session = gameSessionMap.get(userId);
		if (!session.isFinished()) {
			if (userId == session.getUserId1()) {
				session.incrementClickCount1();
			}
			if (userId == session.getUserId2()) {
				session.incrementClickCount2();
			}
		}
	}

	@Override
	public Address getAddress() {
		return address;
	}

	@Override
	public void run() {
		while (true) {
			processMessages();
			doGMStep();
			replicateGamesToFrontend();
			TimeHelper.sleep(ResourceFactory.getGMResource().getRunDelay());
		}
	}

	private void replicateGamesToFrontend() {
		for (GameSession gameSession: gameSessionMap.values()) {
			messageSystem.sendMessage(new MsgReplicateGameSession(getAddress(), messageSystem.getAddressService().getAddress(Recipients.FRONTEND), gameSession));
		}
	}

	private void doGMStep() {
		for (GameSession gameSession: gameSessionMap.values()) {
			if (!gameSession.isFinished()) {
				Date endDate = new Date();
				endDate.setTime(gameSession.getStartTime().getTime() + gameSession.DURATION);
				Date now = new Date();
				if (now.after(endDate)) {
					gameSession.stop();
				}
			}
		}
	}

	private void processMessages() {
		messageSystem.execForAbonent(this);
	}
}
