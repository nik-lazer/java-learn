package lan.training.jdk8features;

/**
 * @author nik-lazer 25.04.2014   12:34
 */
public interface I2 {
	String test();
	String testDouble();

	default String testThird() {
		return "I2 third";
	}
}
