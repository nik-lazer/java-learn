package lan.training.jdk8features;

/**
 * TODO: comment
 * @author nik-lazer 25.04.2014   12:34
 */
public interface I2 {
	void test();
	void testDouble();

	default void testThird() {
		System.out.println("I2 third");
	}
}
