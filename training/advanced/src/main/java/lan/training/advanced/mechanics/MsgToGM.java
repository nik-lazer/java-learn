package lan.training.advanced.mechanics;

import lan.training.advanced.base.GameMechanics;
import lan.training.advanced.message.Abonent;
import lan.training.advanced.message.Address;
import lan.training.advanced.message.Msg;

/**
 * Created by nik-lazer on 30.12.14.
 */
public abstract class MsgToGM extends Msg {
	public MsgToGM(Address from, Address to) {
		super(from, to);
	}

	@Override
	public void exec(Abonent abonent) {
		if (abonent instanceof GameMechanics) {
			exec((GameMechanics)abonent);
		}
	}

	public abstract void exec(GameMechanics abonent);
}
