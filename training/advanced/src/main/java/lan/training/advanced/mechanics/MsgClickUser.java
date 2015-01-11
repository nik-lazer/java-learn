package lan.training.advanced.mechanics;

import lan.training.advanced.base.GameMechanics;
import lan.training.advanced.message.Address;

/**
 * Created by nik-lazer on 02.01.15.
 */
public class MsgClickUser extends MsgToGM {
	private int userId;

	public MsgClickUser(Address from, Address to, int userId) {
		super(from, to);
		this.userId = userId;
	}

	@Override
	public void exec(GameMechanics abonent) {
		abonent.incrementUserClick(userId);
	}
}
