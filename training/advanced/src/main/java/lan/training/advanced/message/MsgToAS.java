package lan.training.advanced.message;

import lan.training.advanced.jetty.AccountService;

/**
 * Abstract message to {@link lan.training.advanced.jetty.AccountService}
 * @author nik-lazer  29.12.2014   12:29
 */
public abstract class MsgToAS extends Msg {

	public MsgToAS(Address from, Address to) {
		super(from, to);
	}

	@Override
	public void exec(Abonent abonent) {
		if (abonent instanceof AccountService) {
			exec((AccountService)abonent);
		}
	}

	protected abstract void exec(AccountService abonent);
}
