package lan.training.advanced.account;

import lan.training.advanced.base.AccountService;
import lan.training.advanced.message.Abonent;
import lan.training.advanced.message.Address;
import lan.training.advanced.message.Msg;

/**
 * Abstract message to {@link lan.training.advanced.base.AccountService}
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
