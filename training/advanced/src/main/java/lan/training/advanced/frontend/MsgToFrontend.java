package lan.training.advanced.frontend;

import lan.training.advanced.base.Frontend;
import lan.training.advanced.message.Abonent;
import lan.training.advanced.message.Address;
import lan.training.advanced.message.Msg;

/**
 * Abstract message to {@link lan.training.advanced.base.Frontend}
 * @author nik-lazer  29.12.2014   12:22
 */
public abstract class MsgToFrontend extends Msg {
	public MsgToFrontend(Address from, Address to) {
		super(from, to);
	}

	@Override
	public void exec(Abonent abonent) {
		if (abonent instanceof Frontend) {
			exec((Frontend)abonent);
		}

	}

	public abstract void exec(Frontend abonent);
}
