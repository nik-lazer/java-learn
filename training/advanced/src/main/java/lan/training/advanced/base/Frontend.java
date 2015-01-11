package lan.training.advanced.base;

import lan.training.advanced.mechanics.GameSession;
import lan.training.advanced.message.Abonent;
import lan.training.advanced.message.MessageSystem;
import lan.training.advanced.message.MessageSystemImpl;

/**
 * Frontend interface
 * Created by nik-lazer on 29.12.14.
 */
public interface Frontend extends Abonent {
	MessageSystem getMessageSystem();
	void updateUserId(String name, int userId);
	void replicateGameSession(GameSession gameSession);
}
