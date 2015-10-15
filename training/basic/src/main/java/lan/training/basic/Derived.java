package lan.training.basic;

/**
 * Replacing static field
 * @author nik-lazer  31.08.2015   17:01
 */
public class Derived extends Base {
	public static final int STATE = 1;
}

class Base {
	public static final int STATE = 0;
	public int getState() {
		return STATE;
	}
}
