package lan.training.advanced.resource;

/**
 * Resources for {@link lan.training.advanced.base.AccountService}
 * @author nik-lazer  14.01.2015   12:30
 */
public class AccountResource implements Resource {
	private int runDelay;
	private int authDelay;

	public int getRunDelay() {
		return runDelay;
	}

	public int getAuthDelay() {
		return authDelay;
	}
}
