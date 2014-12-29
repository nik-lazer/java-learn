package lan.training.advanced.message;

import lan.training.advanced.jetty.AccountService;

/**
 * Message for requesting user id by login
 * @author nik-lazer  29.12.2014   12:32
 */
public class MsgGetUserId extends MsgToAS {
	private final String name;

	public MsgGetUserId(Address from, Address to, String name) {
		super(from, to);
		this.name = name;
	}

	@Override
	protected void exec(AccountService abonent) {
		Integer id = abonent.getUserId(name);
		abonent.getMessageSystem().sendMessage(new MsgUpdateUserId(getTo(), getFrom(), name, id));
	}

	@Override
	public String toString() {
		return "MsgGetUserId{" +
		       "from=" + getFrom() +
		       ", to=" + getTo() +
		       "name='" + name + '\'' +
		       '}';
	}
}
