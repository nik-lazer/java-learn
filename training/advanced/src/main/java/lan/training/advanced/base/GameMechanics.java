package lan.training.advanced.base;

import lan.training.advanced.message.Abonent;
import lan.training.advanced.message.MessageSystem;

/**
 * Game mechanic service
 * Created by nik-lazer on 30.12.14.
 */
public interface GameMechanics extends Abonent {
	MessageSystem getMessageSystem();
	void startGame(int userId1, int userId2);
	void incrementUserClick(int userId);
}