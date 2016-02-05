package lan.training.jdk8features;

/**
 * @author nik-lazer 25.04.2014   12:34
 */
public interface I1 {
	String test();
	default String testDouble() {
		return "I1";
	}
}
