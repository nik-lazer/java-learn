package lan.training.advanced.message;

import lan.training.advanced.jetty.Frontend;

/**
 * Abstract message to {@link lan.training.advanced.jetty.Frontend}
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
