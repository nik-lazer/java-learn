package lan.training.advanced.mechanics;

import lan.training.advanced.base.GameMechanics;
import lan.training.advanced.message.Address;

/**
 * Created by nik-lazer on 30.12.14.
 */
public class MsgStartGameSession extends MsgToGM {
	private int userId1;
	private int userId2;

	public MsgStartGameSession(Address from, Address to, int userId1, int userId2) {
		super(from, to);
		this.userId1 = userId1;
		this.userId2 = userId2;
	}

	@Override
	public void exec(GameMechanics abonent) {
		abonent.startGame(userId1, userId2);
	}
}
