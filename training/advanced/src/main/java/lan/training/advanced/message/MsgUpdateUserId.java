package lan.training.advanced.message;

import lan.training.advanced.jetty.Frontend;

/**
 * Answer message with userId
 * @author nik-lazer  29.12.2014   12:25
 */
public class MsgUpdateUserId extends MsgToFrontend {
	private final String name;
	private final int userId;

	public MsgUpdateUserId(Address from, Address to, String name, int userId) {
		super(from, to);
		this.name = name;
		this.userId = userId;
	}

	@Override
	public void exec(Frontend abonent) {
		abonent.updateUserId(name, userId);
	}

	@Override
	public String toString() {
		return "MsgUpdateUserId{" +
		       "from=" + getFrom() +
		       ", to=" + getTo() +
		       "name='" + name + '\'' +
		       ", userId=" + userId +
		       '}';
	}
}
