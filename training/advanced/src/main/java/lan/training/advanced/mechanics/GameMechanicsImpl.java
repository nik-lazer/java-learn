package lan.training.advanced.mechanics;

import lan.training.advanced.base.GameMechanics;
import lan.training.advanced.message.Address;
import lan.training.advanced.message.MessageSystem;
import lan.training.advanced.util.TimeHelper;

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
		messageSystem.addService(this);
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
	public Address getAddress() {
		return address;
	}

	@Override
	public void run() {
		while (true) {
			processMessages();
			doGMStep();
			replicateGamesToFrontend();
			TimeHelper.sleep(5000);
		}
	}

	private void replicateGamesToFrontend() {

	}

	private void doGMStep() {

	}

	private void processMessages() {

	}
}
