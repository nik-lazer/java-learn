/**
 * TODO: comment
 * @author lazarev_nv 25.04.2014   12:34
 */
public interface I2 {
	void test();
	void testDouble();

	default void testThird() {
		System.out.println("I2 third");
	}
}
