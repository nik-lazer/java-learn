package lan.training.jdk8features;

/**
 * TODO: comment
 * @author nik-lazer 25.04.2014   12:34
 */
public interface I1 {
	void test();
	default void testDouble() {
		System.out.println("I1");
	}
}
