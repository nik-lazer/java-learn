package lan.training.advanced.resource;

/**
 * Resources for {@link lan.training.advanced.base.GameMechanics}
 * @author nik-lazer  14.01.2015   12:30
 */
public class GMResource implements Resource {
	private int runDelay;
	private int duration;

	public int getRunDelay() {
		return runDelay;
	}

	public int getDuration() {
		return duration;
	}
}
